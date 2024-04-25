//#FILENAME:src/test/java/{{packagePath options.basePackage}}/config/mongodb/{{class data.metadata.name type=true}}Config.java:write-once
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{packageName options.basePackage}}.config.mongodb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.kapeta.spring.config.providers.TestConfigProvider;
import com.kapeta.spring.config.providers.types.ResourceInfo;

@Configuration
public class {{class data.metadata.name type=true}}Config  {

    @Bean
    public TestConfigProvider.TestConfigurationAdjuster mongo{{class data.metadata.name type=true}}Config() {
        return provider -> provider
                .withResourceInfo("{{string data.metadata.name}}", "mongodb", new ResourceInfo()
                        .withHost("localhost")
                        .withPort("27017")
                        .withCredential("username", "root")
                        .withCredential("password", "root")
                        .withResource("{{string data.metadata.name}}")
                );

    }

}