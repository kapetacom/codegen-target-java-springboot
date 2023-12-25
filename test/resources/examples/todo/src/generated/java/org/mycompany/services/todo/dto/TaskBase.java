/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.dto;

import java.util.*;
import lombok.*;

@Data
public class TaskBase {

    private String id;
    private String listId;
    private String userId;
    private String title;
    private String description;
    private boolean done;
    private TaskType type;
    private int count;
    private Object metadata;
    private Set<String> tags;
}
