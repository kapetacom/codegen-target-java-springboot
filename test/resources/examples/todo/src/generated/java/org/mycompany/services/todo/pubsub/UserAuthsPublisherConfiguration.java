/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.pubsub;

import com.google.cloud.spring.pubsub.core.publisher.PubSubPublisherTemplate;
import com.kapeta.spring.config.providers.KapetaConfigurationProvider;
import com.kapeta.spring.pubsub.KapetaPubSubPublisherTemplate;
import java.io.IOException;
import org.mycompany.services.todo.dto.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserAuthsPublisherConfiguration {

    @Bean("userAuthsPublisherTemplate")
    public KapetaPubSubPublisherTemplate<
        UserAuthDTO
    > userAuthsPublisherTemplate(
        PubSubPublisherTemplate publisherTemplate,
        KapetaConfigurationProvider kapetaConfigurationProvider
    ) throws IOException {
        return new KapetaPubSubPublisherTemplate<>(
            publisherTemplate,
            kapetaConfigurationProvider,
            "userAuths"
        );
    }
}
