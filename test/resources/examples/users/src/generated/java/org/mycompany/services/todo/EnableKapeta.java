/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo;

import com.kapeta.spring.annotation.KapetaEnableEmailSender;
import com.kapeta.spring.annotation.KapetaEnablePostgres;
import com.kapeta.spring.annotation.KapetaEnableRestResource;
import com.kapeta.spring.annotation.KapetaSpringApplication;
import java.lang.annotation.*;
import java.lang.annotation.*;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@KapetaSpringApplication
@KapetaEnableRestResource
@KapetaEnablePostgres
@KapetaEnableEmailSender
@KapetaEnableSecurityProviderConfig
public @interface EnableKapeta {
}
