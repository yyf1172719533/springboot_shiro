package com.timain.shiro.controller;

import com.timain.shiro.vo.ActiverUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/17 22:22
 */
@Controller
public class LoginController {

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin() {
        return "login";
    }

    /**
     * 跳转到首页
     * @return
     */
    @RequestMapping("main")
    public String toIndex() {
        return "index";
    }

    /**
     * 登录
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("login")
    public String login(String username, String password, HttpSession session) {
        if (!StringUtils.isEmpty(username)) {
            //获取subject
            Subject subject = SecurityUtils.getSubject();
            //封装用户数据
            AuthenticationToken token = new UsernamePasswordToken(username, password);
            try {
                subject.login(token);
                System.out.println("登录成功");
                ActiverUser activerUser = (ActiverUser) subject.getPrincipal();
                session.setAttribute("user", activerUser.getUser());
                return "redirect:/main";
            } catch (UnknownAccountException e) {
                System.out.println("用户名不存在");
                session.setAttribute("msg", "用户名不存在");
            } catch (IncorrectCredentialsException e) {
                System.out.println("密码错误");
                session.setAttribute("msg", "密码错误");
            }
        }
        return "login";
    }

    /**
     * 登出
     * @return
     */
    @RequestMapping("logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (null!=subject) {
            subject.logout();
        }
        return "redirect:/main";
    }

    /**
     * 未授权跳转页面
     * @return
     */
    @RequestMapping("unAuth")
    public String unAuth() {
        return "/error/unAuth";
    }
}
