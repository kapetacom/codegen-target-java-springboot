//#FILENAME:src/main/java/{{packagePath options.basePackage}}/gen/service/I{{type data.metadata.name}}Service.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{options.basePackage}}.gen.service;

import {{options.basePackage}}.dto.*;
import java.util.*;

public interface I{{type data.metadata.name}}Service {

{{#methods data.spec.methods}}

    /**
     * {{comment description}}
     */
    {{returnType responseType}} {{method methodName}}(
            {{#arguments arguments}}
                {{class type}} {{variable argumentName}}
            {{/arguments}}
        ) throws Exception;

{{/methods}}

}
