package org.mycompany.services.todo.pubsub;

import org.mycompany.services.todo.dto.UserAuthDTO;
import org.springframework.stereotype.Service;

@Service
public class UserAuthsSubscriber implements IUserAuthsSubscriber {

    @Override
    public void onMessage(UserAuthDTO userAuthDTO) throws Exception {
        throw new RuntimeException("Not implemented");
    }
}
