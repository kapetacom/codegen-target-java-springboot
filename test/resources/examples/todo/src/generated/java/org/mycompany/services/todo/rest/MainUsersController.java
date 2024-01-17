/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.rest;

import com.kapeta.spring.annotation.*;
import jakarta.validation.Valid;
import java.util.*;
import org.mycompany.services.todo.dto.UserDTO;
import org.mycompany.services.todo.service.IMainUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;

/**
 * Do something with users
 */
@RestController
@KapetaController(name = "Users", namespace = "main")
@RequestMapping("/user")
public class MainUsersController {

    private final IMainUsersService service;

    public MainUsersController(IMainUsersService service) {
        this.service = service;
    }

    @Description("Get user")
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public UserDTO get() throws Exception {
        return service.get();
    }

    @Description("Create user")
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public void add(@Valid @RequestBody UserDTO user) throws Exception {
        service.add(user);
    }
}
