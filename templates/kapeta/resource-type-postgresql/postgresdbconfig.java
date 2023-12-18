//#FILENAME:src/generated/java/{{packagePath options.basePackage}}/repositories/{{data.metadata.name}}/{{class data.metadata.name type=true}}Config.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{options.basePackage}}.repositories.{{data.metadata.name}};

import com.kapeta.spring.postgres.AbstractPostgresConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
    basePackages = {
            "{{string options.basePackage}}.repositories.{{string data.metadata.name}}"
    }
)
public class {{class data.metadata.name type=true}}Config extends AbstractPostgresConfig {

    public {{class data.metadata.name type=true}}Config() {
        super("{{string data.metadata.name}}");
    }

}