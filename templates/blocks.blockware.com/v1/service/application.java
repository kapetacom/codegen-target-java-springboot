//#FILENAME:src/main/java/{{packagePath options.basePackage}}/{{type data.metadata.name}}Application.java:write-always
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
{{#consumes 'grpc.blockware.com/v1/Client'}}
@BlockwareEnableGRPCClient
{{/consumes}}
{{#provides 'grpc.blockware.com/v1/API'}}
@BlockwareEnableGRPCResource
{{/provides}}
{{#consumes 'blockware/resource-type-mongodb'}}
@BlockwareEnableMongoDB
{{/consumes}}
{{#consumes 'nosqldb.blockware.com/v1/couchdb'}}
@BlockwareEnableCouchDB
{{/consumes}}
{{#consumes 'nosqldb.blockware.com/v1/cassandra'}}
@BlockwareEnableCassandra
{{/consumes}}
{{#consumes 'nosqldb.blockware.com/v1/redis'}}
@BlockwareEnableRedis
{{/consumes}}
{{#consumes 'blockware/resource-type-postgresql'}}
@BlockwareEnablePostgres
{{/consumes}}
{{#consumes 'sqldb.blockware.com/v1/mysql'}}
@BlockwareEnableMySQL
{{/consumes}}
{{#consumes 'sqldb.blockware.com/v1/mssql'}}
@BlockwareEnableMSSQL
{{/consumes}}
{{#consumes 'sqldb.blockware.com/v1/oracle'}}
@BlockwareEnableOracle
{{/consumes}}
public class {{type data.metadata.name}}Application {

    public static void main(String[] args) {
        BlockwareApplication.run({{type data.metadata.name}}Application.class, args);
    }

}
