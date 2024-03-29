/**
 * Copyright 2023 Kapeta Inc.
 * SPDX-License-Identifier: MIT
 */

import { Target } from '@kapeta/codegen-target';
import prettier from 'prettier';
import Path from 'path';
import type { GeneratedFile, SourceFile } from '@kapeta/codegen';
import { mergeDevcontainers } from './target/merge-devcontainers';
import { addTemplateHelpers } from './target/template-helpers';
import { mergePom } from './target/merge-pom';

export default class JavaSpringBootTarget extends Target {
    constructor(options: any) {
        super(options, Path.resolve(__dirname, '../'));
    }

    mergeFile(sourceFile: SourceFile, newFile: GeneratedFile, lastFile: GeneratedFile | null): GeneratedFile {
        if (sourceFile.filename === 'pom.xml') {
            return mergePom(sourceFile, newFile, lastFile);
        }

        if (sourceFile.filename === '.devcontainer/devcontainer.json') {
            return mergeDevcontainers(sourceFile, newFile, lastFile);
        }

        return super.mergeFile(sourceFile, newFile, lastFile);
    }

    protected _createTemplateEngine(data: any, context: any) {
        const engine = super._createTemplateEngine(data, context);

        addTemplateHelpers(engine, data, context);

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
