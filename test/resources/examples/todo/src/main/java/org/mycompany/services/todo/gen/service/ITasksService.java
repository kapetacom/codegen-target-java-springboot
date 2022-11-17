/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.gen.service;

import java.util.*;
import org.mycompany.services.todo.dto.*;

public interface ITasksService {
    /**
     * Add task to list
     */
    void addTask(String listId, TaskDTO task) throws Exception;

    /**
     * Remove task from list
     */
    void removeTask(String listId, String taskId) throws Exception;

    /**
     * Get tasks for list
     */
    List<TaskDTO> getTasks(String listId) throws Exception;

    /**
     * Update task
     */
    TaskDTO updateTask(String listId, String taskId, TaskDTO task)
        throws Exception;
}