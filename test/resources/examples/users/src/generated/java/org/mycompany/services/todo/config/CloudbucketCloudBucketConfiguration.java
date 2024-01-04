package org.mycompany.services.todo.config;

import com.kapeta.spring.cloudbucket.AbstractCloudBucketConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudbucketCloudBucketConfiguration
    extends AbstractCloudBucketConfig {

    public CloudbucketCloudBucketConfiguration() {
        super("cloudbucket", "mybucket");
    }
}
