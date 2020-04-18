package com.timain.shiro.mapper;

import com.timain.shiro.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/17 21:46
 */
@Repository
public interface RoleMapper {

    /**
     * 根据用户ID查询用户角色
     * @param userId
     * @return
     */
    Set<Role> queryRolesByUserId(String userId);
}
