package org.mycompany.services.todo.service;

import java.util.*;
import org.mycompany.services.todo.dto.TaskDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TasksService implements ITasksService {

    /**
     * Add task to list
     */
    @Override
    public void addTask(String listId, TaskDTO task, String overwrite) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Remove task from list
     */
    @Override
    public void removeTask(String listId, String taskId) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Get tasks for list
     */
    @Override
    public Page<TaskDTO> getTasks(
        String listId,
        Pageable pageable,
        String filter
    ) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Update task
     */
    @Override
    public TaskDTO updateTask(String listId, String taskId, TaskDTO task) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Find tasks
     */
    @Override
    public List<TaskDTO> search(String title, String description) {
        throw new RuntimeException("Not implemented");
    }
}
