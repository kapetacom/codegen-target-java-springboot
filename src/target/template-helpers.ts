/**
 * Copyright 2023 Kapeta Inc.
 * SPDX-License-Identifier: MIT
 */
import Handlebars = require('handlebars');
import { Template, toTypeName, TypeLike } from '@kapeta/codegen-target';
import { BlockDefinitionSpec, Resource } from '@kapeta/schemas';
import { parseKapetaUri } from '@kapeta/nodejs-utils';
import _ from 'lodash';

function ucfirst(typeLike: TypeLike) {
    let text = toTypeName(typeLike);

    return text.substring(0, 1).toUpperCase() + text.substring(1);
}

export type HandleBarsType = typeof Handlebars;

export const addTemplateHelpers = (engine: HandleBarsType, data: any, context: any): void => {
    function isEntity(type: TypeLike) {
        if (!type || !context.spec || !context.spec.entities || !context.spec.entities.types) {
            return false;
        }

        const typeName = toTypeName(type).toLowerCase();

        return !!_.find(context.spec.entities.types, (entity) => {
            return entity && entity.name && entity.name.toLowerCase() === typeName && entity.type === 'dto';
        });
    }

    function isPrimitive(type: TypeLike): boolean {
        if (!type) {
            return false;
        }

        if (typeof type !== 'string' && typeof type.type !== 'string') {
            return false;
        }

        const typeName = toTypeName(type).toLowerCase();

        switch (typeName) {
            case 'int':
            case 'integer':
            case 'boolean':
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

    function translatePrimitive(typeName: string): string {
        switch (typeName) {
            case 'integer':
                return 'int';
            default:
                return typeName;
        }
    }

    function packageNameHelper(packageName: string): string {
        return packageName
            .replace(/-/g, '_');
    }

    function classHelper(typeName: TypeLike, options: any = null): Handlebars.SafeString {
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

    function classHelperName(typeName: string, options: any): Handlebars.SafeString {
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

        if (typeName === 'Instance') {
            return Template.SafeString('InstanceValue');
        }

        if (typeName === 'InstanceProvider') {
            return Template.SafeString('InstanceProviderValue');
        }

        if (isEntity(typeName)) {
            return Template.SafeString(ucfirst(typeName) + (asType ? '' : 'DTO'));
        }

        if (['any', 'unknown'].includes(typeName.toLowerCase())) {
            return Template.SafeString('Object');
        }

        if (isPrimitive(typeName)) {
            return Template.SafeString(translatePrimitive(typeName.toLowerCase()));
        }

        return Template.SafeString(ucfirst(typeName));
    }

    function isList(typeName: string) {
        return typeName.endsWith('[]');
    }

    engine.registerHelper('class', classHelper);

    const classFrom = (property: TypeLike, options: any): any => {
        const typeName = toTypeName(property);
        if (isList(typeName)) {
            return Template.SafeString(`List<${classFrom(typeName.substring(0, typeName.length - 2), options)}>`);
        }

        return classHelper(property, options);
    };

    engine.registerHelper('packageName', (name) => Template.SafeString(packageNameHelper(name)));
    engine.registerHelper('classFrom', classFrom);

    engine.registerHelper('ifPrimitive', (type: TypeLike, options: any) => {
        const typeName = toTypeName(type).toLowerCase();
        if (isPrimitive(type) || typeName === 'string') {
            return Template.SafeString(options.fn(this));
        }
        return Template.SafeString(options.inverse(this));
    });

    engine.registerHelper('returnType', (type: TypeLike, options: any) => {
        const isUCFirst = options.hash && options.hash.ucfirst;
        if (!type) {
            return isUCFirst ? 'Void' : 'void';
        }

        const out = classHelper(type);

        if (isUCFirst) {
            return Template.SafeString(ucfirst(out.toString()));
        }

        return out;
    });

    engine.registerHelper('packagePath', (packageName) => {
        return Template.SafeString(packageNameHelper(packageName).replace(/\./g, '/'));
    });

    engine.registerHelper('relativePath', (path) => {
        return Template.SafeString(path.trim().replace(/^\/+/g, ''));
    });

    engine.registerHelper('kebab', (camelCase) => {
        return Template.SafeString(camelCase.replace(/([a-z])([A-Z])/g, '$1-$2').toLowerCase());
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

    engine.registerHelper('anyEntities', (options) => {
        if (context?.spec?.entities?.types && context?.spec?.entities?.types.length > 0) {
            return options.fn(this);
        }
        return options.inverse(this);
    });

    engine.registerHelper('params', function (this: any) {
        let argument = undefined;
        let optional = false;

        const body = 'transport' in this && this['transport'].toUpperCase() === 'BODY';
        const header = 'transport' in this && this['transport'].toUpperCase() === 'HEADER';

        if ('argumentName' in this && !body && !header) {
            argument = '"' + this['argumentName'] + '"';
        }
        if ('argument' in this && header) {
            argument = '"' + this['argument'] + '"';
        }

        if ('optional' in this && this['optional']) {
            optional = true;
        }

        if (argument) {
            return `(${optional ? `name = ${argument}, required = false` : argument})`;
        } else if (optional) {
            return `(required = false)`;
        }

        return '';
    });

    engine.registerHelper('toArray', (...value: any[]) => {
        return value.slice(0, value.length - 1);
    });

    engine.registerHelper('usesAnyOf', (kinds: string[], options) => {
        const data = context.spec as BlockDefinitionSpec;
        const usesAny = kinds.some((kind) => {
            const uri = parseKapetaUri(kind);
            const matcher = (consumer: Resource) => parseKapetaUri(consumer.kind).fullName === uri.fullName;
            return data.consumers?.some(matcher) || data.providers?.some(matcher);
        });

        if (usesAny) {
            return options.fn(this);
        }

        return options.inverse(this);
    });
};
