package org.mycompany.services.todo.service;

import java.util.*;
import org.mycompany.services.todo.dto.TaskDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITasksService {
    /**
     * Add task to list
     */
    void addTask(String listId, TaskDTO task, String overwrite)
        throws Exception;

    /**
     * Remove task from list
     */
    void removeTask(String listId, String taskId) throws Exception;

    /**
     * Get tasks for list
     */
    Page<TaskDTO> getTasks(String listId, Pageable pageable, String filter)
        throws Exception;

    /**
     * Update task
     */
    TaskDTO updateTask(String listId, String taskId, TaskDTO task)
        throws Exception;

    /**
     * Find tasks
     */
    List<TaskDTO> search(String title, String description) throws Exception;
}
