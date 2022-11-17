import React, { Component} from "react";
import _ from 'lodash';


import {TargetConfig, TargetConfigProps} from "@blockware/ui-web-types";
import { FormInput } from "@blockware/ui-web-components";

const blockwareDefinition = require('../../blockware.yml');

interface JavaTargetConfigOptions {
    basePackage:string
    groupId:string
    artifactId:string
}

function validatePackageName(fieldName:string, value:string) {
    if (!/^[a-z][a-z0-9_-]*(\.[a-z][a-z0-9_-]*)+[0-9a-z_]$/.test(value)) {
        throw new Error('Not a valid Java package name');
    }
}

function validateArtifactId(fieldName:string, value:string) {
    if (!/^[a-z][a-z0-9_-]+$/.test(value)) {
        throw new Error('Not a valid Maven artifact ID');
    }
}

function validateGroupId(fieldName:string, value:string) {
    if (!/^[a-z][a-z0-9_-]*(\.[a-z][a-z0-9_-]*)+[0-9a-z_]$/.test(value)) {
        throw new Error('Not a valid Maven group ID');
    }
}


class JavaTargetConfig extends Component<TargetConfigProps<JavaTargetConfigOptions>, JavaTargetConfigOptions> {

    constructor(props:any){
        super(props);
        this.state = this.props.value ? _.cloneDeep(this.props.value) : {
            basePackage: '',
            groupId: '',
            artifactId: ''
        };
    }

    valueChanged(name:string, input: string) {
        // @ts-ignore
        this.setState({[name]: input.trim().toLowerCase()}, () => {
            this.props.onOptionsChanged(this.state);
        });
    }

    render() {

        return (
            <>

                <FormInput
                    name={"basePackage"}
                    value={this.state.basePackage}
                    label={"Package name"}
                    validation={['required', validatePackageName]}
                    help={"Must be a valid java package name. E.g. org.my-company"}
                    onChange={(name:string,input:string)=>this.valueChanged(name,input)}
                />

                <FormInput
                    name={"groupId"}
                    value={this.state.groupId}
                    label={"Group ID"}
                    validation={['required', validateGroupId]}
                    help={"A valid Maven Group ID. E.g. org.my-company"}
                    onChange={(name:string,input:string)=>this.valueChanged(name,input)}
                />


                <FormInput
                    name={"artifactId"}
                    value={this.state.artifactId}
                    label={"Artifact ID"}
                    validation={['required', validateArtifactId]}
                    help={"A valid Maven Artifact ID. E.g. my-block-id"}
                    onChange={(name:string,input:string)=>this.valueChanged(name,input)}
                />

            </>
        )
    }
}

const targetConfig : TargetConfig<JavaTargetConfigOptions> =  {
    kind: blockwareDefinition.metadata.name,
    name: blockwareDefinition.metadata.title,
    blockKinds:[
        'blockware/block-type-service'
    ],
    componentType: JavaTargetConfig,
    validate: (options:any) => {
        const errors:string[] = [];

        if (!options) {
            errors.push('Missing target configuration')
        } else {
            if (!options.basePackage) {
                errors.push('Missing base package');
            } else {
                try {
                    validatePackageName('basePackage', options.basePackage);
                } catch(e) {
                    errors.push('Base package is invalid');
                }
            }

            if (!options.groupId) {
                errors.push('Missing group id');
            } else {
                try {
                    validateGroupId('groupId', options.groupId);
                } catch(e) {
                    errors.push('Group id is invalid');
                }
            }

            if (!options.artifactId) {
                errors.push('Missing artifact id');
            } else {
                try {
                    validateArtifactId('artifactId', options.artifactId);
                } catch(e) {
                    errors.push('Artifact id is invalid');
                }
            }
        }

        return errors;
    }
};

export default targetConfig;