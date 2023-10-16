#FILENAME:kapeta.md:write-always
# Kapeta Readme
This file contains some structural information about this service.

This file will be overwritten every time you change the service definition in Kapeta.

## Structure
This service is structured as follows:
* ```src/main/java/{{packagePath options.basePackage}}/repositories```: Contains anything related to databases
* ```src/main/java/{{packagePath options.basePackage}}/dto```: Contains the entities used by the service.
* ```src/main/java/{{packagePath options.basePackage}}/gen```: Contains the generated files that you shouldn't edit directly.
  * These are generated files and should not be edited directly
{{#provides 'kapeta/resource-type-rest-api'}}
* ```src/main/java/{{packagePath options.basePackage}}/gen/rest```: Contains the REST API routes.
* ```src/main/java/{{packagePath options.basePackage}}/gen/service```: Contains the REST interfaces.
  * These are generated files and should not be edited directly
{{/provides}} 
* ```src/main/java/{{packagePath options.basePackage}}/service```: Contains the service layer logic. This is where you should add your business logic

{{#provides 'kapeta/resource-type-rest-api'}}
## REST API 
To edit the REST API handlers edit the services found here:
{{#providers-of-type 'kapeta/resource-type-rest-api'}}
* [src/main/java/{{packagePath ../options.basePackage}}/service/{{class metadata.name}}Service.java](src/main/java/{{packagePath ../options.basePackage}}/service/{{class metadata.name}}Service.java)
{{/providers-of-type}}

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
```{{string ../options.basePackage}}.repositories.{{string metadata.name}}```

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

```{{string ../options.basePackage}}.repositories.{{string metadata.name}}```

These will be picked up and used by the database.

If you extend ```com.kapeta.spring.mongo.repository.BaseMongoRepository``` in your repositories
you'll get some extra functionality for free.

### Schema changes
This service uses Mongock to apply database migrations to **{{metadata.name}}**. 
You simply define changes in a class annotated with ```@ChangeLog```, 
```@ChangeUnit``` or ```@ChangeSet```.

These classes should be placed in the following package:
```{{string ../options.basePackage}}.repositories.{{string metadata.name}}.migrations```

See Mongock documentation for more information:
[https://docs.mongock.io/v5/migration/index.html](https://docs.mongock.io/v5/migration/index.html)

When you have added migrations you simply (re)start the application to apply them. 
{{/consumers-of-type}}

{{#consumes 'kapeta/resource-type-smtp-client'}}
## Emails

To send simple emails - use the following code:
```tsx
import { EmailClient } from '@kapeta/sdk-smtp-client';
const emailClient = new EmailClient();
await emailClient.send({
    from: 'support@kapeta.com',
    to: 'someone@somewhere.com',
    subject: 'Hi!',
    text: 'Hello World!',
    html: '<h1>Hello World!</h1>',
});
```
E-mails are send using nodemailer. Read more here:
https://nodemailer.com/about/

To send emails rendered using React - use the following code: 
```tsx
import { EmailClient } from '@kapeta/sdk-smtp-client';
const emailClient = new EmailClient();
await emailClient.sendReact({
    from: 'support@kapeta.com',
    to: 'someone@somewhere.com',
    subject: 'Hi!',
    body: <MyEmail />,
});
```
This uses react-email - read more here: https://react.email/

### Email templates
Email templates are simply React components which are rendered using [react-email](https://react.email/).

### Testing
When sending e-mails locally it will use gosmtpd - which doesn't actually send any e-mails. 
It has a web interface and API where you can see the e-mails that would have been sent.
Read more here:
https://gitlab.com/sorenmat/gosmtpd

{{/consumes}}

