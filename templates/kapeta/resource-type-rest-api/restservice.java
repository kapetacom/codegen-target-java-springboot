//#FILENAME:src/main/java/{{packagePath options.basePackage}}/gen/service/I{{class data.metadata.name}}Service.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{options.basePackage}}.gen.service;

import java.util.*;
{{#anyEntities}}
import {{options.basePackage}}.dto.*;
{{/anyEntities}}

public interface I{{class data.metadata.name}}Service {

{{#methods data.spec.methods}}

    /**
     * {{comment description}}
     */
    {{returnType responseType}} {{method methodName}}( {{#arguments arguments}}
                {{class this}} {{variable argumentName}}
            {{/arguments}} ) throws Exception;

{{/methods}}

}
