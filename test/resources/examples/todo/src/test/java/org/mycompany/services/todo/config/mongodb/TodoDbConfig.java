/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.config.mongodb;

import com.kapeta.spring.config.providers.TestConfigProvider;
import com.kapeta.spring.config.providers.types.ResourceInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TodoDbConfig {

    @Bean
    public TestConfigProvider.TestConfigurationAdjuster mongoTodoDbConfig() {
        return provider ->
            provider.withResourceInfo(
                "todo-db",
                "mongodb",
                new ResourceInfo()
                    .withHost("localhost")
                    .withPort("27017")
                    .withCredential("username", "root")
                    .withCredential("password", "root")
                    .withResource("todo-db")
            );
    }
}
