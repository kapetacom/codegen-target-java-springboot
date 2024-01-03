/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.service;

import java.util.*;
import org.mycompany.services.todo.dto.*;

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
    List<TaskDTO> getTasks(String listId, String filter) throws Exception;

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
