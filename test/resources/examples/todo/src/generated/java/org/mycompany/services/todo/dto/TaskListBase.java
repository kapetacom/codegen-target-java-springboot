/**
 * GENERATED SOURCE - DO NOT EDIT
 */

package org.mycompany.services.todo.dto;

import jakarta.validation.constraints.NotNull;
import java.util.*;
import lombok.*;
import org.mycompany.services.todo.dto.IdableDTO;

@Data
public class TaskListBase extends IdableDTO {

    @NotNull
    private String title;

    private String createdBy;

    private long created;
}
