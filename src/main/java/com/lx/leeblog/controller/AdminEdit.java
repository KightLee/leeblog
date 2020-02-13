package com.lx.leeblog.controller;

import com.lx.leeblog.dao.BlogMapper;
import com.lx.leeblog.pojo.Blog;
import com.lx.leeblog.service.AdminContent;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * create by @author lixing on 2020/2/9 22:16
 */
@Controller
@RequestMapping("/admin")
public class AdminEdit {

    @Autowired
    private AdminContent adminContent;

    @PostMapping("/blogedit")
    @ResponseBody
    public Integer Blogedit(Blog blog) {
        int i = adminContent.updateBlogByUserId(blog);
        return i;
    }

    @PostMapping("/blogdelete")
    @ResponseBody
    public Integer BlogDelete(@RequestBody Integer[] arrDel) {
        int i = adminContent.deleteBlogById(arrDel);
        return i;
    }
}
