/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.dto;

import jakarta.validation.constraints.*;
import java.util.*;
import lombok.*;

@Data
public class TaskListBase {

    @NotNull
    private String id;

    @NotNull
    private String title;

    @Null
    private String createdBy;

    @Null
    private long created;
}
