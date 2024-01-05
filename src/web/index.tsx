/**
 * Copyright 2023 Kapeta Inc.
 * SPDX-License-Identifier: MIT
 */

import React from 'react';

import { ILanguageTargetProvider } from '@kapeta/ui-web-types';
import { FormField } from '@kapeta/ui-web-components';

// @ts-ignore
import kapetaDefinition from '../../kapeta.yml';
// @ts-ignore
import packageJson from '../../package.json';

interface JavaTargetConfigOptions {
    basePackage: string;
    groupId: string;
    artifactId: string;
}

function validatePackageName(fieldName: string, value: string) {
    if (!/^[a-z_][a-z0-9_]*(\.[a-z_][a-z0-9_]*)+$/.test(value)) {
        throw new Error('Not a valid Java package name');
    }
}

function validateArtifactId(fieldName: string, value: string) {
    if (!/^[a-z][a-z0-9_-]+$/.test(value)) {
        throw new Error('Not a valid Maven artifact ID');
    }
}

function validateGroupId(fieldName: string, value: string) {
    if (!/^[a-z_][a-z0-9_]*(\.[a-z_][a-z0-9_]*)+$/.test(value)) {
        throw new Error('Not a valid Maven group ID');
    }
}

const JavaTargetConfig = () => {
    return (
        <>
            <FormField
                name={'spec.target.options.basePackage'}
                label={'Package name'}
                validation={['required', validatePackageName]}
                help={'Must be a valid java package name. E.g. org.my_company'}
            />

            <FormField
                name={'spec.target.options.groupId'}
                label={'Group ID'}
                validation={['required', validateGroupId]}
                help={'A valid Maven Group ID. E.g. org.my_company'}
            />

            <FormField
                name={'spec.target.options.artifactId'}
                label={'Artifact ID'}
                validation={['required', validateArtifactId]}
                help={'A valid Maven Artifact ID. E.g. my-block-id'}
            />
        </>
    );
};

const targetConfig: ILanguageTargetProvider<JavaTargetConfigOptions> = {
    kind: kapetaDefinition.metadata.name,
    version: packageJson.version,
    title: kapetaDefinition.metadata.title,
    blockKinds: ['kapeta/block-type-service'],
    resourceKinds: [
        'kapeta/resource-type-mongodb',
        'kapeta/resource-type-postgresql',
        'kapeta/resource-type-redis',
        'kapeta/resource-type-rest-api',
        'kapeta/resource-type-rest-client',
        'kapeta/resource-type-smtp-client',
        'kapeta/resource-type-external-services',
        'kapeta/resource-type-auth-jwt-provider',
        'kapeta/resource-type-auth-jwt-consumer',
        'kapeta/resource-type-cloud-bucket',
    ],
    definition: kapetaDefinition,
    editorComponent: JavaTargetConfig,
    validate: (options: any) => {
        const errors: string[] = [];

        if (!options) {
            errors.push('Missing target configuration');
        } else {
            if (!options.basePackage) {
                errors.push('Missing base package');
            } else {
                try {
                    validatePackageName('basePackage', options.basePackage);
                } catch (e) {
                    errors.push('Base package is invalid');
                }
            }

            if (!options.groupId) {
                errors.push('Missing group id');
            } else {
                try {
                    validateGroupId('groupId', options.groupId);
                } catch (e) {
                    errors.push('Group id is invalid');
                }
            }

            if (!options.artifactId) {
                errors.push('Missing artifact id');
            } else {
                try {
                    validateArtifactId('artifactId', options.artifactId);
                } catch (e) {
                    errors.push('Artifact id is invalid');
                }
            }
        }

        return errors;
    },
};

export default targetConfig;
