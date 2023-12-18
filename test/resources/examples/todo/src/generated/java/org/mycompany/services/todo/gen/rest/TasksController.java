/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.gen.rest;

import com.kapeta.spring.annotation.*;
import java.util.*;
import org.mycompany.services.todo.dto.*;
import org.mycompany.services.todo.gen.dto.*;
import org.mycompany.services.todo.gen.service.ITasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@KapetaController("tasks")
public class TasksController {

    private final ITasksService service;

    @Autowired
    public TasksController(ITasksService service) {
        this.service = service;
    }

    /**
     * Add task to list
     */

    @RequestMapping(value = "/tasks/{listId}/new", method = RequestMethod.POST)
    public void addTask(
        @PathVariable("listId") String listId,
        @RequestBody TaskDTO task,
        @RequestHeader("Kapeta-Overwrite") String overwrite
    ) throws Exception {
        service.addTask(listId, task, overwrite);
    }

    /**
     * Remove task from list
     */

    @RequestMapping(
        value = "/tasks/{listId}/{taskId}",
        method = RequestMethod.DELETE
    )
    public void removeTask(
        @PathVariable("listId") String listId,
        @PathVariable("taskId") String taskId
    ) throws Exception {
        service.removeTask(listId, taskId);
    }

    /**
     * Get tasks for list
     */
    @ResponseBody
    @RequestMapping(value = "/tasks/{listId}", method = RequestMethod.GET)
    public List<TaskDTO> getTasks(@PathVariable("listId") String listId)
        throws Exception {
        return service.getTasks(listId);
    }

    /**
     * Update task
     */
    @ResponseBody
    @RequestMapping(
        value = "/tasks/{listId}/{taskId}",
        method = RequestMethod.PUT
    )
    public TaskDTO updateTask(
        @PathVariable("listId") String listId,
        @PathVariable("taskId") String taskId,
        @RequestBody TaskDTO task
    ) throws Exception {
        return service.updateTask(listId, taskId, task);
    }

    /**
     * Find tasks
     */
    @ResponseBody
    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public List<TaskDTO> search(
        @RequestParam("title") String title,
        @RequestParam(name = "description", required = false) String description
    ) throws Exception {
        return service.search(title, description);
    }
}
