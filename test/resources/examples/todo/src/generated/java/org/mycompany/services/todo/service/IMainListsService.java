package org.mycompany.services.todo.service;

import java.util.*;
import org.mycompany.services.todo.dto.TaskListDTO;

/**
 * Do something with lists
 */
public interface IMainListsService {
    /**
     * Gets all task lists
     */
    List<TaskListDTO> getLists() throws Exception;

    /**
     * Create new list
     */
    void addList(TaskListDTO list) throws Exception;

    /**
     * Updates a list
     */
    void updateList(String listId, TaskListDTO list) throws Exception;

    /**
     * Deletes a list and all tasks in it
     */
    void removeList(String listId) throws Exception;
}
