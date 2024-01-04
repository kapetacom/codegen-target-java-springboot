//#FILENAME:src/generated/java/{{packagePath options.basePackage}}/service/{{class data.metadata.name type=true}}Service.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{options.basePackage}}.service;


import io.minio.GetObjectArgs;
import io.minio.PutObjectArgs;
import io.minio.MinioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import {{options.basePackage}}.config.{{class data.metadata.name}}CloudBucketConfiguration;


@Service
@RequiredArgsConstructor
public class {{class data.metadata.name}}Service {

    private final MinioClient minioClient;

    public MinioClient get{{class data.metadata.name}}Client() {
        return minioClient;
    }
    
    public GetObjectArgs.Builder getBuilder() {
        return GetObjectArgs.builder().bucket({{class data.metadata.name}}CloudBucketConfiguration.BUCKET_NAME);
    }
    
    public PutObjectArgs.Builder putBuilder() {
        return PutObjectArgs.builder().bucket({{class data.metadata.name}}CloudBucketConfiguration.BUCKET_NAME);
    }

}