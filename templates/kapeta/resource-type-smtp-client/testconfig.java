//#FILENAME:src/test/java/{{packagePath options.basePackage}}/config/smtp/Test{{class data.metadata.name type=true}}Config.java:create-only
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{packageName options.basePackage}}.config.smtp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.kapeta.spring.config.providers.TestConfigProvider;
import com.kapeta.spring.config.providers.types.ResourceInfo;

@Configuration
public class Test{{class data.metadata.name type=true}}Config {

    @Bean
    public TestConfigProvider.TestConfigurationAdjuster smtp{{class data.metadata.name type=true}}Config() {
        return provider -> provider
                .withResourceInfo("{{string data.metadata.name}}", "smtp", new ResourceInfo()
                        .withHost("localhost")
                        .withPort("1025")
                        .withResource("{{string data.metadata.name}}")
                );

    }

}