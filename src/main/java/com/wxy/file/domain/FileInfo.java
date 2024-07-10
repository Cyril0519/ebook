package com.wxy.file.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;

/**
 * 
 * @TableName t_file_info
 */
@TableName(value ="t_file_info")
@Data
public class FileInfo implements Serializable {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 文件原名称
     */
    private String fileName;

    /**
     * 文件uri
     */
    private String fileUri;

    /**
     * 上传的用户id
     */
    private Long uid;


    private LocalDateTime uploadTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}