package com.lx.leeblog.controller;

import com.lx.leeblog.pojo.Blog;
import com.lx.leeblog.pojo.Tag;
import com.lx.leeblog.pojo.Type;
import com.lx.leeblog.pojo.User;
import com.lx.leeblog.service.BlogService;
import com.lx.leeblog.service.ClientUser;
import com.lx.leeblog.service.TagService;
import com.lx.leeblog.service.TypeService;
import com.lx.leeblog.vo.BlogVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @GetMapping("/")
    public String index() {
        return "redirect:/index";
    }
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
        List<Type> types = typeService.selectAllType();
        List<Tag> tags = tagService.selectAllTag();
        model.addAttribute("blogs", blogVos);
        model.addAttribute("types", types);
        model.addAttribute("tags", tags);
        return "index";
    }

    @GetMapping("/indextag")
    public String indextag(String tag, Model model) {
        List<User> users = blogService.selectBlogByTagId(tag);
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
        List<Type> types = typeService.selectAllType();
        List<Tag> tags = tagService.selectAllTag();
        model.addAttribute("blogs", blogVos);
        model.addAttribute("types", types);
        model.addAttribute("tags", tags);
        return "index";
    }

    @GetMapping("/unAuth")
    public String unAuth() {
        return "/unAuth";
    }
    @GetMapping("/logout")
    public String logout() {
        return "login";
    }
}
