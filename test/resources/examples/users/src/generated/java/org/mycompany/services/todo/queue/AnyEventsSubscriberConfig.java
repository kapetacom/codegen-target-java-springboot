/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.queue;

import com.kapeta.spring.rabbitmq.KapetaMessageListenerContainer;
import com.kapeta.spring.rabbitmq.RabbitConnectionManager;
import com.kapeta.spring.rabbitmq.RabbitMQConsumer;
import org.mycompany.services.todo.dto.Object;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnyEventsSubscriberConfig {

    public static class Consumer extends RabbitMQConsumer<Object> {

        public Consumer(RabbitConnectionManager rabbitConnectionManager) {
            super(rabbitConnectionManager, "anyEvents", Object.class);
        }
    }

    public static class Container
        extends KapetaMessageListenerContainer<Object> {

        public Container(Consumer consumer, IAnyEventsSubscriber listener) {
            super(consumer, listener);
        }
    }

    @Bean
    public static Consumer anyEventsConsumer(
        RabbitConnectionManager rabbitConnectionManager
    ) {
        return new Consumer(rabbitConnectionManager);
    }

    @Bean
    public static Container anyEventsContainer(
        Consumer consumer,
        IAnyEventsSubscriber listener
    ) {
        return new Container(consumer, listener);
    }
}
