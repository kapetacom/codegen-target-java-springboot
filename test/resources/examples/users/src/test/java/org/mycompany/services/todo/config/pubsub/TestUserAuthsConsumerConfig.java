/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.config.pubsub;

import com.kapeta.schemas.entity.Connection;
import com.kapeta.schemas.entity.Endpoint;
import com.kapeta.schemas.entity.Metadata;
import com.kapeta.schemas.entity.ResourceMetadata;
import com.kapeta.spring.config.providers.TestConfigProvider;
import com.kapeta.spring.config.providers.types.BlockInstanceDetails;
import com.kapeta.spring.pubsub.types.PubSubBlockDefinition;
import com.kapeta.spring.pubsub.types.PubSubBlockSpec;
import com.kapeta.spring.pubsub.types.PubSubProviderConsumer;
import com.kapeta.spring.pubsub.types.PubSubTopicSubscriptionSpec;
import java.util.ArrayList;
import java.util.UUID;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestUserAuthsConsumerConfig {

    @Bean
    public TestConfigProvider.TestConfigurationAdjuster pubsubUserAuthsConsumerConfig() {
        var pubSubBlockId = UUID.randomUUID().toString();
        return provider ->
            provider.withConsumerInstance(
                "userAuths",
                BlockInstanceDetails
                    .fromBlock(createPubSubBlockDefinition())
                    .withInstanceId(pubSubBlockId)
                    .withConnection(
                        createConnection(
                            provider.getInstanceId(),
                            pubSubBlockId
                        )
                    )
            );
    }

    private Connection createConnection(
        String instanceId,
        String pubSubBlockId
    ) {
        var out = new Connection();
        out.setConsumer(new Endpoint());
        out.setProvider(new Endpoint());
        out.getConsumer().setBlockId(instanceId);
        out.getConsumer().setResourceName("userAuths");
        out.getProvider().setBlockId(pubSubBlockId);
        out.getProvider().setResourceName("userAuths-subscription");
        return out;
    }

    private PubSubBlockDefinition createPubSubBlockDefinition() {
        var out = new PubSubBlockDefinition();
        out.setKind("kapeta/block-type-pubsub");
        out.setMetadata(new Metadata());
        out.getMetadata().setName("test/userAuths");
        out.setSpec(new PubSubBlockSpec());
        out.getSpec().setConsumers(new ArrayList<>());
        out.getSpec().setProviders(new ArrayList<>());

        var consumer = new PubSubProviderConsumer();
        consumer.setSpec(new PubSubTopicSubscriptionSpec());
        consumer.setMetadata(new ResourceMetadata());
        consumer.getMetadata().setName("userAuths-topic");
        consumer.getSpec().setTopic("userAuths-topic");
        consumer.getSpec().setSubscription("userAuths-subscription");
        out.getSpec().getConsumers().add(consumer);

        var provider = new PubSubProviderConsumer();
        provider.setSpec(new PubSubTopicSubscriptionSpec());
        provider.setMetadata(new ResourceMetadata());
        provider.getMetadata().setName("userAuths-subscription");
        provider.getSpec().setTopic("userAuths-topic");
        provider.getSpec().setSubscription("userAuths-subscription");
        out.getSpec().getProviders().add(provider);
        return out;
    }
}
