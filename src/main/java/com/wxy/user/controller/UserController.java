package com.wxy.user.controller;


import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wxy.common.pojo.Insert;
import com.wxy.common.pojo.Query;
import com.wxy.common.pojo.Resp;
import com.wxy.common.util.Encrypt;
import com.wxy.user.domain.User;
import com.wxy.user.domain.bo.UserBo;
import com.wxy.user.domain.vo.UserVo;
import com.wxy.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 登录
    @PostMapping("/login")
    public Resp login(@Validated({Query.class}) @RequestBody UserBo userBo) {
        User user = BeanUtil.toBean(userBo, User.class);
        userService.login(user);
        return Resp.success("登陆成功");
    }


    @PostMapping("/register")
    // 注册
    public Resp register(@Validated({Insert.class}) @RequestBody UserBo userBo) {
        User user = BeanUtil.toBean(userBo, User.class);
        userService.register(user);
        return Resp.success("注册成功");
    }

    // 修改密码
    public void changePassword() {
    }

    // 修改个人信息
    public void changeUserInfo() {
    }

    // 查询个人信息
    @GetMapping("/userInfo")
    public Resp getUserInfo() {
        Object model = StpUtil.getExtra("model");
        return Resp.success(model);
    }


}
