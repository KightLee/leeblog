package com.lx.leeblog.controller;

import com.lx.leeblog.pojo.Blog;
import com.lx.leeblog.pojo.User;
import com.lx.leeblog.service.BlogService;
import com.lx.leeblog.service.ClientUser;
import com.lx.leeblog.vo.BlogVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * create by @author lixing on 2020/1/14 19:38
 * 主页，包含分类，标签和博客的内容 要用用户对多blog才能拿到用户信息
 */
@Controller
public class IndexController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/index")
    public String index(Model model) {
        List<User> users = blogService.selectAllBlog();
        List<BlogVo> blogVos = new ArrayList<>();
        for (User user : users) {
            List<Blog> blogs = user.getBlogs();
            for (Blog blog : blogs) {
                BlogVo blogVo = new BlogVo();
                BeanUtils.copyProperties(blog, blogVo);
                blogVo.setAvatar(user.getAvatar());
                blogVos.add(blogVo);
            }
        }

        model.addAttribute("blogs", blogVos);
        return "index";
    }

    @GetMapping("/logout")
    public String logout() {
        return "login";
    }
}
