//#FILENAME:src/generated/java/{{packagePath options.basePackage}}/pubsub/PublisherConfiguration.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{packageName options.basePackage}}.pubsub;

import com.google.cloud.spring.pubsub.core.publisher.PubSubPublisherTemplate;
import com.kapeta.spring.config.providers.KapetaConfigurationProvider;
import com.kapeta.spring.pubsub.KapetaPubSubPublisherTemplate;
import {{packageName options.basePackage}}.dto.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.io.IOException;

@Configuration
public class PublisherConfiguration {

    {{#providers-of-type 'kapeta/resource-type-pubsub-publisher'}}
        @Bean("{{camelCase this.spec.payloadType.type}}PublisherTemplate")
        public KapetaPubSubPublisherTemplate<{{this.spec.payloadType.type}}DTO> {{camelCase this.spec.payloadType.type}}PublisherTemplate(PubSubPublisherTemplate publisherTemplate, KapetaConfigurationProvider kapetaConfigurationProvider) throws IOException {
            return new KapetaPubSubPublisherTemplate<>(publisherTemplate, kapetaConfigurationProvider, "{{this.metadata.name}}");
        }
    {{/providers-of-type}}
}
