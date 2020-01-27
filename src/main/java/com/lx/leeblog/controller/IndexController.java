package com.lx.leeblog.controller;

import com.lx.leeblog.pojo.User;
import com.lx.leeblog.service.ClientUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * create by @author lixing on 2020/1/14 19:38
 */
@Controller
public class IndexController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
