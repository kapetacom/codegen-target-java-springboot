/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo;

import com.kapeta.spring.annotation.KapetaEnableMongoDB;
import com.kapeta.spring.annotation.KapetaEnableRestClient;
import com.kapeta.spring.annotation.KapetaEnableRestResource;
import com.kapeta.spring.annotation.KapetaEnableSecurityConsumerConfig;
import com.kapeta.spring.annotation.KapetaSpringApplication;
import java.lang.annotation.*;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@KapetaSpringApplication
@KapetaEnableRestClient
@KapetaEnableRestResource
@KapetaEnableMongoDB
@KapetaEnableSecurityConsumerConfig
public @interface EnableKapeta {
}
