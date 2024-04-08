//#FILENAME:src/generated/java/{{packagePath options.basePackage}}/pubsub/SubscriberConfiguration.java:write-always
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
public class SubscriberConfiguration {
    {{#consumers-of-type 'kapeta/resource-type-pubsub-subscriber'}}
    @Bean
    public KapetaPubSubSubscriptionManager<{{this.spec.payloadType.type}}DTO>
        {{camelCase this.spec.payloadType.type}}SubscriptionManager(KapetaConfigurationProvider kapetaConfigurationProvider,
                                                                    I{{this.spec.payloadType.type}}Subscriber subscriber) {
        return new KapetaPubSubSubscriptionManager<>(kapetaConfigurationProvider, "{{this.metadata.name}}", {{this.spec.payloadType.type}}DTO.class, subscriber::onMessage);
    }
    {{/consumers-of-type}}
}
