//#FILENAME:src/generated/java/{{packagePath options.basePackage}}/EnableKapeta.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{options.basePackage}};

import java.lang.annotation.*;

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
{{#consumes 'kapeta/resource-type-auth-jwt-consumer'}}
import com.kapeta.spring.annotation.KapetaEnableSecurityConsumerConfig;
{{/consumes}}
{{#provides 'kapeta/resource-type-auth-jwt-provider'}}
import com.kapeta.spring.annotation.KapetaEnableSecurityProviderConfig;
{{/provides}}

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
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
{{#consumes 'kapeta/resource-type-auth-jwt-consumer'}}
@KapetaEnableSecurityConsumerConfig
{{/consumes}}
{{#provides 'kapeta/resource-type-auth-jwt-provider'}}
@KapetaEnableSecurityProviderConfig
{{/provides}}
public @interface EnableKapeta {
}
