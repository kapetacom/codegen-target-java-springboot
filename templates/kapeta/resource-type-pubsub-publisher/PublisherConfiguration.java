//#FILENAME:src/generated/java/{{packagePath options.basePackage}}/pubsub/{{class data.metadata.name type=true}}PublisherConfiguration.java:write-always
{{ai-type 'event-publisher'}}
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

{{#ai-context}}
This is the configuration for the {{pascalCase data.metadata.name}} publisher.
Use the bean "{{camelCase data.metadata.name}}PublisherTemplate" of type KapetaPubSubPublisherTemplate<{{class data.spec.payloadType.type}}> to publish messages to the {{pascalCase data.metadata.name}} topic.
{{/ai-context}}
@Configuration
public class {{class data.metadata.name type=true}}PublisherConfiguration {

    @Bean("{{camelCase data.metadata.name}}PublisherTemplate")
    public KapetaPubSubPublisherTemplate<{{class data.spec.payloadType.type}}> {{camelCase data.metadata.name}}PublisherTemplate(PubSubPublisherTemplate publisherTemplate, KapetaConfigurationProvider kapetaConfigurationProvider) throws IOException {
        return new KapetaPubSubPublisherTemplate<>(publisherTemplate, kapetaConfigurationProvider, "{{data.metadata.name}}");
    }
}
