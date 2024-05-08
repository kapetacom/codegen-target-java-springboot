//#FILENAME:src/generated/java/{{packagePath options.basePackage}}/queue/{{class data.metadata.name type=true}}SubscriberConfig.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{packageName options.basePackage}}.queue;

import com.kapeta.spring.rabbitmq.KapetaMessageListenerContainer;
import com.kapeta.spring.rabbitmq.RabbitConnectionManager;
import com.kapeta.spring.rabbitmq.RabbitMQConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import {{packageName options.basePackage}}.dto.*;

@Configuration
public class {{class data.metadata.name type=true}}SubscriberConfig {

    public static class Consumer extends RabbitMQConsumer<{{class data.spec.payloadType.type}}> {
        public Consumer(RabbitConnectionManager rabbitConnectionManager) {
            super(rabbitConnectionManager, "{{string data.metadata.name}}", {{class data.spec.payloadType.type}}.class);
        }
    }

    public static class Container extends KapetaMessageListenerContainer<{{class data.spec.payloadType.type}}> {
        public Container(Consumer consumer, I{{class data.metadata.name type=true}}Subscriber listener) {
            super(consumer, listener);
        }
    }

    @Bean
    public static Consumer {{camelCase data.metadata.name}}Consumer(RabbitConnectionManager rabbitConnectionManager) {
        return new Consumer(rabbitConnectionManager);
    }

    @Bean
    public static Container {{camelCase data.metadata.name}}Container(Consumer consumer, I{{class data.metadata.name type=true}}Subscriber listener) {
        return new Container(consumer, listener);
    }

}
