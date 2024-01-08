/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.config;

import jakarta.validation.constraints.NotNull;
import java.util.*;
import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("email")
public class EmailConfig {

    private String from;
}
