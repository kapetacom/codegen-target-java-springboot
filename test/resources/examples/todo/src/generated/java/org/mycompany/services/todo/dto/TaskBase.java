/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.dto;

import jakarta.validation.constraints.NotNull;
import java.util.*;
import lombok.*;
import org.mycompany.services.todo.dto.IdableDTO;
import org.mycompany.services.todo.dto.TaskType;

@Data
public class TaskBase extends IdableDTO {

    @NotNull
    private String listId;

    @NotNull
    private String userId;

    @NotNull
    private String title;

    private String description;

    private boolean done;

    @NotNull
    private TaskType type;

    @NotNull
    private int count;

    private Object metadata;

    @NotNull
    private Set<String> tags;
}
