package org.mycompany.services.todo.service;

import java.util.*;
import org.mycompany.services.todo.dto.*;

public interface IUsersService {
    /**
     * Create user
     */
    UserDTO createUser(String id, UserDTO user, Map<String, String> metadata)
        throws Exception;

    /**
     * Get user by id
     */
    UserDTO getUser(String id) throws Exception;

    /**
     * Delete user by id
     */
    void deleteUser(String id) throws Exception;

    /**
     * Authenticate user
     */
    UserDTO authenticate(UserAuthDTO user) throws Exception;

    /**
     * Get all users
     */
    List<UserDTO> listUsers(Set<String> filter) throws Exception;
}
