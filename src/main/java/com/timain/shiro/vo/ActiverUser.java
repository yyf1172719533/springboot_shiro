package com.timain.shiro.vo;

import com.timain.shiro.pojo.Permission;
import com.timain.shiro.pojo.Role;
import com.timain.shiro.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/17 21:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActiverUser implements Serializable {

    private User user;
    private Set<Role> roles;
    private Set<Permission> permissions;
}
