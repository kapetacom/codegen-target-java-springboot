# Kapeta Readme
This file contains some structural information about this service.

This file will be overwritten every time you change the service definition in Kapeta.

## Structure
This service is structured as follows:
* ```src/generated```: Contains generated code that shouldn't be edited directly
* ```src/main```: Contains your own and generated code that you can and should edit

In the sub folder structure you'll find the following:
* ```src/generated/java/org/mycompany/services/todo/repositories```: Contains anything related to databases
* ```src/generated/java/org/mycompany/services/todo/dto```: Contains the entities used by the service.
  * These are generated files and should not be edited directly
* ```src/generated/java/org/mycompany/services/todo/rest```: Contains the REST API routes.
* ```src/generated/java/org/mycompany/services/todo/service```: Contains the REST interfaces.
  * These are generated files and should not be edited directly
* ```src/main/java/org/mycompany/services/todo/service```: Contains the service layer logic. This is where you should add your business logic

## REST API 
To edit the REST API handlers edit the services found here:
[src/main/java/org/mycompany/services/todo/service](src/main/java/org/mycompany/services/todo/service/)

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

## RabbitMQ Subscriber
To consume messages from a RabbitMQ queue a consumer is generated for you for each resource.

Implement the subscriber interface in a component to consume from a queue

Below is an example of how to use the consumer to listen for messages on the queue:
```java
package com.example.queue;

import com.example.dto.EventDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EventsSubscriber implements IEventsSubscriber {

  @Override
  public void onMessage(Message<EventDTO> message) {
    log.warn("Received message from events using example handler: {}", message);
  }
}
```
