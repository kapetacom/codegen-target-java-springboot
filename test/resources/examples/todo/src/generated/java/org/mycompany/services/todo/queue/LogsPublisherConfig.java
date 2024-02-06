/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.queue;

import com.kapeta.spring.rabbitmq.RabbitConnectionManager;
import com.kapeta.spring.rabbitmq.RabbitMQProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogsPublisherConfig {

    @Bean
    public static RabbitMQProvider logsProvider(
        RabbitConnectionManager rabbitConnectionManager
    ) {
        return new RabbitMQProvider(rabbitConnectionManager, "logs");
    }
}
