//#FILENAME:src/main/java/{{packagePath options.basePackage}}/{{class data.metadata.name}}Application.java:write-always
package {{options.basePackage}};

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
{{#consumes 'kapeta/resource-type-redis'}}
@KapetaEnableRedis
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
public class {{class data.metadata.name}}Application {

    public static void main(String[] args) {
        KapetaApplication.run({{class data.metadata.name}}Application.class, args);
    }

}
