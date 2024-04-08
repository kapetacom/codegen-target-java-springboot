/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.pubsub;

import com.kapeta.spring.config.providers.KapetaConfigurationProvider;
import com.kapeta.spring.pubsub.KapetaPubSubSubscriptionManager;
import org.mycompany.services.todo.dto.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubscriberConfiguration {

    @Bean
    public KapetaPubSubSubscriptionManager<
        UserAuthDTO
    > userAuthSubscriptionManager(
        KapetaConfigurationProvider kapetaConfigurationProvider,
        IUserAuthSubscriber subscriber
    ) {
        return new KapetaPubSubSubscriptionManager<>(
            kapetaConfigurationProvider,
            "pubsubsubscription",
            UserAuthDTO.class,
            subscriber::onMessage
        );
    }
}
