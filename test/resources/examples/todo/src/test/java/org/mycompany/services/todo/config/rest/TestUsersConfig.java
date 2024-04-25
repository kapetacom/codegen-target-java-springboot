/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.config.rest;

import com.kapeta.spring.config.providers.TestConfigProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestUsersConfig {

    @Bean
    public TestConfigProvider.TestConfigurationAdjuster restUsersConfig() {
        return provider ->
            provider.withServiceAddress(
                "users",
                "rest",
                "http://localhost:8080"
            );
    }
}
