//#FILENAME:src/test/java/{{packagePath options.basePackage}}/config/jwt/Test{{class data.metadata.name type=true}}ConsumerConfig.java:create-only
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{packageName options.basePackage}}.config.jwt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.kapeta.spring.config.providers.TestConfigProvider;

@Configuration
public class Test{{class data.metadata.name type=true}}ConsumerConfig {

    @Bean
    public TestConfigProvider.TestConfigurationAdjuster jwt{{class data.metadata.name type=true}}ConsumerConfig() {
        return provider -> provider
                .withServiceAddress("{{string data.metadata.name}}","http","http://localhost:8080");

    }

}