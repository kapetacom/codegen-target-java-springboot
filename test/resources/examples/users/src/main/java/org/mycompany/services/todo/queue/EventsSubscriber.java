/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.queue;

import lombok.extern.slf4j.Slf4j;
import org.mycompany.services.todo.dto.User;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EventsSubscriber implements IEventsSubscriber {

    @Override
    public void onMessage(Message<User> message) {
        log.warn(
            "Received message from events using example handler: {}",
            message
        );
    }
}
