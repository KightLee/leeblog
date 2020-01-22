package com.lx.leeblog.controller;

import com.lx.leeblog.pojo.User;
import com.lx.leeblog.service.AdminContent;
import com.lx.leeblog.vo.Page;
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
    public ResultVo<User> findAllUser() {
        List<User> users = adminContent.selectPageList();
        Integer count = adminContent.selectPageCount();
        ResultVo<User> RV = new ResultVo<>();
        RV.setData(users);
        RV.setMsg("");
        RV.setCount(count);
        RV.setCode(0);
        return RV;
    }
}
