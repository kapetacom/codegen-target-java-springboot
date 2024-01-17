#FILENAME:kapeta.md:write-always
# Kapeta Readme
This file contains some structural information about this service.

This file will be overwritten every time you change the service definition in Kapeta.

## Structure
This service is structured as follows:
* ```src/generated```: Contains generated code that shouldn't be edited directly
* ```src/main```: Contains your own and generated code that you can and should edit

In the sub folder structure you'll find the following:
* ```src/generated/java/{{packagePath options.basePackage}}/repositories```: Contains anything related to databases
* ```src/generated/java/{{packagePath options.basePackage}}/dto```: Contains the entities used by the service.
  * These are generated files and should not be edited directly
{{#provides 'kapeta/resource-type-rest-api'}}
* ```src/generated/java/{{packagePath options.basePackage}}/rest```: Contains the REST API routes.
* ```src/generated/java/{{packagePath options.basePackage}}/service```: Contains the REST interfaces.
  * These are generated files and should not be edited directly
{{/provides}} 
* ```src/main/java/{{packagePath options.basePackage}}/service```: Contains the service layer logic. This is where you should add your business logic

{{#provides 'kapeta/resource-type-rest-api'}}
## REST API 
To edit the REST API handlers edit the services found here:
[src/main/java/{{packagePath @root.options.basePackage}}/service](src/main/java/{{packagePath @root.options.basePackage}}/service/)

The REST layer itself is generated for you - so your service
will be called as specified within the REST API definition in Kapeta.

You just need to worry about the logic.

The service files will only be generated if they don't already exist - or if they have not
changed since the last time they were generated.

{{/provides}}
{{#consumers-of-type 'kapeta/resource-type-postgresql'}}
## Postgres: {{metadata.name}}
To use the "{{metadata.name}}" Postgres database - simply create Spring 
repositories in this package:
```{{string @root.options.basePackage}}.repositories.{{string metadata.name}}```

### Schema changes
This service uses Flyway to manage the database schema and migrations.

To add a new migration simply create a new file in the following folder:
```src/main/resources/db/migrations/{{string metadata.name}}```

The file name should be in the following format:
```<prefix><version>__<description>.<type>```

For example:  
```V1_0__my_migration.sql```

See the Flyway documentation for more information:
1. Naming pattern: https://www.red-gate.com/blog/database-devops/flyway-naming-patterns-matter
2. Migrations: https://documentation.red-gate.com/fd/migrations-184127470.html

Migrations will be applied automatically when the service starts.

{{/consumers-of-type}}

{{#consumers-of-type 'kapeta/resource-type-mongodb'}}
## MongoDB: {{metadata.name}}
To use the "{{metadata.name}}" MongoDB database - simply create Spring
repositories in this package:

```{{string @root.options.basePackage}}.repositories.{{string metadata.name}}```

These will be picked up and used by the database.

If you extend ```com.kapeta.spring.mongo.repository.BaseMongoRepository``` in your repositories
you'll get some extra functionality for free.

### Schema changes
This service uses Mongock to apply database migrations to **{{metadata.name}}**. 
You simply define changes in a class annotated with ```@ChangeLog```, 
```@ChangeUnit``` or ```@ChangeSet```.

These classes should be placed in the following package:
```{{string @root.options.basePackage}}.repositories.{{string metadata.name}}.migrations```

See Mongock documentation for more information:
[https://docs.mongock.io/v5/migration/index.html](https://docs.mongock.io/v5/migration/index.html)

When you have added migrations you simply (re)start the application to apply them. 
{{/consumers-of-type}}

{{#consumes 'kapeta/resource-type-smtp-client'}}
## Emails

A ```JavaMailSender``` bean is automatically configured in this service
which is the standard way of sending e-mails in Spring.

For details about usage see the Spring documentation for more information:
https://docs.spring.io/spring-framework/docs/current/reference/html/integration.html#mail

### Testing
When sending e-mails locally it will use gosmtpd - which doesn't actually send any e-mails. 
It has a web interface and API where you can see the e-mails that would have been sent.
Read more here:
https://gitlab.com/sorenmat/gosmtpd

{{/consumes}}

