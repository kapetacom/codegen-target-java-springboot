/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.rest;

import com.kapeta.spring.annotation.*;
import jakarta.validation.Valid;
import java.util.*;
import org.mycompany.services.todo.dto.*;
import org.mycompany.services.todo.service.IMainListsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;

/**
 * Do something with lists
 */
@RestController
@KapetaController(name = "Lists", namespace = "main")
@RequestMapping("/lists")
public class MainListsController {

    private final IMainListsService service;

    public MainListsController(IMainListsService service) {
        this.service = service;
    }

    @Description("Gets all task lists")
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<TaskListDTO> getLists() throws Exception {
        return service.getLists();
    }

    @Description("Create new list")
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public void addList(@Valid @RequestBody TaskListDTO list) throws Exception {
        service.addList(list);
    }

    @Description("Updates a list")
    @RequestMapping(value = "/{listId}", method = RequestMethod.PUT)
    public void updateList(
        @PathVariable String listId,
        @Valid @RequestBody TaskListDTO list
    ) throws Exception {
        service.updateList(listId, list);
    }

    @Description("Deletes a list and all tasks in it")
    @RequestMapping(value = "/{listId}", method = RequestMethod.DELETE)
    public void removeList(@PathVariable String listId) throws Exception {
        service.removeList(listId);
    }
}
