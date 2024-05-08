/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.queue;

import com.kapeta.spring.rabbitmq.RabbitMQProvider;
import com.kapeta.spring.rabbitmq.RabbitPublisher;
import org.mycompany.services.todo.dto.*;
import org.springframework.stereotype.Component;

@Component
public class LogsPublisher extends RabbitPublisher<TaskDTO> {

    public LogsPublisher(RabbitMQProvider<TaskDTO> logsProvider) {
        super(
            logsProvider.getTemplate(),
            logsProvider.getTargetedExchangeNames()
        );
    }
}
