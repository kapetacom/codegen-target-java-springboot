package org.mycompany.services.todo.service;

import java.util.*;
import org.mycompany.services.todo.dto.*;
import org.springframework.stereotype.Service;

@Service
public class ListsService implements IListsService {

    /**
     * Gets all task lists
     */
    @Override
    public List<TaskListDTO> getLists() {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Create new list
     */
    @Override
    public void addList(TaskListDTO list) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Updates a list
     */
    @Override
    public void updateList(String listId, TaskListDTO list) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Deletes a list and all tasks in it
     */
    @Override
    public void removeList(String listId) {
        throw new RuntimeException("Not implemented");
    }
}
