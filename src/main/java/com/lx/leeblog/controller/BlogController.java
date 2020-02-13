package com.lx.leeblog.controller;

import com.lx.leeblog.pojo.*;
import com.lx.leeblog.service.*;
import com.lx.leeblog.util.ErrorCode;
import com.lx.leeblog.vo.ErrorResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * create by @author lixing on 2020/2/5 19:10
 */
@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private FileService fileService;

    /**
     * 接受带文件的参数，存储后拿到文件的位置存入数据库
     * @param blogFIle
     * @param model
     * @return
     */
    @PostMapping("/publish")
    public String publish(BlogFIle blogFIle, Model model, HttpServletRequest request) {
        String path = request.getSession().getServletContext().getRealPath("upload");
        String pathName = fileService.upload(blogFIle.getAppreciation(), path);
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogFIle, blog);
        blog.setAppreciation(pathName);
        int save = blogService.save(blog);
        if (save != 0) {
            return "redirect:index";
        }
        ErrorResponse errorResponse = new ErrorResponse(
                ErrorCode.ERRORBLOG_CODE.getStatus(),
                ErrorCode.ERRORBLOG_CODE.getMsg());
        model.addAttribute("error", errorResponse);
        return "/user/edit";
    }

    @GetMapping("/detail")
    public String detail() {
        return "detail";
    }
}
