# Kapeta Readme
This file contains some structural information about this service.

This file will be overwritten every time you change the service definition in Kapeta.

## Structure
This service is structured as follows:
* ```src/main/java/org/mycompany/services/todo/repositories```: Contains anything related to databases
* ```src/main/java/org/mycompany/services/todo/dto```: Contains the entities used by the service.
* ```src/main/java/org/mycompany/services/todo/gen```: Contains the generated files that you shouldn't edit directly.
  * These are generated files and should not be edited directly
* ```src/main/java/org/mycompany/services/todo/gen/rest```: Contains the REST API routes.
* ```src/main/java/org/mycompany/services/todo/gen/service```: Contains the REST interfaces.
  * These are generated files and should not be edited directly
* ```src/main/java/org/mycompany/services/todo/service```: Contains the service layer logic. This is where you should add your business logic

## REST API 
To edit the REST API handlers edit the services found here:
* [src/main/java/org/mycompany/services/todo/service/UsersService.java](src/main/java/org/mycompany/services/todo/service/UsersService.java)

The REST layer itself is generated for you - so your service
will be called as specified within the REST API definition in Kapeta.

You just need to worry about the logic.

The service files will only be generated if they don't already exist - or if they have not
changed since the last time they were generated.

## Postgres: usersdb
To use the "usersdb" Postgres database - simply create Spring 
repositories in this package:
```org.mycompany.services.todo.repositories.usersdb```

### Schema changes
This service uses Flyway to manage the database schema and migrations.

To add a new migration simply create a new file in the following folder:
```src/main/resources/db/migrations/usersdb```

The file name should be in the following format:
```<prefix><version>__<description>.<type>```

For example:  
```V1_0__my_migration.sql```

See the Flyway documentation for more information:
1. Naming pattern: https://www.red-gate.com/blog/database-devops/flyway-naming-patterns-matter
2. Migrations: https://documentation.red-gate.com/fd/migrations-184127470.html

Migrations will be applied automatically when the service starts.




