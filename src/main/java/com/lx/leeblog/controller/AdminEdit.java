package com.lx.leeblog.controller;

import com.lx.leeblog.pojo.Blog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * create by @author lixing on 2020/2/9 22:16
 */
@Controller
@RequestMapping("/admin")
public class AdminEdit {

    @PostMapping("/blogedit")
    @ResponseBody
    public String Blogedit(Blog blog) {
        System.out.println();
        return null;
    }
}
