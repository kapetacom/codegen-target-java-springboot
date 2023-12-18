/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.repositories.cache;

import com.kapeta.spring.redis.AbstractRedisConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories(
    basePackages = { "org.mycompany.services.todo.repositories.cache" }
)
public class CacheConfig extends AbstractRedisConfig {

    public CacheConfig() {
        super("cache");
    }
}
