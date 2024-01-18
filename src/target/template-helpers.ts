/**
 * Copyright 2023 Kapeta Inc.
 * SPDX-License-Identifier: MIT
 */
import Handlebars = require('handlebars');
import { parseEntities, Template, toTypeName, TypeLike } from '@kapeta/codegen-target';
import _ from 'lodash';
import {
    ControllerWriteMethod,
    DATATYPE_CONFIGURATION,
    DataTypeReader,
    DataTypeWriteMethod,
    DSLController,
    DSLData,
    DSLDataType,
    DSLEntity,
    DSLEntityType,
    DSLEnum,
    DSLParser,
    DSLReferenceResolver,
    DSLResult,
    EntityHelpers,
    JavaWriter,
    ucFirst,
} from '@kapeta/kaplang-core';
import { HelperOptions } from 'handlebars';
import { includes } from '../includes';

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

        if (typeof type === 'string') {
            return EntityHelpers.isPrimitiveType({ type });
        }

        return EntityHelpers.isPrimitiveType(type);
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
        return packageName ? packageName.replace(/-/g, '_') : '';
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
            return Template.SafeString(ucFirst(typeName) + (asType ? '' : 'DTO'));
        }

        if (['any', 'unknown'].includes(typeName.toLowerCase())) {
            return Template.SafeString('Object');
        }

        if (isPrimitive(typeName)) {
            return Template.SafeString(translatePrimitive(typeName.toLowerCase()));
        }

        return Template.SafeString(ucFirst(typeName));
    }

    function isList(typeName: string) {
        return typeName.endsWith('[]');
    }

    const classFrom = (property: TypeLike, options: any): any => {
        const typeName = toTypeName(property);
        if (isList(typeName)) {
            return Template.SafeString(`List<${classFrom(typeName.substring(0, typeName.length - 2), options)}>`);
        }

        return classHelper(property, options);
    };

    let parsedEntities: DSLData[] | undefined = undefined;
    function getParsedEntities(): DSLData[] {
        if (!parsedEntities) {
            const code: string[] = [includes().source];

            if (context.spec?.entities?.source?.value) {
                code.push(context.spec?.entities?.source?.value);
            }

            parsedEntities = parseEntities(code.join('\n\n'));
        }

        if (!parsedEntities) {
            return [];
        }

        return parsedEntities as DSLData[];
    }

    engine.registerHelper('class', classHelper);

    engine.registerHelper('packageName', (name) => Template.SafeString(packageNameHelper(name)));

    engine.registerHelper('packagePath', (packageName) => {
        return Template.SafeString(packageNameHelper(packageName).replace(/\./g, '/'));
    });

    engine.registerHelper('java-imports', function (this: DSLEntity, options: HelperOptions) {
        const entities = getParsedEntities();
        const basePackage: string = options.data.root.options.basePackage;
        const resolver = new DSLReferenceResolver();
        const referencesEntities = resolver.resolveReferencesFrom([this], entities);

        if (referencesEntities.length === 0) {
            return '';
        }

        return Template.SafeString(
            referencesEntities
                .map((entity) => {
                    const native = DataTypeReader.getNative(entity);
                    if (native) {
                        return `import ${native};`;
                    }

                    switch (entity.type) {
                        case DSLEntityType.DATATYPE:
                            return `import ${basePackage}.dto.${JavaWriter.toClassName(entity.name)}DTO;`;
                        case DSLEntityType.ENUM:
                            return `import ${basePackage}.dto.${JavaWriter.toClassName(entity.name)};`;
                    }
                })
                .join('\n')
        );
    });

    engine.registerHelper('java-generics', (entity: DSLDataType) => {
        if (!entity.generics || entity.generics.length === 0) {
            return '';
        }

        return Template.SafeString(`<${entity.generics.join(', ')}>`);
    });

    engine.registerHelper('java-class-name', (entity: DSLEntity) => {
        if (entity.type === DSLEntityType.COMMENT) {
            return '';
        }

        if (entity.type === DSLEntityType.CONTROLLER) {
            return Template.SafeString(JavaWriter.toClassName(entity.name, entity.namespace));
        }

        return Template.SafeString(JavaWriter.toClassName(entity.name));
    });

    engine.registerHelper('java-type-dto', (entity: DSLData) => {
        const writer = new JavaWriter({
            entities: getParsedEntities(),
            dataTypeWriteMethod: DataTypeWriteMethod.DTO,
        });

        try {
            return Template.SafeString(writer.write([entity]));
        } catch (e) {
            console.warn('Failed to write entity', entity);
            throw e;
        }
    });

    engine.registerHelper('java-type-config', (entity: DSLDataType | DSLEnum, basePackage: string, options) => {
        const writer = new JavaWriter({
            entities: getParsedEntities(),
            dataTypeWriteMethod: DataTypeWriteMethod.CONFIG,
        });

        try {
            return Template.SafeString(writer.write([entity]));
        } catch (e) {
            console.warn('Failed to write entity', entity);
            throw e;
        }
    });

    engine.registerHelper('java-controller-rest', (entity: DSLController) => {
        const writer = new JavaWriter({
            controllerWriteMethod: ControllerWriteMethod.REST_CONTROLLER,
            entities: getParsedEntities(),
        });

        return Template.SafeString(writer.write([entity]));
    });

    engine.registerHelper('java-controller-if', (entity: DSLController) => {
        const writer = new JavaWriter({
            controllerWriteMethod: ControllerWriteMethod.INTERFACE,
            entities: getParsedEntities(),
        });

        return Template.SafeString(writer.write([entity]));
    });

    engine.registerHelper('java-controller-class', (entity: DSLController) => {
        const writer = new JavaWriter({
            controllerWriteMethod: ControllerWriteMethod.CLASS,
            entities: getParsedEntities(),
        });

        return Template.SafeString(writer.write([entity]));
    });

    engine.registerHelper('java-controller-client', (entity: DSLController) => {
        const writer = new JavaWriter({
            controllerWriteMethod: ControllerWriteMethod.CLIENT,
            entities: getParsedEntities(),
        });

        return Template.SafeString(writer.write([entity]));
    });
};
