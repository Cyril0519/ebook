package com.wxy.file.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.lang.UUID;
import com.wxy.file.domain.FileInfo;
import com.wxy.file.service.FileInfoService;
import com.wxy.file.service.FileService;
import io.minio.*;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service("minio")
@RequiredArgsConstructor
@Slf4j
public class MinIoService implements FileService {

    private final MinioClient minioClient;
    private final FileInfoService fileInfoService;

    @Value("${minio.bucketName}")
    private String bucketName;

    /**
     * 上传文件
     *
     * @param bucketName 桶名称
     * @param file       文件
     * @param objectName 文件名称
     */
    @SneakyThrows
    public void uploadFile(String bucketName, MultipartFile file, String objectName) {
        InputStream inputStream = file.getInputStream();
        minioClient.putObject(
                PutObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectName)
                        .stream(inputStream, inputStream.available(), -1)
                        .build()
        );
    }

    @Override
    public void uploadFile(MultipartFile file) {
        // 获取当前的年月日
        LocalDateTime now = LocalDateTime.now();
        // 按照年/月/日的格式创建文件夹名称
        String folderName = now.getYear() + "/" +
                String.format("%02d", now.getMonthValue()) + "/" +
                String.format("%02d", now.getDayOfMonth());

        // 拼接文件名称
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null) {
            throw new RuntimeException("文件名不能为空");
        }
        // 获取文件后缀名
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        // 生成唯一的文件名称
        String objectName = UUID.fastUUID() + suffix;
        // 将文件夹名称添加到objectName中
        objectName = folderName + "/" + objectName;

        uploadFile(bucketName, file, objectName);
        // 保存数据库
        FileInfo fileInfo = new FileInfo();
        fileInfo.setFileName(originalFilename);
        fileInfo.setFileUri("/" + bucketName + "/" + objectName);
        fileInfo.setUid(StpUtil.getLoginIdAsLong());
        fileInfo.setUploadTime(now);
        fileInfoService.save(fileInfo);
    }

    /**
     * 删除文件
     * @param bucketName 桶名称
     * @param objectName 文件名称
     */
    @SneakyThrows
    public void deleteFile(String bucketName, String objectName) {
        minioClient.removeObject(
                RemoveObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectName)
                        .build()
        );
    }

}
