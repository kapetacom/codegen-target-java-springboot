/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo;

import com.kapeta.spring.KapetaApplication;
import com.kapeta.spring.annotation.KapetaEnableEmailSender;
import com.kapeta.spring.annotation.KapetaEnablePostgres;
import com.kapeta.spring.annotation.KapetaEnableRestResource;
import com.kapeta.spring.annotation.KapetaSpringApplication;
import org.springframework.context.annotation.ComponentScan;

@KapetaSpringApplication
@KapetaEnableRestResource
@KapetaEnablePostgres
@KapetaEnableEmailSender
@ComponentScan(
    basePackages = { "org.mycompany.services.todo", "com.kapeta.spring.rest" }
)
public class UsersApplication {

    public static void main(String[] args) {
        KapetaApplication.run(UsersApplication.class, args);
    }
}
