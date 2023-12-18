//#FILENAME:src/main/java/{{packagePath options.basePackage}}/repositories/{{data.metadata.name}}/{{class data.metadata.name}}Config.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{options.basePackage}}.repositories.{{data.metadata.name}};

import com.kapeta.spring.redis.AbstractRedisConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories(
        basePackages = {
                "{{string options.basePackage}}.repositories.{{string data.metadata.name}}"
        }
)
public class {{class data.metadata.name}}Config extends AbstractRedisConfig {

    public {{class data.metadata.name}}Config() {
        super("{{string data.metadata.name}}");
    }

}