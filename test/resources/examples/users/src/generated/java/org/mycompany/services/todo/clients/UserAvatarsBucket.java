/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.clients;

import com.kapeta.spring.cloudbucket.CloudBucketClientFactory;
import org.springframework.stereotype.Component;

@Component
public class UserAvatarsBucket extends CloudBucketClientFactory.Client {

    public UserAvatarsBucket(CloudBucketClientFactory factory)
        throws Exception {
        super(factory, "userAvatars", "user-avatars");
    }
}
