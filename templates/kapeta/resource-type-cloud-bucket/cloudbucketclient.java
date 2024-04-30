//#FILENAME:src/generated/java/{{packagePath options.basePackage}}/clients/{{pascalCase data.metadata.name}}Bucket.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{packageName options.basePackage}}.clients.cloudbuckets;


import io.minio.GetObjectArgs;
import io.minio.PutObjectArgs;
import io.minio.MinioClient;
import com.kapeta.spring.cloudbucket.CloudBucketClientFactory;
import org.springframework.stereotype.Component;

@Component
public class {{pascalCase data.metadata.name}}Bucket extends CloudBucketClientFactory.Client {

    public {{pascalCase data.metadata.name}}Bucket(CloudBucketClientFactory factory) throws Exception {
        super(factory, "{{string data.metadata.name}}", "{{kebab data.metadata.name}}");
    }

}