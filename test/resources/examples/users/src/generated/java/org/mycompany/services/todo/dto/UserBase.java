/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.dto;

import jakarta.validation.constraints.*;
import java.util.*;
import lombok.*;

@Data
public class UserBase {

    @NotNull
    private String id;

    @Null
    private String name;

    @NotNull
    private String email;
}
