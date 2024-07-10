package com.wxy.book.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @TableName t_book
 */
@TableName(value ="t_book")
@Data
public class Book implements Serializable {
    /**
     * 书籍id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 封面
     */
    private String cover;

    /**
     * 书籍名称
     */
    private String bookName;

    /**
     * 书籍作者id
     */
    private Long authorId;

    /**
     * 书籍作者姓名
     */
    private String authorName;

    /**
     * 售价
     */
    private BigDecimal price;

    /**
     * 内容
     */
    private String content;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}