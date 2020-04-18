package com.timain.shiro.controller;

import com.timain.shiro.vo.ActiverUser;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/18 17:14
 */
@Controller
public class UserController {

    /**
     * 跳转到用户首页
     * @param session
     * @return
     */
    @RequestMapping("user/index")
    public String toUserIndex(HttpSession session) {
        ActiverUser activerUser = (ActiverUser) SecurityUtils.getSubject().getPrincipal();
        session.setAttribute("userName", activerUser.getUser().getName());
        return "/user/index";
    }

    /**
     * 跳转到vip页面
     * @return
     */
    @RequestMapping("vip/index")
    public String toVipIndex() {
        return "/vip/index";
    }
}
