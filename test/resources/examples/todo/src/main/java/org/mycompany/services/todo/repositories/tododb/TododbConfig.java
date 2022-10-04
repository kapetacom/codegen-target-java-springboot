/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.repositories.tododb;

import com.blockware.spring.mongo.AbstractMongoDBConfig;
import com.blockware.spring.mongo.repository.BaseMongoRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(
    repositoryBaseClass = BaseMongoRepositoryImpl.class,
    basePackages = { "org.mycompany.services.todo.repositories.tododb" }
)
public class TododbConfig extends AbstractMongoDBConfig {

    public TododbConfig() {
        super("tododb");
    }
}
