/**
 * GENERATED SOURCE - DO NOT EDIT
 */

package org.mycompany.services.todo.dto;

import jakarta.validation.constraints.NotNull;
import java.util.*;
import lombok.*;

@Data
public class UserBase {

    @NotNull
    private String id;

    private String name;

    @NotNull
    private String email;

    private Metadata metadata;

    @Data
    public static class Metadata {

        @NotNull
        private int age;

        @NotNull
        private String gender;

        @NotNull
        private String bio;
    }
}
