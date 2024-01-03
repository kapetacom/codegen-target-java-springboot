/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.dto;

import java.util.*;
import lombok.*;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Data
public class TaskListBase {

    @NonNull
    private String id;

    @NonNull
    private String title;

    @Nullable
    private String createdBy;

    @Nullable
    private long created;
}
