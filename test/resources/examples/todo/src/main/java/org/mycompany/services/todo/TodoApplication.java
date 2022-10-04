package org.mycompany.services.todo;

import com.blockware.spring.BlockwareApplication;
import com.blockware.spring.annotation.*;

@BlockwareSpringApplication
@BlockwareEnableRestClient
@BlockwareEnableRestResource
@BlockwareEnableMongoDB
public class TodoApplication {

    public static void main(String[] args) {
        BlockwareApplication.run(TodoApplication.class, args);
    }
}
