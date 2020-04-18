package com.timain.shiro.service;

import com.timain.shiro.pojo.User;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/17 21:23
 */
public interface UserService {

    /**
     * 根据用户名查询用户对象
     * @param userName
     * @return
     */
    User findUserByUserName(String userName);
}
