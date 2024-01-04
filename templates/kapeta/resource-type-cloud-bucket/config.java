//#FILENAME:src/generated/java/{{packagePath options.basePackage}}/config/{{class data.metadata.name}}CloudBucketConfiguration.java:create-only
package {{options.basePackage}}.config;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.kapeta.spring.config.providers.KapetaConfigurationProvider;
import java.util.Optional;

@Configuration
public class {{class data.metadata.name}}CloudBucketConfiguration {
    private static final String RESOURCE_TYPE = "kapeta/resource-type-cloud-bucket";
    private static final String PORT_TYPE = "web";

    public static final String BUCKET_NAME = "{{string data.spec.bucketname}}";

    private final KapetaConfigurationProvider configurationProvider;

    @Value("${minio.url}")
    private String minioUrl;

    @Value("${minio.username:minioadmin}")
    private String defaultUsername;

    @Value("${minio.password:minioadmin}")
    private String defaultPassword;

    public {{class data.metadata.name}}CloudBucketConfiguration(KapetaConfigurationProvider configurationProvider) {
        this.configurationProvider = configurationProvider;
    }

    @Bean
    public MinioClient minioClient() throws Exception {
        final KapetaConfigurationProvider.ResourceInfo info = configurationProvider.getResourceInfo(RESOURCE_TYPE, PORT_TYPE, "{{string data.metadata.name}}");
        
        String minioUsername = Optional.ofNullable(info.getCredentials().get("username")).orElse(defaultUsername);
        String minioPassword = Optional.ofNullable(info.getCredentials().get("password")).orElse(defaultPassword);
        
        minioUrl = String.format("http://%s:%s", info.getHost(), info.getPort());

        MinioClient client = MinioClient.builder()
                .endpoint(minioUrl)
                .credentials(minioUsername, minioPassword)
                .build();
        if (!client.bucketExists(BucketExistsArgs.builder().bucket(BUCKET_NAME).build())) {
            client.makeBucket(
                    MakeBucketArgs
                            .builder()
                            .bucket(BUCKET_NAME)
                            .build()
            );
        }
        return client;
    }
}