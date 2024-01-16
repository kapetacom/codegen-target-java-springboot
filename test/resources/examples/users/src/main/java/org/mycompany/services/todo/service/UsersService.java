package org.mycompany.services.todo.service;

import java.util.*;
import org.mycompany.services.todo.dto.*;
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
        throw new RuntimeException("Not implemented");
    }

    /**
     * Get user by id
     */
    @Override
    public UserDTO getUser(String id) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Delete user by id
     */
    @Override
    public void deleteUser(String id) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Authenticate user
     */
    @Override
    public UserDTO authenticate(UserAuthDTO user) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Get all users
     */
    @Override
    public List<UserDTO> listUsers(Set<String> filter) {
        throw new RuntimeException("Not implemented");
    }
}
