/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.config.redis;

import com.kapeta.spring.config.providers.TestConfigProvider;
import com.kapeta.spring.config.providers.types.ResourceInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

    @Bean
    public TestConfigProvider.TestConfigurationAdjuster redisCacheConfig() {
        return provider ->
            provider.withResourceInfo(
                "cache",
                "redis",
                new ResourceInfo()
                    .withHost("localhost")
                    .withPort("6379")
                    .withCredential("username", "root")
                    .withCredential("password", "root")
                    .withResource("cache")
            );
    }
}
