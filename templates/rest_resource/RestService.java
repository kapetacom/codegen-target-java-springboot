//#FILENAME:src/main/java/{{packagePath options.basePackage}}/gen/service/{{type data.metadata.name}}Service.java
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{options.basePackage}}.gen.service;

import {{options.basePackage}}.gen.dto.*;
import java.util.*;

public interface {{type data.metadata.name}}Service {

{{#methods data.spec.methods}}

    /**
     * {{comment description}}
     */
    {{returnType responseType}} {{method methodName}}(
            {{#arguments arguments}}
                {{type type}} {{variable argumentName}}
            {{/arguments}}
        ) throws Exception;

{{/methods}}

}
