package com.timain.shiro.service.impl;

import com.timain.shiro.mapper.UserMapper;
import com.timain.shiro.pojo.User;
import com.timain.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/17 21:23
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户名查询用户对象
     *
     * @param userName
     * @return
     */
    @Override
    public User findUserByUserName(String userName) {
        return userMapper.queryUserByUserName(userName);
    }
}
