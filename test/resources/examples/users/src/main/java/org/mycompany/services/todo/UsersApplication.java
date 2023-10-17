package org.mycompany.services.todo;

import com.kapeta.spring.KapetaApplication;
import com.kapeta.spring.annotation.KapetaEnableEmailSender;
import com.kapeta.spring.annotation.KapetaEnablePostgres;
import com.kapeta.spring.annotation.KapetaEnableRestResource;
import com.kapeta.spring.annotation.KapetaSpringApplication;

@KapetaSpringApplication
@KapetaEnableRestResource
@KapetaEnablePostgres
@KapetaEnableEmailSender
public class UsersApplication {

    public static void main(String[] args) {
        KapetaApplication.run(UsersApplication.class, args);
    }
}
