/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.repositories.usersdb;

import com.kapeta.spring.postgres.AbstractPostgresConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
    basePackages = { "org.mycompany.services.todo.repositories.usersdb" }
)
public class UsersdbConfig extends AbstractPostgresConfig {

    public UsersdbConfig() {
        super("usersdb");
    }
}
