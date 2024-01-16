package org.mycompany.services.todo.service;

import java.util.*;
import org.mycompany.services.todo.dto.*;
import org.mycompany.services.todo.service.IUsersService;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements IUsersService {

    /**
     * Create user
     */
    @Override
    public UserDTO createUser(
        String id,
        UserDTO user,
        Map<String, String> metadata
    ) {
        //TODO: Implement me!

        throw new RuntimeException("Not implemented");
    }

    /**
     * Get user by id
     */
    @Override
    public UserDTO getUser(String id) {
        //TODO: Implement me!

        throw new RuntimeException("Not implemented");
    }

    /**
     * Delete user by id
     */
    @Override
    public void deleteUser(String id) {
        //TODO: Implement me!

    }

    /**
     * Authenticate user
     */
    @Override
    public UserDTO authenticate(UserAuthDTO user) {
        //TODO: Implement me!

        throw new RuntimeException("Not implemented");
    }

    /**
     * Get all users
     */
    @Override
    public List<UserDTO> listUsers(Set<String> filter) {
        //TODO: Implement me!

        throw new RuntimeException("Not implemented");
    }
}
