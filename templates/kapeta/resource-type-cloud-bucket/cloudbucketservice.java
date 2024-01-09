//#FILENAME:src/generated/java/{{packagePath options.basePackage}}/service/{{class data.spec.bucketname type=true}}Service.java:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package {{packageName options.basePackage}}.service;


import io.minio.GetObjectArgs;
import io.minio.PutObjectArgs;
import io.minio.MinioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class {{class data.spec.bucketname}}Service {

    private final MinioClient minioClient;

    public MinioClient get{{class data.spec.bucketname}}Client() {
        return minioClient;
    }
    
    public GetObjectArgs.Builder getBuilder() {
        return GetObjectArgs.builder().bucket("{{data.spec.bucketname}}");
    }
    
    public PutObjectArgs.Builder putBuilder() {
        return PutObjectArgs.builder().bucket("{{data.spec.bucketname}}");
    }

}