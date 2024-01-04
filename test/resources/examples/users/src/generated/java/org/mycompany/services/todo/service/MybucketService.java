/**
 * GENERATED SOURCE - DO NOT EDIT
 */
package org.mycompany.services.todo.service;

import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MybucketService {

    private final MinioClient minioClient;

    public MinioClient getMybucketClient() {
        return minioClient;
    }

    public GetObjectArgs.Builder getBuilder() {
        return GetObjectArgs.builder().bucket("mybucket");
    }

    public PutObjectArgs.Builder putBuilder() {
        return PutObjectArgs.builder().bucket("mybucket");
    }
}
