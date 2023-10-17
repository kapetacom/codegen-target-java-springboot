package org.mycompany.services.todo;

import com.kapeta.spring.KapetaApplication;
import com.kapeta.spring.annotation.KapetaEnableMongoDB;
import com.kapeta.spring.annotation.KapetaEnableRestClient;
import com.kapeta.spring.annotation.KapetaEnableRestResource;
import com.kapeta.spring.annotation.KapetaSpringApplication;

@KapetaSpringApplication
@KapetaEnableRestClient
@KapetaEnableRestResource
@KapetaEnableMongoDB
public class TodoApplication {

    public static void main(String[] args) {
        KapetaApplication.run(TodoApplication.class, args);
    }
}
