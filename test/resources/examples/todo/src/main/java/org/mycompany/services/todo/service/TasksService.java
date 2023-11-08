package org.mycompany.services.todo.service;

import java.util.*;
import org.mycompany.services.todo.dto.*;
import org.mycompany.services.todo.gen.service.ITasksService;
import org.springframework.stereotype.Service;

@Service
public class TasksService implements ITasksService {

    /**
     * Add task to list
     */
    @Override
    public void addTask(String listId, TaskDTO task, String overwrite) {
        //TODO: Implement me!

    }

    /**
     * Remove task from list
     */
    @Override
    public void removeTask(String listId, String taskId) {
        //TODO: Implement me!

    }

    /**
     * Get tasks for list
     */
    @Override
    public List<TaskDTO> getTasks(String listId) {
        //TODO: Implement me!

        throw new RuntimeException("Not implemented");
    }

    /**
     * Update task
     */
    @Override
    public TaskDTO updateTask(String listId, String taskId, TaskDTO task) {
        //TODO: Implement me!

        throw new RuntimeException("Not implemented");
    }
}
