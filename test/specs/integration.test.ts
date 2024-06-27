import Path, {join} from 'path';
import {beforeEach, describe, expect, test} from '@jest/globals';
import {BlockCodeGenerator, CodegenHelpers, GeneratedResult} from '@kapeta/codegen';
import Target from '../../src';
import * as fs from "node:fs";

describe('blocks', () => {
    let target: Target;
    let aiTarget: Target;

    beforeEach(() => {
        target = new Target({
            basePackage: 'org.mycompany.services.todo',
            groupId: 'org.mycompany.services',
            artifactId: 'todo',
        });

        aiTarget = new Target({
            basePackage: 'ai.kapeta.crmapp',
            groupId: 'ai.kapeta.crmapp',
            artifactId: 'ai-users',
            'AIContext': 'storm',
        });
    });

    test('todo', async () => {
        const basedir = Path.resolve(__dirname, '../resources/examples/todo');
        const data = require('../resources/examples/todo.kapeta.yml');

        return CodegenHelpers.testCodeGenFor(
            target,
            new BlockCodeGenerator(data),
            basedir,
            (path) => !path.includes('/todo/target/')
        );
    });

    test('users', async () => {
        const basedir = Path.resolve(__dirname, '../resources/examples/users');
        const data = require('../resources/examples/users.kapeta.yml');

        return CodegenHelpers.testCodeGenFor(
            target,
            new BlockCodeGenerator(data),
            basedir,
            (path) => !path.includes('/users/target/')
        );
    });

    test('ai-users', async () => {
        let result = await aiGenerate(require('../resources/examples/ai-users.kapeta.yml'));
        const usersService = result.files.find((file) => file.filename.endsWith("/UsersUsersService.java"));
        expect(usersService).toBeDefined();

        const expected = fs.readFileSync(join(Path.resolve(__dirname, '../resources/examples/ai-users'), 'UsersUsersService.java'), 'utf8');
        expect(usersService!.content).toBe(expected);
    });

    test('ai-reports', async() => {
        let result = await aiGenerate(require('../resources/examples/ai-reports.kapeta.yml'));
        const reportsService = result.files.find((file) => file.filename.endsWith("/ReportsReportsService.java"));
        expect(reportsService).toBeDefined();

        const expected = fs.readFileSync(join(Path.resolve(__dirname, '../resources/examples/ai-reports'), 'ReportsReportsService.java'), 'utf8');
        expect(reportsService!.content).toBe(expected);
    });

    async function aiGenerate(data: any): Promise<GeneratedResult> {
        const blockCodeGenerator = new BlockCodeGenerator(data).withOption('AIContext', 'storm');
        return await blockCodeGenerator.generateForTarget(aiTarget as any);
    }
});
