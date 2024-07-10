package com.wxy.file.service;

import io.minio.ObjectWriteResponse;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    /**
     * 上传文件
     * @param file 文件
     */
    void uploadFile(MultipartFile file);

    /**
     * 删除文件
     * @param bucketName 桶名称
     * @param objectName 文件名称
     */
    void deleteFile(String bucketName, String objectName);

}
