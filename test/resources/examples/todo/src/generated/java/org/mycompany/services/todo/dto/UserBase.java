/**
 * GENERATED SOURCE - DO NOT EDIT
 */

package org.mycompany.services.todo.dto;

import jakarta.validation.constraints.NotNull;
import java.util.*;
import lombok.*;
import org.mycompany.services.todo.dto.IdableDTO;
import org.mycompany.services.todo.dto.TaskDTO;

@Data
public class UserBase extends IdableDTO {

    private String name;

    @NotNull
    private String email;

    @NotNull
    private List<TaskDTO> tasks;
}
