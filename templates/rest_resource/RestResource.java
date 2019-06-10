//#FILENAME:src/main/java/{{packagePath options.basePackage}}/gen/rest/{{type data.metadata.name}}Controller.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{options.basePackage}}.gen.rest;

import {{options.basePackage}}.gen.service.I{{type data.metadata.name}}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.blockware.spring.annotation.*;
import {{options.basePackage}}.dto.*;

import java.util.*;

@RestController
@BlockwareController("{{namespace data.metadata.name}}")
public class {{type data.metadata.name}}Controller {

    private final I{{type data.metadata.name}}Service service;

    @Autowired
    public {{type data.metadata.name}}Controller( I{{type data.metadata.name}}Service service ) {
        this.service = service;
    }

{{#methods data.spec.methods}}

    /**
     * {{comment description}}
     */
    {{#if responseType}}@ResponseBody{{/if}}
    @RequestMapping(value = "{{string path}}", method = RequestMethod.{{constant method}})
    public {{returnType responseType}} {{method methodName}} ( {{#arguments arguments}}
                {{#switch transport}}
                    {{#case 'path'}} @PathVariable("{{string argumentName}}") {{/case}}
                    {{#case 'query'}} @RequestParam("{{string argumentName}}") {{/case}}
                    {{#case 'header'}} @RequestHeader("{{string headerName}}") {{/case}}
                    {{#case 'body'}} @RequestBody {{/case}}
                {{/switch}}
                {{class type}} {{variable argumentName}}
            {{/arguments}} ) throws Exception {

        {{#if responseType}}return {{/if}}service.{{method methodName}} (
            {{#arguments arguments}}
                {{variable argumentName}}
            {{/arguments}}
        );
    }

{{/methods}}

}
