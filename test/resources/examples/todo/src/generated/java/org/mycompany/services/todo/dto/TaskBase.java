/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.dto;

import java.util.*;
import lombok.*;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Data
public class TaskBase {

    @NonNull
    private String id;

    @NonNull
    private String listId;

    @NonNull
    private String userId;

    @NonNull
    private String title;

    @Nullable
    private String description;

    @Nullable
    private boolean done;

    @NonNull
    private TaskType type;

    @NonNull
    private int count;

    @Nullable
    private Object metadata;

    @NonNull
    private Set<String> tags;
}
