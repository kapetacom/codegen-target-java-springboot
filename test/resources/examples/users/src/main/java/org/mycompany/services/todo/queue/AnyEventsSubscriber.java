package org.mycompany.services.todo.queue;

import lombok.extern.slf4j.Slf4j;
import org.mycompany.services.todo.dto.*;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AnyEventsSubscriber implements IAnyEventsSubscriber {

    @Override
    public void onMessage(Message<Object> message) {
        log.warn(
            "Received message from anyEvents using example handler: {}",
            message
        );
    }
}
