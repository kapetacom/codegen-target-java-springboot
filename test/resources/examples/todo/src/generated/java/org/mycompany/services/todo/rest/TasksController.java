/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.rest;

import com.kapeta.spring.annotation.*;
import jakarta.validation.Valid;
import java.util.*;
import org.mycompany.services.todo.dto.TaskDTO;
import org.mycompany.services.todo.service.ITasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@KapetaController("tasks")
@RequestMapping("/")
public class TasksController {

    private final ITasksService service;

    public TasksController(ITasksService service) {
        this.service = service;
    }

    @Description("Add task to list")
    @RequestMapping(value = "/tasks/{listId}/new", method = RequestMethod.POST)
    public void addTask(
        @PathVariable String listId,
        @Valid @RequestBody TaskDTO task,
        @RequestHeader(
            name = "Kapeta-Overwrite",
            required = false
        ) String overwrite
    ) throws Exception {
        service.addTask(listId, task, overwrite);
    }

    @Description("Remove task from list")
    @RequestMapping(
        value = "/tasks/{listId}/{taskId}",
        method = RequestMethod.DELETE
    )
    public void removeTask(
        @PathVariable String listId,
        @PathVariable String taskId
    ) throws Exception {
        service.removeTask(listId, taskId);
    }

    @Description("Get tasks for list")
    @ResponseBody
    @RequestMapping(value = "/tasks/{listId}", method = RequestMethod.GET)
    public Page<TaskDTO> getTasks(
        @PathVariable String listId,
        Pageable pageable,
        @RequestParam(required = false) String filter
    ) throws Exception {
        return service.getTasks(listId, pageable, filter);
    }

    @Description("Update task")
    @ResponseBody
    @RequestMapping(
        value = "/tasks/{listId}/{taskId}",
        method = RequestMethod.PUT
    )
    public TaskDTO updateTask(
        @PathVariable String listId,
        @PathVariable String taskId,
        @Valid @RequestBody TaskDTO task
    ) throws Exception {
        return service.updateTask(listId, taskId, task);
    }

    @Description("Find tasks")
    @ResponseBody
    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public List<TaskDTO> search(
        @RequestParam String title,
        @RequestParam(name = "desc", required = false) String description
    ) throws Exception {
        return service.search(title, description);
    }
}
