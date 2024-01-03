/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.dto;

import java.util.*;
import lombok.*;
import org.mycompany.services.todo.dto.TaskDTO;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Data
public class UserBase {

    @NonNull
    private String id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @NonNull
    private List<TaskDTO> tasks;
}
