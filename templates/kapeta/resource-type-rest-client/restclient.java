//#FILENAME:src/generated/java/{{packagePath options.basePackage}}/clients/{{class data.metadata.name type=true}}Client.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{packageName options.basePackage}}.clients;

import com.kapeta.spring.annotation.KapetaRestClient;
import retrofit2.Call;
import retrofit2.http.*;
import java.util.*;
{{#anyEntities}}
import {{../options.basePackage}}.dto.*;
{{/anyEntities}}

@KapetaRestClient("{{string data.metadata.name}}")
public interface {{class data.metadata.name type=true}}Client {

{{#methods data.spec.methods}}

    /**
     * {{comment description}}
     */
    @{{type method}}("{{relativePath path}}")
    Call<{{returnType responseType ucfirst=true}}> {{method methodName}} ( {{#arguments arguments}}

            {{#switch (uppercase transport)}}
                {{#case 'PATH'}} @Path("{{string argumentName}}") {{/case}}
                {{#case 'QUERY'}}
                    {{#ifPrimitive this}}
                        @Query("{{string argumentName}}")
                    {{else}}
                        @QueryMap
                    {{/ifPrimitive}}
                {{/case}}
                {{#case 'HEADER'}}
                    {{#ifPrimitive this}}
                        @Header("{{string ../argument}}")
                    {{else}}
                        @HeaderMap
                    {{/ifPrimitive}}
                {{/case}}
                {{#case 'BODY'}} @Body {{/case}}
            {{/switch}}
            {{class this}} {{variable argumentName}}

        {{/arguments}} );

{{/methods}}

}
