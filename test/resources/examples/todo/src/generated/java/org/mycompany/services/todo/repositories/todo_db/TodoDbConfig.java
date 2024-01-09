/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.repositories.todo_db;

import com.kapeta.spring.mongo.AbstractMongoDBConfig;
import com.kapeta.spring.mongo.repository.BaseMongoRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(
    repositoryBaseClass = BaseMongoRepositoryImpl.class,
    basePackages = { "org.mycompany.services.todo.repositories.todo_db" }
)
public class TodoDbConfig extends AbstractMongoDBConfig {

    public TodoDbConfig() {
        super("todo-db");
    }
}
