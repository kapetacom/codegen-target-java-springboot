//#FILENAME:src/main/java/{{packagePath options.basePackage}}/gen/clients/{{class data.metadata.name}}Client.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{options.basePackage}}.gen.clients;

import retrofit2.Call;
import retrofit2.http.*;
import {{options.basePackage}}.dto.*;

@KapetaRestClient("{{string data.metadata.name}}")
public interface {{class data.metadata.name}}Client {

{{#methods data.spec.methods}}

    /**
     * {{comment description}}
     */
    @{{type method}}("{{relativePath path}}")
    Call<{{returnType responseType ucfirst=true}}> {{method methodName}} ( {{#arguments arguments}}

            {{#switch transport}}
                {{#case 'path'}} @Path("{{string argumentName}}") {{/case}}
                {{#case 'query'}} @Query("{{string argumentName}}"){{/case}}
                {{#case 'header'}} @Header("{{string headerName}}"){{/case}}
                {{#case 'body'}} @Body {{/case}}
            {{/switch}}
            {{class this}} {{variable argumentName}}

        {{/arguments}} );

{{/methods}}

}
