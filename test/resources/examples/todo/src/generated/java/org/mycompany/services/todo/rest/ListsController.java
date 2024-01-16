/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.rest;

import com.kapeta.spring.annotation.*;
import jakarta.validation.Valid;
import java.util.*;
import org.mycompany.services.todo.dto.*;
import org.mycompany.services.todo.service.IListsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;

@RestController
@KapetaController("lists")
@RequestMapping("/")
public class ListsController {

    private final IListsService service;

    public ListsController(IListsService service) {
        this.service = service;
    }

    @Description("Gets all task lists")
    @ResponseBody
    @RequestMapping(value = "/lists", method = RequestMethod.GET)
    public List<TaskListDTO> getLists() throws Exception {
        return service.getLists();
    }

    @Description("Create new list")
    @RequestMapping(value = "/lists/new", method = RequestMethod.POST)
    public void addList(@Valid @RequestBody TaskListDTO list) throws Exception {
        service.addList(list);
    }

    @Description("Updates a list")
    @RequestMapping(value = "/lists/{listId}", method = RequestMethod.PUT)
    public void updateList(
        @PathVariable String listId,
        @Valid @RequestBody TaskListDTO list
    ) throws Exception {
        service.updateList(listId, list);
    }

    @Description("Deletes a list and all tasks in it")
    @RequestMapping(value = "/lists/{listId}", method = RequestMethod.DELETE)
    public void removeList(@PathVariable String listId) throws Exception {
        service.removeList(listId);
    }
}
