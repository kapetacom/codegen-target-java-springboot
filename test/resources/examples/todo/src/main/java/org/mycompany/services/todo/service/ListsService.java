package org.mycompany.services.todo.service;

import java.util.*;
import org.mycompany.services.todo.dto.*;
import org.mycompany.services.todo.gen.service.IListsService;
import org.springframework.stereotype.Service;

@Service
public class ListsService implements IListsService {

    /**
     * Gets all task lists
     */
    @Override
    public List<TaskListDTO> getLists() {
        //TODO: Implement me!

        return null;
    }

    /**
     * Create new list
     */
    @Override
    public void addList(TaskListDTO list) {
        //TODO: Implement me!

    }

    /**
     * Updates a list
     */
    @Override
    public void updateList(String listId, TaskListDTO list) {
        //TODO: Implement me!

    }

    /**
     * Deletes a list and all tasks in it
     */
    @Override
    public void removeList(String listId) {
        //TODO: Implement me!

    }
}
