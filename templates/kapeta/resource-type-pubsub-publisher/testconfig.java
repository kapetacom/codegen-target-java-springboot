//#FILENAME:src/test/java/{{packagePath options.basePackage}}/config/pubsub/Test{{class data.metadata.name type=true}}ProviderConfig.java:create-only
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{packageName options.basePackage}}.config.pubsub;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

@Configuration
public class Test{{class data.metadata.name type=true}}ProviderConfig  {

    @Bean
    public TestConfigProvider.TestConfigurationAdjuster pubsub{{class data.metadata.name type=true}}ProviderConfig() {
        return provider -> provider
                .withProviderInstances("{{string data.metadata.name}}", Arrays.asList(
                        BlockInstanceDetails.fromBlock(createPubSubBlockDefinition())
                                .withInstanceId(UUID.randomUUID().toString())
                                .withConnection(new Connection())
                ));

    }

    private PubSubBlockDefinition createPubSubBlockDefinition() {
        var out = new PubSubBlockDefinition();
        out.setKind("kapeta/block-type-pubsub");
        out.setMetadata(new Metadata());
        out.getMetadata().setName("test/{{string data.metadata.name}}");
        out.setSpec(new PubSubBlockSpec());
        out.getSpec().setConsumers(new ArrayList<>());
        out.getSpec().setProviders(new ArrayList<>());

        var consumer = new PubSubProviderConsumer();
        consumer.setSpec(new PubSubTopicSubscriptionSpec());
        consumer.setMetadata(new ResourceMetadata());
        consumer.getMetadata().setName("{{string data.metadata.name}}");
        consumer.getSpec().setTopic("{{string data.metadata.name}}-topic");
        out.getSpec().getConsumers().add(consumer);

        var provider = new PubSubProviderConsumer();
        provider.setSpec(new PubSubTopicSubscriptionSpec());
        provider.setMetadata(new ResourceMetadata());
        provider.getMetadata().setName("{{string data.metadata.name}}");
        provider.getSpec().setTopic("{{string data.metadata.name}}-topic");
        provider.getSpec().setSubscription("{{string data.metadata.name}}-subscription");
        out.getSpec().getProviders().add(provider);
        return out;
    }

}