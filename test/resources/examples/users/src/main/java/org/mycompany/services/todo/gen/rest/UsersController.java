/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.gen.rest;

import java.util.*;
import org.mycompany.services.todo.dto.*;
import org.mycompany.services.todo.gen.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@KapetaController("users")
public class UsersController {

    private final IUsersService service;

    @Autowired
    public UsersController(IUsersService service) {
        this.service = service;
    }

    /**
     * Create user
     */
    @ResponseBody
    @RequestMapping(value = "/users/{id}", method = RequestMethod.POST)
    public UserDTO createUser(
        @PathVariable("id") String id,
        @RequestBody UserDTO user
    ) throws Exception {
        return service.createUser(id, user);
    }

    /**
     * Get user by id
     */
    @ResponseBody
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public UserDTO getUser(@PathVariable("id") String id) throws Exception {
        return service.getUser(id);
    }

    /**
     * Delete user by id
     */

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") String id) throws Exception {
        service.deleteUser(id);
    }

    /**
     * Authenticate user
     */
    @ResponseBody
    @RequestMapping(value = "/users/authenticate", method = RequestMethod.POST)
    public UserDTO authenticate(UserAuthDTO user) throws Exception {
        return service.authenticate(user);
    }

    /**
     * Get all users
     */
    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<UserDTO> listUsers() throws Exception {
        return service.listUsers();
    }
}
