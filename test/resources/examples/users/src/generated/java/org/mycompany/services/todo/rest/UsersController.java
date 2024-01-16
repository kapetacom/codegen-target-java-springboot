/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.rest;

import com.kapeta.spring.annotation.*;
import jakarta.validation.Valid;
import java.util.*;
import org.mycompany.services.todo.dto.*;
import org.mycompany.services.todo.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;

@RestController
@KapetaController("users")
@RequestMapping("/")
public class UsersController {

    private final IUsersService service;

    public UsersController(IUsersService service) {
        this.service = service;
    }

    @Description("Create user")
    @ResponseBody
    @RequestMapping(value = "/users/{id}", method = RequestMethod.POST)
    public UserDTO createUser(
        @PathVariable String id,
        @Valid @RequestBody UserDTO user,
        @RequestHeader Map<String, String> metadata
    ) throws Exception {
        return service.createUser(id, user, metadata);
    }

    @Description("Get user by id")
    @ResponseBody
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public UserDTO getUser(@PathVariable String id) throws Exception {
        return service.getUser(id);
    }

    @Description("Delete user by id")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String id) throws Exception {
        service.deleteUser(id);
    }

    @Description("Authenticate user")
    @ResponseBody
    @RequestMapping(value = "/users/authenticate", method = RequestMethod.POST)
    public UserDTO authenticate(@Valid @RequestBody UserAuthDTO user)
        throws Exception {
        return service.authenticate(user);
    }

    @Description("Get all users")
    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<UserDTO> listUsers(
        @RequestParam(required = false) Set<String> filter
    ) throws Exception {
        return service.listUsers(filter);
    }
}
