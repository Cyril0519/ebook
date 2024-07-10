package com.wxy.file.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxy.file.domain.FileInfo;
import com.wxy.file.service.FileInfoService;
import com.wxy.file.mapper.FileInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author wuxingyu
* @description 针对表【t_file_info】的数据库操作Service实现
* @createDate 2024-07-10 10:16:30
*/
@Service
public class FileInfoServiceImpl extends ServiceImpl<FileInfoMapper, FileInfo>
    implements FileInfoService{

}




