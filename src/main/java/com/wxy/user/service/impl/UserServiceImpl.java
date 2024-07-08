package com.wxy.user.service.impl;

import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxy.common.pojo.Resp;
import com.wxy.common.util.Encrypt;
import com.wxy.user.domain.User;
import com.wxy.user.service.UserService;
import com.wxy.user.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author wuxingyu
* @description 针对表【t_user(用户表)】的数据库操作Service实现
* @createDate 2024-07-08 21:12:21
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

    @Override
    public void login(User user) {
        String password = user.getPassword();
        String username = user.getUsername();
        // 根据用户名查询数据库
        User userDb = this.getOne(new QueryWrapper<User>().eq("username", username));
        String encryptPwd = userDb.getPassword();
        // 解密
        String decryptPwd = Encrypt.decrypt(encryptPwd);
        // 判断密码是否正确
        if (!password.equals(decryptPwd)) {
            throw new RuntimeException("密码错误");
        }
        userDb.setPassword(null);
        StpUtil.login(userDb.getId(), new SaLoginModel().setExtra("model", userDb));


    }

    @Override
    public void register(User user) {
        // 密码不能重复
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        User user1 = getOne(queryWrapper);
        if (user1 != null){
            throw new RuntimeException("用户名已存在");
        }
        // 加密密码
        String password = user.getPassword();
        String encryptPwd = Encrypt.encrypt(password);
        user.setPassword(encryptPwd);
        this.save(user);
    }

    @Override
    public void changePassword() {

    }

    @Override
    public void changeUserInfo() {

    }

    @Override
    public void getUserInfo() {

    }
}




