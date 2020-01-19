package com.lx.leeblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
