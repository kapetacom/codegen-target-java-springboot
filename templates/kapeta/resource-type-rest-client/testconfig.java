//#FILENAME:src/test/java/{{packagePath options.basePackage}}/config/rest/Test{{class data.metadata.name type=true}}Config.java:create-only
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{packageName options.basePackage}}.config.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.kapeta.spring.config.providers.TestConfigProvider;

@Configuration
public class Test{{class data.metadata.name type=true}}Config  {

    @Bean
    public TestConfigProvider.TestConfigurationAdjuster rest{{class data.metadata.name type=true}}Config() {
        return provider -> provider
                .withServiceAddress("{{string data.metadata.name}}","rest","http://localhost:8080");

    }

}