//#FILENAME:src/generated/java/{{packagePath options.basePackage}}/gen/rest/{{class data.metadata.name type=true}}Controller.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{options.basePackage}}.gen.rest;

import {{options.basePackage}}.gen.service.I{{class data.metadata.name type=true}}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.kapeta.spring.annotation.*;
import java.util.*;
{{#anyEntities}}
import {{options.basePackage}}.dto.*;
import {{options.basePackage}}.gen.dto.*;
{{/anyEntities}}

@RestController
@KapetaController("{{namespace data.metadata.name}}")
public class {{class data.metadata.name type=true}}Controller {

    private final I{{class data.metadata.name type=true}}Service service;

    @Autowired
    public {{class data.metadata.name type=true}}Controller( I{{class data.metadata.name type=true}}Service service ) {
        this.service = service;
    }

{{#methods data.spec.methods}}
    /**
     * {{comment description}}
     */
    {{#ifValueType responseType}}@ResponseBody{{/ifValueType}}
    @RequestMapping(value = "{{string path}}", method = RequestMethod.{{constant method}})
    public {{returnType responseType}} {{method methodName}}( {{#arguments arguments}}
                {{#switch (uppercase transport)}}
                    {{#case 'PATH'}} @PathVariable{{{params}}} {{/case}}
                    {{#case 'QUERY'}} @RequestParam{{{params}}} {{/case}}
                    {{#case 'HEADER'}} @RequestHeader{{{params}}} {{/case}}
                    {{#case 'BODY'}} @RequestBody{{{params}}} {{/case}}
                {{/switch}}
                {{class this}} {{variable argumentName}}
            {{/arguments}} ) throws Exception {

        {{#ifValueType responseType}}return {{/ifValueType}}service.{{method methodName}} (
            {{#arguments arguments}}
                {{variable argumentName}}
            {{/arguments}}
        );
    }

{{/methods}}

}
