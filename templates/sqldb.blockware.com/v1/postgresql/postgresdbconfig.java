//#FILENAME:src/main/java/{{packagePath options.basePackage}}/repositories/{{data.metadata.name}}/{{class data.metadata.name}}Config.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{options.basePackage}}.repositories.{{data.metadata.name}};

import com.blockware.spring.postgres.AbstractPostgresConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
    basePackages = {
            "{{string options.basePackage}}.repositories.{{string data.metadata.name}}"
    }
)
public class {{class data.metadata.name}}Config extends AbstractPostgresConfig {

    public {{class data.metadata.name}}Config() {
        super("{{string data.metadata.name}}");
    }

}