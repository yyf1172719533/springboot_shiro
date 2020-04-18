package com.timain.shiro.service;

import com.timain.shiro.pojo.Permission;

import java.util.Set;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/17 21:47
 */
public interface PermissionService {

    /**
     * 根据用户ID查询用户权限
     * @param userId
     * @return
     */
    Set<Permission> findPermissionByUserId(String userId);
}
