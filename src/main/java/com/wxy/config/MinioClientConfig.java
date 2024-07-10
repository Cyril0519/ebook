package com.wxy.config;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class MinioClientConfig implements InitializingBean {
    @Value("${minio.endpoint}")
    private String endpoint;
    @Value("${minio.accessKey}")
    private String accessKey;
    @Value("${minio.secretKey}")
    private String secretKey;
    @Value("${minio.bucketName}")
    private String bucketName;


    public MinioClient createClient() {
        return MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
    }

    @Bean
    public MinioClient minioClient() {
        return createClient();
    }

    /**
     * 初始化minio桶
     */
    @Override
    @SneakyThrows
    public void afterPropertiesSet() {
        MinioClient minioClient = createClient();
        // 判断是否已经存在
        boolean exist = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        if (!exist) {
            // 创建桶
            log.info("创建桶:{}", bucketName);
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
    }

}
