/**
 * Copyright 2023 Kapeta Inc.
 * SPDX-License-Identifier: MIT
 */

import { Target } from '@kapeta/codegen-target';
import type { SourceFile, GeneratedFile } from '@kapeta/codegen-target';
import type { ValidationResult } from '@kapeta/codegen';
import prettier from 'prettier';
import Path from 'path';
import { mergeDevcontainers } from './target/merge-devcontainers';
import { addTemplateHelpers } from './target/template-helpers';
import { mergePom } from './target/merge-pom';

import { spawn } from 'node:child_process';

const LANGUAGE = "java";

export default class JavaSpringBootTarget extends Target {
    constructor(options: any) {
        super(options, Path.resolve(__dirname, '../'));
    }

    mergeFile(sourceFile: SourceFile, newFile: GeneratedFile, lastFile: GeneratedFile): GeneratedFile {
        if (sourceFile.filename === 'pom.xml') {
            return mergePom(sourceFile, newFile, lastFile);
        }

        if (sourceFile.filename === '.devcontainer/devcontainer.json') {
            return mergeDevcontainers(sourceFile, newFile, lastFile);
        }

        return super.mergeFile(sourceFile, newFile, lastFile);
    }

    validate(targetDir: string, files: any[]): Promise<ValidationResult> {
        console.log('Validating Java Spring Boot project');

        return new Promise((resolve, reject) => {
            const chunks: Buffer[] = [];
            const command = 'mvn';
            console.log(`Running ${command} in target directory ${targetDir} to validate the project.`);

            const mvn = spawn('mvn', ['verify'], {
                cwd: targetDir ? targetDir : process.cwd(),
                shell: true,
            });
            mvn.stdout.on('data', (data) => {
                chunks.push(data);
            });

            mvn.stderr.on('data', (data) => {
                chunks.push(data);
            });

            mvn.on('close', (code) => {
                if (code !== 0) {
                    resolve({ valid: false, error: Buffer.concat(chunks).toString() });
                } else {
                    resolve({ valid: true, error: '' });
                }
            });
        });
    }

    language(): string {
        return LANGUAGE;
    }

      
    protected _createTemplateEngine(data: any, context: any) {
        const engine = super._createTemplateEngine(data, context);

        addTemplateHelpers(engine, this.options, data, context);

        return engine;
    }

    protected _postProcessCode(filename: string, code: string): string {
        let parser = null;
        let tabWidth = 4;

        if (filename.endsWith('.java')) {
            parser = 'java';
        }

        if (filename.endsWith('.yaml') || filename.endsWith('.yml')) {
            parser = 'yaml';
            tabWidth = 2;
        }

        if (!parser) {
            return code;
        }

        try {
            return prettier.format(code.trim(), {
                tabWidth: tabWidth,
                parser: parser,
                plugins: [require.resolve('prettier-plugin-java')],
            });
        } catch (e: any) {
            console.log('Failed to prettify source: ' + filename + '. ' + e, code);
            return code;
        }
    }
}
