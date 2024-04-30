/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.clients;

import com.kapeta.spring.cloudbucket.CloudBucketClientFactory;
import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.springframework.stereotype.Component;

@Component
public class UserAvatarsBucket extends CloudBucketClientFactory.Client {

    public UserAvatarsBucket(CloudBucketClientFactory factory)
        throws Exception {
        super(factory, "userAvatars", "user-avatars");
    }
}
