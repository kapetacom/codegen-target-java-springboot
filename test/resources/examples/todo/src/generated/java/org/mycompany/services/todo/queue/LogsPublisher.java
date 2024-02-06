/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.queue;

import com.kapeta.spring.rabbitmq.RabbitMQProvider;
import com.kapeta.spring.rabbitmq.RabbitPublisher;
import org.mycompany.services.todo.dto.Task;
import org.springframework.stereotype.Component;

@Component
public class LogsPublisher extends RabbitPublisher<Task> {

    public LogsPublisher(RabbitMQProvider<Task> logsProvider) {
        super(
            logsProvider.getTemplate(),
            logsProvider.getTargetedExchangeNames()
        );
    }
}
