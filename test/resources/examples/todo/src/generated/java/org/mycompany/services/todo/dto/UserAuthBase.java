/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.dto;

import jakarta.validation.constraints.*;
import java.util.*;
import lombok.*;

@Data
public class UserAuthBase {

    @NotNull
    private String username;

    @NotNull
    private String password;
}
