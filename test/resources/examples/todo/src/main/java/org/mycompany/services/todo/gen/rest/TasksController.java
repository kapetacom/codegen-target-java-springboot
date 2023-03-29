/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.gen.rest;

import java.util.*;
import org.mycompany.services.todo.dto.*;
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
    public void addTask(String listId, TaskDTO task) throws Exception {
        service.addTask(listId, task);
    }

    /**
     * Remove task from list
     */

    @RequestMapping(
        value = "/tasks/{listId}/{taskId}",
        method = RequestMethod.DELETE
    )
    public void removeTask(String listId, String taskId) throws Exception {
        service.removeTask(listId, taskId);
    }

    /**
     * Get tasks for list
     */
    @ResponseBody
    @RequestMapping(value = "/tasks/{listId}", method = RequestMethod.GET)
    public List<TaskDTO> getTasks(String listId) throws Exception {
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
    public TaskDTO updateTask(String listId, String taskId, TaskDTO task)
        throws Exception {
        return service.updateTask(listId, taskId, task);
    }
}
