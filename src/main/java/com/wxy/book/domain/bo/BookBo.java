package com.wxy.book.domain.bo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wxy.common.group.Delete;
import com.wxy.common.group.Insert;
import com.wxy.common.group.Update;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

import java.math.BigDecimal;

public class BookBo {
    /**
     * 书籍id
     */
    @Null(groups = {Insert.class})
    @NotNull(message = "书籍id不能为空", groups = {Update.class, Delete.class})
    private Long id;

    /**
     * 封面 （没有时默认采用书籍名称）
     */
    private String cover;

    /**
     * 书籍名称
     */
    @NotBlank(message = "书籍名称不能为空", groups = {Insert.class})
    private String bookName;

    /**
     * 书籍作者id
     */
    private Long authorId;

    /**
     * 书籍作者姓名
     */
    @NotBlank(message = "作者姓名不能为空", groups = {Insert.class})
    private String authorName;

    /**
     * 售价 为空时默认0
     */
    private BigDecimal price;

    /**
     * 内容
     */
    @NotBlank(message = "内容不能为空", groups = {Insert.class})
    private String content;
}
