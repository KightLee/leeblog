package com.lx.leeblog.controller;

import com.lx.leeblog.dao.UserMapper;
import com.lx.leeblog.pojo.User;
import com.lx.leeblog.service.ClientUser;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * create by @author lixing on 2020/1/23 21:23
 * 用户相关的控制类
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private ClientUser clientUser;
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    /**
     * 网站的注册用户
     * @param user
     * @return
     */
    @PostMapping("/register")
    public String register(User user) {
        user.setCreateTime(new Date());
        user.setType(1);
        clientUser.addUser(user);
        return "login_user";
    }

    /**
     * 查看用户存在与否， 再判断密码
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public String login(String username, String password) {
        User user = clientUser.selectUserByUsername(username);
        if (user.getPassword() == password) {
            return "index";
        }
        return "index";
    }
}
