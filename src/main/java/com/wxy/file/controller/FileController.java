package com.wxy.file.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import com.wxy.common.pojo.Resp;
import com.wxy.file.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    // 上传文件
    @PostMapping("/upload")
    @SaCheckLogin
    public Resp upload(@RequestBody MultipartFile file) {
        fileService.uploadFile(file);
        return Resp.success();
    }


}
