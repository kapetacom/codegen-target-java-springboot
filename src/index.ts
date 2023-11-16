/**
 * Copyright 2023 Kapeta Inc.
 * SPDX-License-Identifier: MIT
 */

import {Target, Template, TypeLike, toTypeName} from '@kapeta/codegen-target';
import prettier from "@prettier/sync";
import _ from 'lodash';
import Path from "path";
import {GeneratedFile, SourceFile} from "@kapeta/codegen";
import cheerio from "cheerio";
import Handlebars from "handlebars";


function ucfirst(typeLike:TypeLike) {
    let text = toTypeName(typeLike);

    return text.substring(0,1).toUpperCase() + text.substring(1);
}
type MapUnknown = { [key: string]: any };
function decodeEntities(encodedString:string) {
    const translate_re = /&(nbsp|amp|quot|lt|gt);/g;
    const translate:any = {
        "nbsp":" ",
        "amp" : "&",
        "quot": "\"",
        "lt"  : "<",
        "gt"  : ">"
    };
    return encodedString.replace(translate_re, function(match, entity) {
        return translate[entity];
    }).replace(/&#(\d+);/gi, function(match, numStr) {
        const num = parseInt(numStr, 10);
        return String.fromCharCode(num);
    }).replace(/&#x(\d+);/gi, function(match, numStr) {
        const num = parseInt(numStr, 16);
        return String.fromCharCode(num);
    });
}

const KAPETA_GROUP_ID = 'com.kapeta';

export default class Java8SpringBoot2Target extends Target {

    constructor(options:any) {
        super(options, Path.resolve(__dirname,'../'));
    }

    mergeFile(sourceFile: SourceFile, newFile: GeneratedFile): GeneratedFile {
        if (sourceFile.filename === "pom.xml") {
            // We can merge the dependencies into existing pom.xml without overwriting
            // the existing user adjusted content

            const targetDoc = cheerio.load(sourceFile.content, {
                xmlMode: true
            });

            const newDoc = cheerio.load(newFile.content, {
                xmlMode: true
            });

            const targetDependencies = targetDoc('dependencies > dependency');
            const newDependencies = newDoc('dependencies > dependency');

            const targetDependenciesList = targetDependencies.toArray();
            const newDependenciesList = newDependencies.toArray();
            if (newDependenciesList && targetDependenciesList) {
                newDependenciesList.forEach((newDependency) => {
                    const newGroupId = newDoc('groupId', newDependency).text();
                    const newArtifactId = newDoc('artifactId', newDependency).text();
                    const newVersion = newDoc('version', newDependency).text();
                    if (KAPETA_GROUP_ID !== newGroupId) {
                        return;
                    }

                    const existing = targetDependenciesList.find((targetChild) => {
                        if (KAPETA_GROUP_ID !== targetDoc('groupId', targetChild).text()) {
                            return false;
                        }

                        return newArtifactId === targetDoc('artifactId', targetChild).text();
                    });

                    if (existing) {
                        const targetVersion = targetDoc('version', existing);
                        const existingVersion = targetVersion.text();
                        if (existingVersion !== newVersion) {
                            targetVersion.text(newVersion);
                        }
                    } else {
                        // @ts-ignore
                        const $newDependency = newDoc(newDependency).clone();
                        targetDependencies.last().after(`\n        <dependency>${$newDependency.html()}</dependency>`);
                    }
                });
            }

            return {
                ...newFile,
                content: decodeEntities(targetDoc.xml()),
            };
        }

        if (sourceFile.filename === ".devcontainer/devcontainer.json") {
            // We can merge the environment variables prefixed with KAPETA_ into the containerEnv
            const target = JSON.parse(sourceFile.content);
            const newContent = JSON.parse(newFile.content);
            if (!target.containerEnv) {
                target.containerEnv = {};
            }

            const containerEnv: MapUnknown = {
                ...(newContent.containerEnv ?? {}),
            };
            Object.entries(target.containerEnv).forEach(([key, value]) => {
                if (key.toLowerCase().startsWith("kapeta_")) {
                    return;
                }
                containerEnv[key] = value;
            });

            target.containerEnv = containerEnv;

            return {
                ...newFile,
                content: JSON.stringify(target, null, 4),
            };
        }

        return super.mergeFile(sourceFile, newFile);
    }

