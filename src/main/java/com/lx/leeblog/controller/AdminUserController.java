package com.lx.leeblog.controller;

import com.lx.leeblog.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * create by @author lixing on 2020/1/28 20:16
 * 用户编辑 新增类
 */
@Controller
@RequestMapping("/admin")
public class AdminUserController {

    @PostMapping("/useradd")
    public String addUser(User user){
        System.out.println(user);
        return null;

    }
    @PostMapping("/useredit")
    public String editUser(User user){
        System.out.println(user);
        return null;

    }
}
