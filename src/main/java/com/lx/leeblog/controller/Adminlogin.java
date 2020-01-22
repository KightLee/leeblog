package com.lx.leeblog.controller;

import com.lx.leeblog.pojo.User;
import com.lx.leeblog.service.UserCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * create by @author lixing on 2020/1/19 16:48
 */
@Controller
@RequestMapping("/admin")
public class Adminlogin {

    @Autowired
    private UserCheck userCheck;
    @PostMapping("/login")
    public String validUser(User user){
        userCheck.checkAdminUser(user);
        return "/admin/index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    public String index() {
        return "admin/index";
    }
}
