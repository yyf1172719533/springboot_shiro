package com.timain.shiro.config;

import com.timain.shiro.realm.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro配置类
 * @author yyf
 * @version 1.0
 * @date 2020/4/18 9:58
 */
@Configuration
public class ShiroConfig {

    /**
     * 创建userRealm并注入HashedCredentialsMatcher
     * @param matcher
     * @return
     */
    @Bean("userRealm")
    public UserRealm userRealm (@Qualifier("hashedCredentialsMatcher") HashedCredentialsMatcher matcher) {
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(matcher);
        return userRealm;
    }

    /**
     * 配置散列算法与凭证
     * @return
     */
    @Bean("hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //指定加密方式为MD5
        credentialsMatcher.setHashAlgorithmName("MD5");
        //设置加密次数
        credentialsMatcher.setHashIterations(1024);
        //存储散列后的密码是否为16进制
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }

    /**
     * 创建安全管理器
     * @param credentialsMatcher
     * @return
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(HashedCredentialsMatcher credentialsMatcher) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //将userRealm注入到安全管理器中
        securityManager.setRealm(userRealm(credentialsMatcher));
        return securityManager;
    }

    /**
     * shiro过滤配置
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        //注入securityManager
        factoryBean.setSecurityManager(securityManager);
        //设置登录成功后跳转页面
        factoryBean.setSuccessUrl("/main");
        //设置跳转到登录页面
        factoryBean.setLoginUrl("/toLogin");
        //设置未授权页面
        factoryBean.setUnauthorizedUrl("/unAuth");

        /**
         * Shiro内置过滤器，可以实现拦截器相关的拦截器
         *    常用的过滤器：
         *      anon：无需认证（登录）可以访问
         *      authc：必须认证才可以访问
         *      user：如果使用rememberMe的功能可以直接访问
         *      perms：该资源必须得到资源权限才可以访问
         *      role：该资源必须得到角色权限才可以访问
         **/
        Map<String, String> filterMap = new LinkedHashMap<>();

        filterMap.put("/login","anon");
        filterMap.put("/user/index","authc");
        filterMap.put("/vip/index","roles[vip]");
        filterMap.put("/druid/**", "anon");
        filterMap.put("/static/**","anon");

        filterMap.put("/**","authc");
        filterMap.put("/logout", "logout");

        factoryBean.setFilterChainDefinitionMap(filterMap);

        return factoryBean;
    }
}
