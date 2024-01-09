//#FILENAME:src/generated/java/{{packagePath options.basePackage}}/repositories/{{packageName data.metadata.name}}/{{class data.metadata.name}}Config.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{packageName options.basePackage}}.repositories.{{packageName data.metadata.name}};

import com.kapeta.spring.redis.AbstractRedisConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories(
    basePackages = { "{{string (packageName options.basePackage)}}.repositories.{{string (packageName data.metadata.name)}}" }
)
public class {{class data.metadata.name}}Config extends AbstractRedisConfig {

    public {{class data.metadata.name}}Config() {
        super("{{string data.metadata.name}}");
    }

}