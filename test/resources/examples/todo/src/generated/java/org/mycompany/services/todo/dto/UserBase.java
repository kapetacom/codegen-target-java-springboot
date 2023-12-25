/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.dto;

import java.util.*;
import lombok.*;
import org.mycompany.services.todo.dto.TaskDTO;

@Data
public class UserBase {

    private String id;
    private String name;
    private String email;
    private List<TaskDTO> tasks;
}
