/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.config;

import jakarta.validation.constraints.NotNull;
import java.util.*;
import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("email")
@Data
public class EmailConfig {

    /**
     * Sender for e-mails. Note that you should be allowed to send e-mails from this domain and user
     */
    @NotNull
    private String from;
}
