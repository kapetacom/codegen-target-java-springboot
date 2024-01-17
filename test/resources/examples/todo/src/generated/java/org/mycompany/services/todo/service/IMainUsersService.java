package org.mycompany.services.todo.service;

import java.util.*;
import org.mycompany.services.todo.dto.*;

/**
 * Do something with users
 */
public interface IMainUsersService {
    /**
     * Get user
     */
    UserDTO get() throws Exception;

    /**
     * Create user
     */
    void add(UserDTO user) throws Exception;
}
