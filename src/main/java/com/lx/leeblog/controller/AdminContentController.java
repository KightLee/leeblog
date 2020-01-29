package com.lx.leeblog.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lx.leeblog.pojo.Blog;
import com.lx.leeblog.pojo.Tag;
import com.lx.leeblog.pojo.Type;
import com.lx.leeblog.pojo.User;
import com.lx.leeblog.service.AdminContent;
import com.lx.leeblog.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * create by @author lixing on 2020/1/20 12:12
 * 数据显示，分类，标签等
 */
@Controller
@RequestMapping("/admin")
public class AdminContentController {

    @Autowired
    private AdminContent adminContent;

    /**
     *  跳转的页面
     * @return
     */
    @GetMapping("/blogs-table")
    public String blogs() {
        return "admin/blog";
    }

    @GetMapping("/useradmin")
    public String user() {
        return "admin/user";
    }
    /**
     * 表格所需的参数
     * @return
     */
    @GetMapping("/users")
    @ResponseBody
    public ResultVo<User> findAllUser(@RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "limit", defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<User> users = (Page<User>)adminContent.selectPageList();
        Integer count = adminContent.selectPageCount();
        ResultVo<User> RV = new ResultVo<>();
        RV.setData(users.getResult());
        RV.setMsg("");
        RV.setCount((int) users.getTotal());
        RV.setCode(0);
        return RV;
    }
    @GetMapping("/blogs")
    @ResponseBody
    public ResultVo<Blog> findAllBlogs(@RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "limit", defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Blog> blogs = (Page<Blog>)adminContent.selectPageBlogList();
        ResultVo<Blog> RV = new ResultVo<>();
        RV.setData(blogs.getResult());
        RV.setMsg("");
        RV.setCount((int) blogs.getTotal());
        RV.setCode(0);
        return RV;
    }
    @GetMapping("/types")
    @ResponseBody
    public ResultVo<Type> findAllTypes(@RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "limit", defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Type> types = (Page<Type>)adminContent.selectPageTypeList();
        ResultVo<Type> RV = new ResultVo<>();
        RV.setData(types.getResult());
        RV.setMsg("");
        RV.setCount((int) types.getTotal());
        RV.setCode(0);
        return RV;
    }

    @GetMapping("/tags")
    @ResponseBody
    public ResultVo<Tag> findAllTags(@RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "limit", defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Tag> tags = (Page<Tag>)adminContent.selectPageTagList();
        ResultVo<Tag> RV = new ResultVo<>();
        RV.setData(tags.getResult());
        RV.setMsg("");
        RV.setCount((int) tags.getTotal());
        RV.setCode(0);
        return RV;
    }
}
