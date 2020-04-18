package com.timain.shiro.service.impl;

import com.timain.shiro.mapper.RoleMapper;
import com.timain.shiro.pojo.Role;
import com.timain.shiro.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/17 21:47
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 根据用户ID查询用户角色
     *
     * @param userId
     * @return
     */
    @Override
    public Set<Role> findRolesByUserId(String userId) {
        return roleMapper.queryRolesByUserId(userId);
    }
}
