/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo;

import com.kapeta.spring.KapetaApplication;
import com.kapeta.spring.annotation.KapetaEnableMongoDB;
import com.kapeta.spring.annotation.KapetaEnableRestClient;
import com.kapeta.spring.annotation.KapetaEnableRestResource;
import com.kapeta.spring.annotation.KapetaSpringApplication;
import org.springframework.context.annotation.ComponentScan;

@KapetaSpringApplication
@KapetaEnableRestClient
@KapetaEnableRestResource
@KapetaEnableMongoDB
@ComponentScan(
    basePackages = { "org.mycompany.services.todo", "com.kapeta.spring.rest" }
)
public class TodoApplication {

    public static void main(String[] args) {
        KapetaApplication.run(TodoApplication.class, args);
    }
}
