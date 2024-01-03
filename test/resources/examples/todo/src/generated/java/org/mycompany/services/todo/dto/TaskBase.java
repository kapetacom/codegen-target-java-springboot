/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.dto;

import jakarta.validation.constraints.*;
import java.util.*;
import lombok.*;

@Data
public class TaskBase {

    @NotNull
    private String id;

    @NotNull
    private String listId;

    @NotNull
    private String userId;

    @NotNull
    private String title;

    @Null
    private String description;

    @Null
    private boolean done;

    @NotNull
    private TaskType type;

    @NotNull
    private int count;

    @Null
    private Object metadata;

    @NotNull
    private Set<String> tags;
}
