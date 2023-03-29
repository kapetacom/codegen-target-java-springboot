package org.mycompany.services.todo;

import com.kapeta.spring.KapetaApplication;

@KapetaSpringApplication
@KapetaEnableRestClient
@KapetaEnableRestResource
@KapetaEnableMongoDB
public class TodoApplication {

    public static void main(String[] args) {
        KapetaApplication.run(TodoApplication.class, args);
    }
}
