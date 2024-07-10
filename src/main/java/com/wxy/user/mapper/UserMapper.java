package com.wxy.user.mapper;
import org.apache.ibatis.annotations.Param;

import com.wxy.user.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author wuxingyu
* @description 针对表【t_user(用户表)】的数据库操作Mapper
* @createDate 2024-07-08 21:12:21
* @Entity com.wxy.user.domain.User
*/
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据id修改密码
     * @param password 密码
     * @param id 用户id
     */
    void updatePasswordById(@Param("password") String password, @Param("id") Long id);
}




