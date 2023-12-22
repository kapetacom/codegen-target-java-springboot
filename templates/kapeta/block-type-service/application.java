//#FILENAME:src/generated/java/{{packagePath options.basePackage}}/{{class data.metadata.name type=true}}Application.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{options.basePackage}};

import org.springframework.context.annotation.ComponentScan;
import com.kapeta.spring.KapetaApplication;
import com.kapeta.spring.annotation.KapetaSpringApplication;
{{#provides 'kapeta/resource-type-rest-api'}}
import com.kapeta.spring.annotation.KapetaEnableRestResource;
{{/provides}}
{{#consumes 'kapeta/resource-type-rest-client'}}
import com.kapeta.spring.annotation.KapetaEnableRestClient;
{{/consumes}}
{{#consumes 'kapeta/resource-type-mongodb'}}
import com.kapeta.spring.annotation.KapetaEnableMongoDB;
{{/consumes}}
{{#consumes 'kapeta/resource-type-postgresql'}}
import com.kapeta.spring.annotation.KapetaEnablePostgres;
{{/consumes}}
{{#consumes 'kapeta/resource-type-smtp-client'}}
import com.kapeta.spring.annotation.KapetaEnableEmailSender;
{{/consumes}}

@KapetaSpringApplication
{{#consumes 'kapeta/resource-type-rest-client'}}
@KapetaEnableRestClient
{{/consumes}}
{{#provides 'kapeta/resource-type-rest-api'}}
@KapetaEnableRestResource
{{/provides}}
{{#consumes 'kapeta/resource-type-grpc-client'}}
@KapetaEnableGRPCClient
{{/consumes}}
{{#provides 'kapeta/resource-type-grpc-api'}}
@KapetaEnableGRPCResource
{{/provides}}
{{#consumes 'kapeta/resource-type-mongodb'}}
@KapetaEnableMongoDB
{{/consumes}}
{{#consumes 'kapeta/resource-type-couchdb'}}
@KapetaEnableCouchDB
{{/consumes}}
{{#consumes 'kapeta/resource-type-cassandra'}}
@KapetaEnableCassandra
{{/consumes}}
{{#consumes 'kapeta/resource-type-postgresql'}}
@KapetaEnablePostgres
{{/consumes}}
{{#consumes 'kapeta/resource-type-mysql'}}
@KapetaEnableMySQL
{{/consumes}}
{{#consumes 'kapeta/resource-type-mssql'}}
@KapetaEnableMSSQL
{{/consumes}}
{{#consumes 'kapeta/resource-type-oracle'}}
@KapetaEnableOracle
{{/consumes}}
{{#consumes 'kapeta/resource-type-smtp-client'}}
@KapetaEnableEmailSender
{{/consumes}}
@ComponentScan(basePackages = {
    "{{options.basePackage}}",
    "com.kapeta.spring.rest"
})

public class {{class data.metadata.name type=true}}Application {

    public static void main(String[] args) {
        KapetaApplication.run({{class data.metadata.name type=true}}Application.class, args);
    }

}
