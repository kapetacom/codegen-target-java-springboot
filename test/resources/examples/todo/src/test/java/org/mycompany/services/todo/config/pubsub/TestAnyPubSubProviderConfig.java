/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.config.pubsub;

import com.kapeta.schemas.entity.Connection;
import com.kapeta.schemas.entity.Metadata;
import com.kapeta.schemas.entity.ResourceMetadata;
import com.kapeta.spring.config.providers.TestConfigProvider;
import com.kapeta.spring.config.providers.types.BlockInstanceDetails;
import com.kapeta.spring.pubsub.types.PubSubBlockDefinition;
import com.kapeta.spring.pubsub.types.PubSubBlockSpec;
import com.kapeta.spring.pubsub.types.PubSubProviderConsumer;
import com.kapeta.spring.pubsub.types.PubSubTopicSubscriptionSpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestAnyPubSubProviderConfig {

    @Bean
    public TestConfigProvider.TestConfigurationAdjuster pubsubAnyPubSubProviderConfig() {
        return provider ->
            provider.withProviderInstances(
                "anyPubSub",
                Arrays.asList(
                    BlockInstanceDetails
                        .fromBlock(createPubSubBlockDefinition())
                        .withInstanceId(UUID.randomUUID().toString())
                        .withConnection(new Connection())
                )
            );
    }

    private PubSubBlockDefinition createPubSubBlockDefinition() {
        var out = new PubSubBlockDefinition();
        out.setKind("kapeta/block-type-pubsub");
        out.setMetadata(new Metadata());
        out.getMetadata().setName("test/anyPubSub");
        out.setSpec(new PubSubBlockSpec());
        out.getSpec().setConsumers(new ArrayList<>());
        out.getSpec().setProviders(new ArrayList<>());

        var consumer = new PubSubProviderConsumer();
        consumer.setSpec(new PubSubTopicSubscriptionSpec());
        consumer.setMetadata(new ResourceMetadata());
        consumer.getMetadata().setName("anyPubSub");
        consumer.getSpec().setTopic("anyPubSub-topic");
        out.getSpec().getConsumers().add(consumer);

        var provider = new PubSubProviderConsumer();
        provider.setSpec(new PubSubTopicSubscriptionSpec());
        provider.setMetadata(new ResourceMetadata());
        provider.getMetadata().setName("anyPubSub");
        provider.getSpec().setTopic("anyPubSub-topic");
        provider.getSpec().setSubscription("anyPubSub-subscription");
        out.getSpec().getProviders().add(provider);
        return out;
    }
}