    protected _createTemplateEngine(data:any, context:any) {
        const engine = super._createTemplateEngine(data, context);

        function isEntity(type:TypeLike) {
            if (!type || 
                !context.spec ||
                !context.spec.entities ||
                !context.spec.entities.types) {
                return false;
            }

            const typeName = toTypeName(type).toLowerCase();

            return !!_.find(context.spec.entities.types, (entity) => {
                return (entity && entity.name && entity.name.toLowerCase() === typeName && entity.type === 'dto');
            });
        }

        function isPrimitive(type:TypeLike):boolean {
            if (!type) {
                return false;
            }

            if (typeof type !== 'string' && typeof type.type !== 'string') {
                return false;
            }

            const typeName = toTypeName(type).toLowerCase();

            switch (typeName) {
                case 'boolean':
                case 'int':
                case 'integer':
                case 'float':
                case 'double':
                case 'long':
                case 'byte':
                case 'short':
                case 'char':
                case 'void':
                    return true;
            }

            return false;
        }

        function classHelper(typeName:TypeLike, options:any = null):Handlebars.SafeString {
            if (!typeName) {
                return Template.SafeString('void');
            }

            let typeText = toTypeName(typeName);

            if (typeText.indexOf('/') > -1) {
                typeText = typeText.split(/\//)[1];
            }

            if (typeText.indexOf('-') > -1) {
                typeText = _.camelCase(typeText);
            }

            const list = isList(typeText);

            if (list) {
                typeText = typeText.substring(0, typeText.length - 2);
                return Template.SafeString(`List<${classHelperName(typeText, options)}>`);
            }

            return classHelperName(typeText, options);
        }

        function classHelperName(typeName:string, options:any):Handlebars.SafeString {
            const asType = !!(options && options.hash['type']);

            if (typeName.includes('<')) {
                // Has generics
                const [baseType, genericText] = typeName.split('<');
                const genericTypes = genericText.substring(0, genericText.length - 1).split(/\s*,\s*/);
                const genericTypeNames = genericTypes.map((genericType) => {
                    return classHelper(genericType);
                });
                typeName = baseType + '<' + genericTypeNames.join(',') + '>';
            }

            if (isEntity(typeName)) {
                return Template.SafeString(ucfirst(typeName) + (asType ? '' : 'DTO'));
            }

            if (['any','unknown'].includes(typeName.toLowerCase())) {
                return Template.SafeString('Object');
            }

            if (isPrimitive(typeName)) {
                return Template.SafeString(typeName.toLowerCase());
            }

            return Template.SafeString(ucfirst(typeName));
        }

        function isList(typeName:string) {
            return typeName.endsWith('[]');
        }

        engine.registerHelper('class', classHelper);

        const classFrom = (property:TypeLike, options:any):any => {

            const typeName = toTypeName(property);
            if (isList(typeName)) {
                return Template.SafeString(`List<${classFrom(typeName.substring(0, typeName.length - 2), options)}>`);
            }

            return classHelper(property, options);
        }

        engine.registerHelper('classFrom', classFrom);

        engine.registerHelper('ifPrimitive', (type:TypeLike, options:any) => {
            const typeName = toTypeName(type).toLowerCase();
            if (isPrimitive(type) || typeName === 'string') {
                return Template.SafeString(options.fn(this));
            }
            return Template.SafeString(options.inverse(this));
        })

        engine.registerHelper('returnType', (type:TypeLike, options:any) => {
            const isUCFirst = options.hash && options.hash.ucfirst;
            if (!type) {
                return isUCFirst ? 'Void' :'void' ;
            }

            const out = classHelper(type);

            if (isUCFirst) {
                return Template.SafeString(ucfirst(out.toString()));
            }

            return out;
        });

        engine.registerHelper('packagePath', (packageName) => {
            return Template.SafeString(packageName.replace(/\./g, '/'));
        });

        engine.registerHelper('relativePath', (path) => {
            return Template.SafeString(path.trim().replace(/^\/+/g, ''));
        });

        engine.registerHelper('enumValues', (values) => {
            return Template.SafeString('\t' + values.join(',\n\t'));
        });

        engine.registerHelper('when', (type, options) => {
            const inner = options.fn();
            const [whenTrue, whenFalse] = inner.split(/\|\|/);
            if (options.hash && options.hash.type === type) {
                return Template.SafeString(whenTrue);
            }
            return Template.SafeString(whenFalse || '');
        });

        engine.registerHelper('ifValueType', (type, options) => {
            if ((type?.type || type?.ref) && type?.type?.toLowerCase() !== 'void') {
                return Template.SafeString(options.fn(this));
            }
            return Template.SafeString(options.inverse(this));
        });

        return engine;
    }

    protected _postProcessCode(filename:string, code:string):string {

        let parser = null;
        let tabWidth = 4;

        if (filename.endsWith('.java')) {
            parser = 'java';
        }

        if (filename.endsWith('.yaml') ||
            filename.endsWith('.yml')) {
            parser = 'yaml';
            tabWidth = 2;
        }

        if (!parser) {
            return code;
        }

        try {
            return prettier.format(code, {
                tabWidth: tabWidth,
                parser: parser,
                plugins: [
                    require.resolve('prettier-plugin-java')
                ],
            });
        } catch (e) {
            console.log('Failed to prettify source: ' + filename + '. ' + e);
            return code;
        }
    }
}