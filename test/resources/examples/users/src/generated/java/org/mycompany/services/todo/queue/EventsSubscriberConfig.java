/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.queue;

import com.kapeta.spring.rabbitmq.KapetaMessageListenerContainer;
import com.kapeta.spring.rabbitmq.RabbitConnectionManager;
import com.kapeta.spring.rabbitmq.RabbitMQConsumer;
import org.mycompany.services.todo.dto.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventsSubscriberConfig {

    public static class Consumer extends RabbitMQConsumer<User> {

        public Consumer(RabbitConnectionManager rabbitConnectionManager) {
            super(rabbitConnectionManager, "events", User.class);
        }
    }

    public static class Container extends KapetaMessageListenerContainer<User> {

        public Container(Consumer consumer, IEventsSubscriber listener) {
            super(consumer, listener);
        }
    }

    @Bean
    public static Consumer eventsConsumer(
        RabbitConnectionManager rabbitConnectionManager
    ) {
        return new Consumer(rabbitConnectionManager);
    }

    @Bean
    public static Container eventsContainer(
        Consumer consumer,
        IEventsSubscriber listener
    ) {
        return new Container(consumer, listener);
    }
}
