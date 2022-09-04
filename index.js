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
                !context.spec.entities) {
                return false;
            }

            if (type.$ref) {
                type = type.$ref;
            }

            type = type.toLowerCase();
            return !!_.find(context.spec.entities, (entity) => {
                return (entity && entity.name && entity.name.toLowerCase() === type);
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

        function classHelper(typeName) {

            if (!typeName) {
                return typeName;
            }

            if (typeName.$ref) {
                typeName = typeName.$ref;
            }

            const list = isList(typeName);

            if (list) {
                typeName = typeName.substr(0, typeName.length - 2);
                return Template.SafeString(`List<${classHelperName(typeName)}>`);
            }

            return classHelperName(typeName);
        }

        function classHelperName(typeName) {
            if (isEntity(typeName)) {
                return ucfirst(typeName) + 'DTO';
            }

            if (isPrimitive(typeName)) {
                return typeName.toLowerCase();
            }

            return Template.SafeString(ucfirst(typeName));
        }

        function isList(typeName) {
            return typeName.endsWith('[]');
        }

        engine.registerHelper('class', classHelper);

        engine.registerHelper('returnType', (type) => {
            if (!type) {
                return 'void';
            }

            return classHelper(type);
        });

        engine.registerHelper('packagePath', (packageName) => {
            return Template.SafeString(packageName.replace(/\./g, '/'));
        });

        engine.registerHelper('relativePath', (path) => {
            return Template.SafeString(path.trim().replace(/^\/+/g, ''));
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