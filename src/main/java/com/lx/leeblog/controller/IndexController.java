package com.lx.leeblog.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/")
    public String view() {
        return "redirect:/index";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                         @RequestParam(value = "limit", defaultValue = "10") Integer pageSize,
                         Model model, String str) {
        PageHelper.startPage(pageNum, pageSize);
        Page<User> users = (Page<User>) blogService.selectBlogBySearch(str);
        List<User> result = users.getResult();
        List<BlogVo> blogVos = new ArrayList<>();
        for (User user : result) {
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
        model.addAttribute("pages", users.getPageNum());
        return "index";
    }
    @GetMapping("/index")
    public String index(@RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                        @RequestParam(value = "limit", defaultValue = "10") Integer pageSize, Model model) {
        PageHelper.startPage(pageNum, pageSize);
        Page<User> users = (Page<User>) blogService.selectAllBlog();
        List<User> result = users.getResult();
        List<BlogVo> blogVos = new ArrayList<>();
        for (User user : result) {
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
        model.addAttribute("pages", users.getPageNum());
        return "index";
    }

    @GetMapping("/indexsort")
    public String indexsort(@RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "limit", defaultValue = "10") Integer pageSize, String sort, Model model) {
        if (sort.equals("new")) {
            PageHelper.startPage(pageNum, pageSize);
            Page<User> users = (Page<User>) blogService.selectAllBlogNew();
            List<User> result = users.getResult();
            List<BlogVo> blogVos = new ArrayList<>();
            for (User user : result) {
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
            model.addAttribute("pages", users.getPageNum());
            return "index";
        }else if (sort.equals("hot")) {
            PageHelper.startPage(pageNum, pageSize);
            Page<User> users = (Page<User>) blogService.selectAllBlogHot();
            List<User> result = users.getResult();
            List<BlogVo> blogVos = new ArrayList<>();
            for (User user : result) {
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
            model.addAttribute("pages", users.getPageNum());
            return "index";
        } else if (sort.equals("most")){
            PageHelper.startPage(pageNum, pageSize);
            Page<User> users = (Page<User>) blogService.selectAllBlogMost();
            List<User> result = users.getResult();
            List<BlogVo> blogVos = new ArrayList<>();
            for (User user : result) {
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
            model.addAttribute("pages", users.getPageNum());
            return "index";
        } else if(sort.equals("recommend")){
            PageHelper.startPage(pageNum, pageSize);
            Page<User> users = (Page<User>) blogService.selectAllBlogRecommend();
            List<User> result = users.getResult();
            List<BlogVo> blogVos = new ArrayList<>();
            for (User user : result) {
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
            model.addAttribute("pages", users.getPageNum());
            return "index";
        }
        return "redirect:/index";
    }
    /**
     * 根据标签跳转
     * @param tag
     * @param model
     * @return
     */
    @GetMapping("/indextag")
    public String indextag(@RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                           @RequestParam(value = "limit", defaultValue = "10") Integer pageSize, String tag, Model model) {
        PageHelper.startPage(pageNum, pageSize);
        Page<User> users = (Page<User>) blogService.selectBlogByTagId(tag);
        List<User> result = users.getResult();
        List<BlogVo> blogVos = new ArrayList<>();
        for (User user : result) {
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
        model.addAttribute("pages", users.getPageNum());
        return "index";
    }

    @GetMapping("/indetype")
    public String indetype(@RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                           @RequestParam(value = "limit", defaultValue = "10") Integer pageSize, Long typeid, Model model) {
        PageHelper.startPage(pageNum, pageSize);
        Page<User> users = (Page<User>) blogService.selectBlogByTypeId(typeid);
        List<User> result = users.getResult();
        List<BlogVo> blogVos = new ArrayList<>();
        for (User user : result) {
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
        model.addAttribute("pages", users.getPageNum());
        return "index";
    }
    @GetMapping("/unAuth")
    public String unAuth() {
        return "unAuth";
    }
    @GetMapping("/logout")
    public String logout() {
        return "login";
    }
}
