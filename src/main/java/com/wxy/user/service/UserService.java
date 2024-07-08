package com.wxy.user.service;

import com.wxy.user.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author wuxingyu
* @description 针对表【t_user(用户表)】的数据库操作Service
* @createDate 2024-07-08 21:12:21
*/
public interface UserService extends IService<User> {

    // 登录
    void login(User user);

    // 注册
    void register(User user);

    // 修改密码
    void changePassword();

    // 修改个人信息
    void changeUserInfo();

    // 查询个人信息
    void getUserInfo();
}
