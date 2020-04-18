package com.timain.shiro.service.impl;

import com.timain.shiro.mapper.PermissionMapper;
import com.timain.shiro.pojo.Permission;
import com.timain.shiro.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/17 21:48
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 根据用户ID查询用户权限
     * @param userId
     * @return
     */
    @Override
    public Set<Permission> findPermissionByUserId(String userId) {
        return permissionMapper.queryPermissionByUserId(userId);
    }
}
