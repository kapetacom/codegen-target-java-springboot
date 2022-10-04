package org.mycompany.services.todo;

import com.blockware.spring.BlockwareApplication;
import com.blockware.spring.annotation.*;

@BlockwareSpringApplication
@BlockwareEnableRestResource
@BlockwareEnablePostgres
public class UsersApplication {

    public static void main(String[] args) {
        BlockwareApplication.run(UsersApplication.class, args);
    }
}
