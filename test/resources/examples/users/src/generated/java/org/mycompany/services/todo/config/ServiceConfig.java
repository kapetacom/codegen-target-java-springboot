/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.config;

import com.kapeta.spring.config.InstanceValue;
import jakarta.validation.constraints.NotNull;
import java.util.*;
import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("service")
@Data
public class ServiceConfig {

    @NotNull
    private InstanceValue instance;

    @NotNull
    private String key;
}
