const {Target, Template} = require('@blockware/codegen-target');
const prettier = require("prettier");

function ucfirst(text) {
    return text.substr(0,1).toUpperCase() + text.substr(1);
}

class Java8SpringBoot2Target extends Target {

    constructor(options) {
        super(options, __dirname);
    }

    _createTemplateEngine(data) {
        const engine = super._createTemplateEngine(data);

        function isEntity(type) {
            return !!_.find(data.spec.entities, {name: type});
        }

        function isPrimitive(type) {
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
            if (isEntity(typeName)) {
                return ucfirst(typeName) + 'DTO';
            }

            if (isPrimitive(typeName)) {
                return typeName.toLowerCase();
            }

            return Template.SafeString(ucfirst(typeName));
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