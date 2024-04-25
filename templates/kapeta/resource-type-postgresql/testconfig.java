//#FILENAME:src/test/java/{{packagePath options.basePackage}}/config/postgres/Test{{class data.metadata.name type=true}}Config.java:create-only
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{packageName options.basePackage}}.config.postgres;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.kapeta.spring.config.providers.TestConfigProvider;
import com.kapeta.spring.config.providers.types.ResourceInfo;

@Configuration
public class Test{{class data.metadata.name type=true}}Config  {

    @Bean
    public TestConfigProvider.TestConfigurationAdjuster postgres{{class data.metadata.name type=true}}Config() {
        return provider -> provider
                .withResourceInfo("{{string data.metadata.name}}", "postgres", new ResourceInfo()
                        .withHost("localhost")
                        .withPort("5432")
                        .withCredential("username", "root")
                        .withCredential("password", "root")
                        .withResource("{{string data.metadata.name}}")
                );

    }

}