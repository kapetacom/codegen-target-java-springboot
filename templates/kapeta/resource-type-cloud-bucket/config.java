//#FILENAME:src/generated/java/{{packagePath options.basePackage}}/config/{{class data.metadata.name}}CloudBucketConfiguration.java:create-only
package {{packageName options.basePackage}}.config;

import org.springframework.context.annotation.Configuration;
import com.kapeta.spring.cloudbucket.AbstractCloudBucketConfig;

@Configuration
public class {{class data.metadata.name}}CloudBucketConfiguration extends AbstractCloudBucketConfig {

    public {{class data.metadata.name}}CloudBucketConfiguration() {
        super("{{string data.metadata.name}}", "{{string data.spec.bucketname}}");
    }
}