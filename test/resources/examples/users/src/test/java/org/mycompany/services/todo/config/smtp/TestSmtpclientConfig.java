/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.config.smtp;

import com.kapeta.spring.config.providers.TestConfigProvider;
import com.kapeta.spring.config.providers.types.ResourceInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestSmtpclientConfig {

    @Bean
    public TestConfigProvider.TestConfigurationAdjuster smtpSmtpclientConfig() {
        return provider ->
            provider.withResourceInfo(
                "smtpclient",
                "smtp",
                new ResourceInfo()
                    .withHost("localhost")
                    .withPort("1025")
                    .withResource("smtpclient")
            );
    }
}
