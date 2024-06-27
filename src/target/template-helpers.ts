/**
 * Copyright 2023 Kapeta Inc.
 * SPDX-License-Identifier: MIT
 */
import Handlebars = require('handlebars');
import {OPTION_CONTEXT_AI, parseEntities, Template, toTypeName, TypeLike} from '@kapeta/codegen-target';
import _ from 'lodash';
import {
    ControllerWriteMethod,
    DataTypeReader,
    DataTypeWriteMethod,
    DSLController,
    DSLData,
    DSLDataType,
    DSLEntity,
    DSLEntityType,
    DSLEnum,
    DSLModel,
    DSLModelProperty,
    DSLParser,
    DSLReferenceResolver,
    EntityHelpers,
    JavaWriter,
    MODEL_CONFIGURATION,
    ucFirst,
} from '@kapeta/kaplang-core';
import {HelperOptions} from 'handlebars';
import {includes} from '../includes';
import * as pluralize from 'pluralize';
import {Resource} from "@kapeta/schemas";

export type HandleBarsType = typeof Handlebars;

export const addTemplateHelpers = (engine: HandleBarsType, contextOptions:any, data: any, context: any): void => {
    if (!contextOptions) {
        contextOptions = {};
    }
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

    let possibleModels: ModelResult[] | undefined = undefined;
    function getPossibleModels(): ModelResult[] {
        if (!possibleModels) {
            possibleModels = extractModels(context?.spec?.consumers);
        }
        return possibleModels ?? [];
    }

    function extractModels(consumers: Resource[]): ModelResult[] {
        return consumers
            .filter((consumer) => consumer.spec.port?.type == "postgres")
            .flatMap((consumer) => {
            const results = DSLParser.parse(consumer.spec.source.value, {
                ...MODEL_CONFIGURATION,
                ignoreSemantics: true, // We're expecting valid code - this is not a good place to validate
            });
            return { name: consumer.metadata.name, models: results.entities as DSLModel[] };
        });
    }

    interface ModelResult {
        name: string;
        models: DSLModel[];
    }

    function jwtCandidate(): boolean {
        return context.spec?.providers?.find((provider: Resource) => provider.kind.indexOf('kapeta/resource-type-auth-jwt-provider') > -1) != undefined;
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

        const imports: string[] = [];

        imports.push(...(referencesEntities
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
            })));

        if (Boolean(OPTION_CONTEXT_AI in contextOptions)) {
            imports.push(...(getPossibleModels().flatMap((possibleModel) => {
                return possibleModel.models.flatMap((model) => {
                    return [
                        `import ${basePackage}.repositories.${possibleModel.name}.${JavaWriter.toClassName(model.name)};`,
                        `import ${basePackage}.repositories.${possibleModel.name}.${JavaWriter.toClassName(model.name)}Repository;`,
                    ];
                });
            })));
        }

        if (Boolean(OPTION_CONTEXT_AI in contextOptions) && jwtCandidate()) {
            imports.push('import com.kapeta.spring.security.provider.JWTCreatorService;',
                'import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;');
        }

        return Template.SafeString(imports.join('\n\n'));
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
            aiContext: Boolean(OPTION_CONTEXT_AI in contextOptions),
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
            aiContext: Boolean(OPTION_CONTEXT_AI in contextOptions),

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
            aiContext: Boolean(OPTION_CONTEXT_AI in contextOptions),
        });

        return Template.SafeString(writer.write([entity]));
    });

    engine.registerHelper('java-controller-if', (entity: DSLController) => {
        const writer = new JavaWriter({
            controllerWriteMethod: ControllerWriteMethod.INTERFACE,
            entities: getParsedEntities(),
            aiContext: Boolean(OPTION_CONTEXT_AI in contextOptions),
        });

        return Template.SafeString(writer.write([entity]));
    });

    engine.registerHelper('java-controller-class', (entity: DSLController) => {
        let classProperties: string[] | undefined = undefined;
        if (Boolean(OPTION_CONTEXT_AI in contextOptions)) {
            classProperties = ['ModelMapper modelMapper'];
            if (jwtCandidate()) {
                classProperties.push('JWTCreatorService jwtCreatorService');
                classProperties.push('BCryptPasswordEncoder passwordEncoder');
            }
            getPossibleModels().forEach((possibleModel) => {
                classProperties!.push(`${JavaWriter.toClassName(possibleModel.name)}Repository ${possibleModel.name}Repository`);
            });
        }

        const writer = new JavaWriter({
            controllerWriteMethod: ControllerWriteMethod.CLASS,
            entities: getParsedEntities(),
            aiContext: Boolean(OPTION_CONTEXT_AI in contextOptions),
            classProperties: classProperties,
        });

        return Template.SafeString(writer.write([entity]));
    });

    engine.registerHelper('java-controller-client', (entity: DSLController) => {
        const writer = new JavaWriter({
            controllerWriteMethod: ControllerWriteMethod.CLIENT,
            entities: getParsedEntities(),
            aiContext: Boolean(OPTION_CONTEXT_AI in contextOptions),
        });

        return Template.SafeString(writer.write([entity]));
    });

    engine.registerHelper('kaplang-model-type-declaration', (model: DSLModelProperty) => {
        const writer = new JavaWriter({
            aiContext: Boolean(OPTION_CONTEXT_AI in contextOptions),
        });
        return Template.SafeString(writer.toModelPropertyCode(model));
    });

    engine.registerHelper('kaplang-model-description', (model: DSLModel) => {
        const lines = (model.description ?? '')
            .split('\n')
            .map(line => '* ' + line);
        return Template.SafeString(lines.join('\n'));
    });

    engine.registerHelper('kaplang-model-tablename', function (typeName, options) {
        const className = classHelper(typeName, options).toString().toLowerCase();
        return new engine.SafeString(pluralize.plural(className));
    });
};
