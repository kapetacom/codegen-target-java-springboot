
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


## MongoDB: todo-db
To use the "todo-db" MongoDB database - simply create Spring
repositories in this package:

```org.mycompany.services.todo.repositories.todo-db```

These will be picked up and used by the database.

If you extend ```com.kapeta.spring.mongo.repository.BaseMongoRepository``` in your repositories
you'll get some extra functionality for free.

### Schema changes
This service uses Mongock to apply database migrations to **todo-db**. 
You simply define changes in a class annotated with ```@ChangeLog```, 
```@ChangeUnit``` or ```@ChangeSet```.

These classes should be placed in the following package:
```org.mycompany.services.todo.repositories.todo-db.migrations```

See Mongock documentation for more information:
[https://docs.mongock.io/v5/migration/index.html](https://docs.mongock.io/v5/migration/index.html)

When you have added migrations you simply (re)start the application to apply them. 

## RabbitMQ Publisher
To publish messages to the RabbitMQ queue a publisher is generated for you for each resource.

Use the publisher bean relevant for the exchange you want to publish to

Below is an example of how to use the publisher to publish a message to one or more exchanges:
```java
package com.pub.service;

import com.pub.dto.EventDTO;
import com.pub.queue.EventsPublisher;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class SomeService {

  private final EventsPublisher eventsPublisher;

  public SomeService(EventsPublisher eventsPublisher) {
    this.eventsPublisher = eventsPublisher;
  }

  public void doPublish(EventDTO event) {
    eventsPublisher.publish(event);
  }
}

```
