//#FILENAME:src/main/java/{{packagePath options.basePackage}}/repositories/{{data.metadata.name}}/{{class data.metadata.name}}Config.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{options.basePackage}}.repositories.{{data.metadata.name}};

import com.kapeta.spring.redis.AbstractRedisConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class {{class data.metadata.name}}Config extends AbstractRedisConfig {

    @Bean
    public {{class data.metadata.name}}() {
        return createRedis("{{string data.metadata.name}}");
    }

}