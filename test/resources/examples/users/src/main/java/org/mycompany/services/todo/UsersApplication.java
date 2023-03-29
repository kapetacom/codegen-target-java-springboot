package org.mycompany.services.todo;

import com.kapeta.spring.KapetaApplication;

@KapetaSpringApplication
@KapetaEnableRestResource
@KapetaEnablePostgres
public class UsersApplication {

    public static void main(String[] args) {
        KapetaApplication.run(UsersApplication.class, args);
    }
}
