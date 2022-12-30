//#FILENAME:src/main/java/{{packagePath options.basePackage}}/{{class data.metadata.name}}Application.java:write-always
package {{options.basePackage}};

import com.blockware.spring.BlockwareApplication;
import com.blockware.spring.annotation.*;

@BlockwareSpringApplication
{{#consumes 'blockware/resource-type-rest-client'}}
@BlockwareEnableRestClient
{{/consumes}}
{{#provides 'blockware/resource-type-rest-api'}}
@BlockwareEnableRestResource
{{/provides}}
{{#consumes 'blockware/resource-type-grpc-client'}}
@BlockwareEnableGRPCClient
{{/consumes}}
{{#provides 'blockware/resource-type-grpc-api'}}
@BlockwareEnableGRPCResource
{{/provides}}
{{#consumes 'blockware/resource-type-mongodb'}}
@BlockwareEnableMongoDB
{{/consumes}}
{{#consumes 'blockware/resource-type-couchdb'}}
@BlockwareEnableCouchDB
{{/consumes}}
{{#consumes 'blockware/resource-type-cassandra'}}
@BlockwareEnableCassandra
{{/consumes}}
{{#consumes 'blockware/resource-type-redis'}}
@BlockwareEnableRedis
{{/consumes}}
{{#consumes 'blockware/resource-type-postgresql'}}
@BlockwareEnablePostgres
{{/consumes}}
{{#consumes 'blockware/resource-type-mysql'}}
@BlockwareEnableMySQL
{{/consumes}}
{{#consumes 'blockware/resource-type-mssql'}}
@BlockwareEnableMSSQL
{{/consumes}}
{{#consumes 'blockware/resource-type-oracle'}}
@BlockwareEnableOracle
{{/consumes}}
public class {{class data.metadata.name}}Application {

    public static void main(String[] args) {
        BlockwareApplication.run({{class data.metadata.name}}Application.class, args);
    }

}
