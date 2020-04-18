package com.timain.shiro.service;

import com.timain.shiro.pojo.Role;

import java.util.Set;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/17 21:47
 */
public interface RoleService {

    /**
     * 根据用户ID查询用户角色
     * @param userId
     * @return
     */
    Set<Role> findRolesByUserId(String userId);
}
