package org.mycompany.services.todo.pubsub;

import org.mycompany.services.todo.dto.*;
import org.springframework.stereotype.Service;

@Service
public class AnyPubSubSubscriber implements IAnyPubSubSubscriber {

    @Override
    public void onMessage(Object event) throws Exception {
        throw new RuntimeException("Not implemented");
    }
}
