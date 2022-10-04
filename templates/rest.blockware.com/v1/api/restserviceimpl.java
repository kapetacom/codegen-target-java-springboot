//#FILENAME:src/main/java/{{packagePath options.basePackage}}/service/{{class data.metadata.name}}Service.java:create-only
package {{options.basePackage}}.service;

import {{options.basePackage}}.gen.service.I{{class data.metadata.name}}Service;
import {{options.basePackage}}.dto.*;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class {{class data.metadata.name}}Service implements I{{class data.metadata.name}}Service {

{{#methods data.spec.methods}}

    /**
     * {{comment description}}
     */
    @Override
    public {{returnType responseType}} {{method methodName}}( {{#arguments arguments}}
                {{class type}} {{variable argumentName}}
            {{/arguments}} ) {


        //TODO: Implement me!

        {{#if responseType}}return null;{{/if}}
    }

{{/methods}}

}
