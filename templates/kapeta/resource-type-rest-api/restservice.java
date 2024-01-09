//#FILENAME:src/generated/java/{{packagePath options.basePackage}}/service/I{{class data.metadata.name type=true}}Service.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{packageName options.basePackage}}.service;

import java.util.*;
{{#anyEntities}}
import {{../options.basePackage}}.dto.*;
{{/anyEntities}}

public interface I{{class data.metadata.name type=true}}Service {

{{#methods data.spec.methods}}

    /**
     * {{comment description}}
     */
    {{returnType responseType}} {{method methodName}}( {{#arguments arguments}}
                {{class this}} {{variable argumentName}}
            {{/arguments}} ) throws Exception;

{{/methods}}

}
