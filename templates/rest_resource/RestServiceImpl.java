//#FILENAME:src/main/java/{{packagePath options.basePackage}}/service/{{type data.metadata.name}}Service.java:create-only
package {{options.basePackage}}.service;

import {{options.basePackage}}.gen.service.I{{type data.metadata.name}}Service;
import {{options.basePackage}}.dto.*;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class {{type data.metadata.name}}Service implements I{{type data.metadata.name}}Service {

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
