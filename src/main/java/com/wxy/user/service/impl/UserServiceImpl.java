package com.wxy.user.service.impl;

import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxy.common.constant.StateCode;
import com.wxy.common.exception.BizException;
import com.wxy.common.util.crypto.CryptoFactory;
import com.wxy.common.util.crypto.CryptoType;
import com.wxy.user.domain.User;
import com.wxy.user.service.UserService;
import com.wxy.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
* @author wuxingyu
* @description 针对表【t_user(用户表)】的数据库操作Service实现
* @createDate 2024-07-08 21:12:21
*/
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

    private final UserMapper userMapper;

    @Override
    public void login(User user) {
        String password = user.getPassword();
        String username = user.getUsername();
        // 根据用户名查询数据库
        User userDb = this.getOne(new QueryWrapper<User>().eq("username", username));
        String encryptPwd = userDb.getPassword();
        // 解密
        String decryptPwd = CryptoFactory.getCrypto(CryptoType.AES.getType()).decrypt(encryptPwd);
        // 判断密码是否正确
        if (!password.equals(decryptPwd)) {
            throw new BizException(StateCode.PASSWORD_ERROR,"密码错误");
        }
        userDb.setPassword(null);
        StpUtil.login(userDb.getId(), new SaLoginModel().setExtra("model", userDb));
    }

    @Override
    public void register(User user) {
        // 账号不能重复
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        User user1 = getOne(queryWrapper);
        if (user1 != null){
            throw new BizException(StateCode.ACCOUNT_EXIST, "用户名已存在");
        }
        // 加密密码
        String password = user.getPassword();
        String encryptPwd = CryptoFactory.getCrypto(CryptoType.AES.getType()).encrypt(password);
        user.setPassword(encryptPwd);
        this.save(user);
        user.setPassword(null);
        // 注册完成后登录
        StpUtil.login(user.getId(), new SaLoginModel().setExtra("model", user));
    }

    @Override
    public void changePassword(User user) {
        // 加密密码
        String password = user.getPassword();
        String encryptPwd = CryptoFactory.getCrypto(CryptoType.AES.getType()).encrypt(password);
        userMapper.updatePasswordById(encryptPwd, StpUtil.getLoginIdAsLong());
        // 登出
        StpUtil.logout();
    }

    @Override
    public void changeUserInfo(User user) {
        user.setId(StpUtil.getLoginIdAsLong());
        // 账号不可以改
        user.setUsername(null);
        this.updateById(user);
    }

}




