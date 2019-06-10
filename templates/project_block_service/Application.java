//#FILENAME:src/main/java/{{packagePath options.basePackage}}/{{type data.metadata.name}}Application.java
package {{options.basePackage}};

import com.blockware.spring.BlockwareApplication;
import com.blockware.spring.annotation.*;

@BlockwareApplication
{{#consumes 'rest.blockware.com/v1/Client'}}
@BlockwareEnableRestClient
{{/consumes}}
{{#provides 'rest.blockware.com/v1/Resource'}}
@BlockwareEnableRestResource
{{/provides}}
{{#consumes 'grpc.blockware.com/v1/Client'}}
@BlockwareEnableGRPCClient
{{/consumes}}
{{#provides 'grpc.blockware.com/v1/Resource'}}
@BlockwareEnableGRPCResource
{{/provides}}
{{#consumes 'nosql.blockware.com/v1/mongodb'}}
@BlockwareEnableMongoDB
{{/consumes}}
{{#consumes 'nosql.blockware.com/v1/couchdb'}}
@BlockwareEnableCouchDB
{{/consumes}}
{{#consumes 'nosql.blockware.com/v1/cassandra'}}
@BlockwareEnableCassandra
{{/consumes}}
{{#consumes 'nosql.blockware.com/v1/redis'}}
@BlockwareEnableRedis
{{/consumes}}
{{#consumes 'sqldb.blockware.com/v1/postgresql'}}
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
