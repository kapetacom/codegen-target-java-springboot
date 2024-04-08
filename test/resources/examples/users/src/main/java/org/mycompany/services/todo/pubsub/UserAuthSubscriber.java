package org.mycompany.services.todo.pubsub;

import org.mycompany.services.todo.dto.UserAuthDTO;
import org.springframework.stereotype.Service;

@Service
public class UserAuthSubscriber implements IUserAuthSubscriber {

    @Override
    public void onMessage(UserAuthDTO userAuthDTO) throws Exception {
        throw new RuntimeException("Not implemented");
    }
}
