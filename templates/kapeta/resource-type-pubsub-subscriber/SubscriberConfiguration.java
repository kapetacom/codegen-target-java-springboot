//#FILENAME:src/generated/java/{{packagePath options.basePackage}}/pubsub/{{class data.metadata.name type=true}}SubscriberConfiguration.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{packageName options.basePackage}}.pubsub;

import {{packageName options.basePackage}}.dto.*;
import com.kapeta.spring.config.providers.KapetaConfigurationProvider;
import com.kapeta.spring.pubsub.KapetaPubSubSubscriptionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class {{class data.metadata.name type=true}}SubscriberConfiguration {

    @Bean
    public KapetaPubSubSubscriptionManager<{{class data.spec.payloadType.type}}>
        {{camelCase data.metadata.name}}SubscriptionManager(KapetaConfigurationProvider kapetaConfigurationProvider,
                                                                    I{{pascalCase data.metadata.name}}Subscriber subscriber) {
        return new KapetaPubSubSubscriptionManager<>(kapetaConfigurationProvider, "{{data.metadata.name}}", {{class data.spec.payloadType.type}}.class, subscriber::onMessage);
    }
}
