import React, {ChangeEvent, Component} from "react";
import _ from 'lodash';

import {FormRow} from "@blockware/ui-web-components";
import {TargetConfig, TargetConfigProps} from "@blockware/ui-web-types";

const blockwareDefinition = require('../../blockware.yml');

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


class JavaTargetConfig extends Component<TargetConfigProps, any> {

    constructor(props:any){
        super(props);
        this.state = this.props.value ? _.cloneDeep(this.props.value) : {
            basePackage: '',
            groupId: '',
            artifactId: ''
        };
    }

    valueChanged(evt:ChangeEvent<HTMLInputElement>) {
        this.setState({[evt.target.name]: evt.target.value.trim().toLowerCase()}, () => {
            this.props.onOptionsChanged(this.state);
        });
    }

    render() {

        return (
            <>
                <FormRow label="Package name"
                         help="Must be a valid java package name."
                         validation={['required', validatePackageName]}>

                    <input type="text" name="basePackage"
                           placeholder="E.g. org.my-company"
                           value={this.state.basePackage}
                           onChange={(evt)=> this.valueChanged(evt)} />
                </FormRow>

                <FormRow label="Group ID"
                         help="A valid Maven Group ID"
                         validation={['required', validateGroupId]}>

                    <input type="text" name="groupId"
                           placeholder="E.g. org.my-company"
                           value={this.state.groupId}
                           onChange={(evt)=> this.valueChanged(evt)} />
                </FormRow>

                <FormRow label="Artifact ID"
                         help="A valid Maven Artifact ID"
                         validation={['required', validateArtifactId]}>

                    <input type="text" name="artifactId"
                           placeholder="E.g. my-block-id"
                           value={this.state.artifactId}
                           onChange={(evt)=> this.valueChanged(evt)} />

                </FormRow>
            </>
        )
    }
}

const targetConfig : TargetConfig =  {
    kind: blockwareDefinition.metadata.id,
    name: blockwareDefinition.metadata.name,
    blockKinds:[
        'blocks.blockware.com/v1/Service'
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