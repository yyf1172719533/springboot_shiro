package com.timain.shiro.mapper;

import com.timain.shiro.pojo.Permission;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/17 21:46
 */
@Repository
public interface PermissionMapper {

    /**
     * 根据用户ID查询用户权限
     * @param userId
     * @return
     */
    Set<Permission> queryPermissionByUserId(String userId);
}
