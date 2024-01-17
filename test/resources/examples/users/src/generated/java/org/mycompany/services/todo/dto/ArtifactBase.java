/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.dto;

import jakarta.validation.constraints.NotNull;
import java.util.*;
import lombok.*;

@Data
public class ArtifactBase<T> {

    @NotNull
    private String id;

    @NotNull
    private String name;

    @NotNull
    private T data;
}
