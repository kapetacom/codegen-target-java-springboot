//#FILENAME:src/main/java/{{packagePath options.basePackage}}/gen/clients/{{class data.metadata.name}}Client.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{options.basePackage}}.gen.clients;

import com.kapeta.spring.annotation.KapetaRestClient;
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

            {{#switch (uppercase transport)}}
                {{#case 'PATH'}} @Path("{{string argumentName}}") {{/case}}
                {{#case 'QUERY'}} @Query("{{string argumentName}}"){{/case}}
                {{#case 'HEADER'}} @Header("{{string headerName}}"){{/case}}
                {{#case 'BODY'}} @Body {{/case}}
            {{/switch}}
            {{class this}} {{variable argumentName}}

        {{/arguments}} );

{{/methods}}

}