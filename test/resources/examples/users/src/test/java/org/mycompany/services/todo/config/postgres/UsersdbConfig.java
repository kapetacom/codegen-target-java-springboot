/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.config.postgres;

import com.kapeta.spring.config.providers.TestConfigProvider;
import com.kapeta.spring.config.providers.types.ResourceInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsersdbConfig {

    @Bean
    public TestConfigProvider.TestConfigurationAdjuster postgresUsersdbConfig() {
        return provider ->
            provider.withResourceInfo(
                "usersdb",
                "postgres",
                new ResourceInfo()
                    .withHost("localhost")
                    .withPort("5432")
                    .withCredential("username", "root")
                    .withCredential("password", "root")
                    .withResource("usersdb")
            );
    }
}
