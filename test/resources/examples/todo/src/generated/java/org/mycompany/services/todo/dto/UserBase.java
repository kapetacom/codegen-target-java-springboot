/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.dto;

import jakarta.validation.constraints.*;
import java.util.*;
import lombok.*;
import org.mycompany.services.todo.dto.TaskDTO;

@Data
public class UserBase {

    @NotNull
    private String id;

    @Null
    private String name;

    @NotNull
    private String email;

    @NotNull
    private List<TaskDTO> tasks;
}
