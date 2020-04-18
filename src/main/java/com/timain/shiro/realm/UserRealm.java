package com.timain.shiro.realm;

import com.timain.shiro.pojo.Permission;
import com.timain.shiro.pojo.Role;
import com.timain.shiro.pojo.User;
import com.timain.shiro.service.PermissionService;
import com.timain.shiro.service.RoleService;
import com.timain.shiro.service.UserService;
import com.timain.shiro.vo.ActiverUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/17 21:07
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;


    /**
     * 授权
     * @param principal
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        System.out.println("授权");
        ActiverUser activerUser = (ActiverUser) principal.getPrimaryPrincipal();
        List<String> roles = new ArrayList<>();
        List<String> permissions = new ArrayList<>();
        for (Role role : activerUser.getRoles()) {
            roles.add(role.getName());
        }
        for (Permission permission : activerUser.getPermissions()) {
            permissions.add(permission.getUrl());
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if (null!=roles && roles.size()>0) {
            info.addRoles(roles);
        }
        if (null!=permissions && permissions.size()>0) {
            info.addStringPermissions(permissions);
        }
        return info;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证");
        String userName = token.getPrincipal().toString();
        User user = this.userService.findUserByUserName(userName);
        if (null!=user) {
            //查询角色
            Set<Role> roleSet = this.roleService.findRolesByUserId(user.getId());
            //查询权限
            Set<Permission> permissionSet = this.permissionService.findPermissionByUserId(user.getId());
            ActiverUser activerUser = new ActiverUser(user, roleSet, permissionSet);
            //盐
            ByteSource credentialsSalt = ByteSource.Util.bytes(user.getName());
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(activerUser, user.getPassword(), credentialsSalt, this.getName());
            return info;
        }
        return null;
    }
}
