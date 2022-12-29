const {Target, Template} = require('@blockware/codegen-target');
const prettier = require("prettier");
const _ = require('lodash');

function ucfirst(text) {
    if (text.$ref) {
        text = text.$ref;
    }

    return text.substr(0,1).toUpperCase() + text.substr(1);
}

class Java8SpringBoot2Target extends Target {

    constructor(options) {
        super(options, __dirname);
    }

    _createTemplateEngine(data, context) {
        const engine = super._createTemplateEngine(data, context);

        function isEntity(type) {
            if (!type || 
                !context.spec ||
                !context.spec.entities ||
                !context.spec.entities.types) {
                return false;
            }

            if (type.$ref) {
                type = type.$ref;
            }

            type = type.toLowerCase();
            return !!_.find(context.spec.entities.types, (entity) => {
                return (entity && entity.name && entity.name.toLowerCase() === type && entity.type === 'dto');
            });
        }

        function isPrimitive(type) {
            if (!type) {
                return false;
            }

            if (typeof type !== 'string') {
                throw new Error('Type must be a string but was: ' + typeof type + '. Value: ' + JSON.stringify(type));
            }

            switch (type.toLowerCase()) {
                case 'boolean':
                case 'int':
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

        function classHelper(typeName, options) {

            if (!typeName) {
                return typeName;
            }

            if (typeName.$ref) {
                typeName = typeName.$ref;
            }

            if (typeName.indexOf('/') > -1) {
                typeName = typeName.split(/\//)[1];
            }

            if (typeName.indexOf('-') > -1) {
                typeName = _.camelCase(typeName);
            }

            const list = isList(typeName);

            if (list) {
                typeName = typeName.substring(0, typeName.length - 2);
                return Template.SafeString(`List<${classHelperName(typeName, options)}>`);
            }

            return classHelperName(typeName, options);
        }

        function classHelperName(typeName, options) {
            const asType = !!(options && options.hash['type']);
            if (isEntity(typeName)) {
                return Template.SafeString(ucfirst(typeName) + (asType ? '' : 'DTO'));
            }

            if (isPrimitive(typeName)) {
                return Template.SafeString(typeName.toLowerCase());
            }

            return Template.SafeString(ucfirst(typeName));
        }

        function isList(typeName) {
            return typeName.endsWith('[]');
        }

        engine.registerHelper('class', classHelper);

        const classFrom = (property, options) => {
            switch(property.type) {
                case 'array':
                    return Template.SafeString(`List<${classFrom(property.items, options)}>`);
                case 'object':
                    //TODO: Create inner class
                    break;
            }

            return classHelper(property.type, options);
        }

        engine.registerHelper('classFrom', classFrom);


        engine.registerHelper('returnType', (type, options) => {
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

        return engine;
    }

    _postProcessCode(filename, code) {

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
                parser: parser
            });
        } catch (e) {
            console.log('Failed to prettify source: ' + filename + '. ' + e);
            return code;
        }
    }
}


module.exports = Java8SpringBoot2Target;