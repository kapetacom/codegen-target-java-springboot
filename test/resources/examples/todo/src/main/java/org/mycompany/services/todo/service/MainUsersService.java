package org.mycompany.services.todo.service;

import java.util.*;
import org.mycompany.services.todo.dto.UserDTO;
import org.springframework.stereotype.Service;

/**
 * Do something with users
 */
@Service
public class MainUsersService implements IMainUsersService {

    /**
     * Get user
     */
    @Override
    public UserDTO get() {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Create user
     */
    @Override
    public void add(UserDTO user) {
        throw new RuntimeException("Not implemented");
    }
}
