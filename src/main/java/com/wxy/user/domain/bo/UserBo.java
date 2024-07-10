package com.wxy.user.domain.bo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.wxy.common.group.Insert;
import com.wxy.common.group.Query;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserBo implements Serializable {

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空", groups = {Insert.class, Query.class})
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空",groups = {Insert.class, Query.class})
    private String password;

    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱不能为空",groups = {Insert.class})
    private String email;

    /**
     * 性别
     * 男1 女0
     */
    @NotBlank(message = "性别不能为空",groups = {Insert.class})
    private String gender;

    /**
     * 头像
     */
    @NotBlank(message = "头像不能为空",groups = {Insert.class})
    private String photo;

    /**
     * 年龄
     */
    @NotNull
    private Integer age;

    /**
     * 电话
     */
    @NotBlank(message = "电话不能为空",groups = {Insert.class})
    private String phone;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
