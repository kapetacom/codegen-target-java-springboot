const {describe, test, beforeEach} =  require("@jest/globals");

const Target = require('../../index');
const {CodegenHelpers, BlockCodeGenerator} = require('@kapeta/codegen');
const Path = require("path");
const data = require("../resources/examples/todo.kapeta.yml");

describe('blocks', () => {
    let target;

    beforeEach(() => {
        target = new Target({
            basePackage: 'org.mycompany.services.todo',
            groupId: 'org.mycompany.services',
            artifactId: 'todo'
        });
    })

    test('todo', async () => {

        const basedir = Path.resolve(__dirname, '../resources/examples/todo');
        const data = require('../resources/examples/todo.kapeta.yml');

        return CodegenHelpers.testCodeGenFor(target, new BlockCodeGenerator(data), basedir);
    });

    test('users', async () => {

        const basedir = Path.resolve(__dirname, '../resources/examples/users');
        const data = require('../resources/examples/users.kapeta.yml');

        return CodegenHelpers.testCodeGenFor(target, new BlockCodeGenerator(data), basedir);
    });

})