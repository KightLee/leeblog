package com.lx.leeblog.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lx.leeblog.dto.TagtypeDto;
import com.lx.leeblog.pojo.Blog;
import com.lx.leeblog.pojo.Tag;
import com.lx.leeblog.pojo.Type;
import com.lx.leeblog.pojo.User;
import com.lx.leeblog.service.AdminContent;
import com.lx.leeblog.service.BlogService;
import com.lx.leeblog.service.ClientUser;
import com.lx.leeblog.service.TagTypeService;
import com.lx.leeblog.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * create by @author lixing on 2020/1/20 12:12
 * 数据显示，分类，标签等
 */
@Controller
@RequestMapping("/admin")
public class AdminContentController {

    @Autowired
    private AdminContent adminContent;

    @Autowired
    private TagTypeService tagTypeService;

    @Autowired
    private ClientUser clientUser;

    @Autowired
    private BlogService blogService;

    /**
     *  跳转的页面
     * @return
     */
    @GetMapping("/welcome")
    public String welcome(Model model) {
        int usercheck = clientUser.selectCountNotCheck();
        int blogWithNoPublished = blogService.selectBlogWithNoPublished();
        model.addAttribute("usercheck", usercheck);
        model.addAttribute("blogWithNoPublished", blogWithNoPublished);
        return "admin/welcome";
    }
    @GetMapping("/blogadmin")
    public String blogs() {
        return "admin/blog";
    }

    @GetMapping("/useradmin")
    public String user() {
        return "admin/user";
    }

    @GetMapping("/tagadmin")
    public String tag() {
        return "admin/tag";
    }

    @GetMapping("/typeadmin")
    public String type() {
        return "admin/type";
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
    @GetMapping("/type")
    @ResponseBody
    public ResultVo<Type> findAllTypes(@RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "limit", defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Type> types = (Page<Type>) adminContent.selectPageTypeList();
        ResultVo<Type> RV = new ResultVo<>();
        RV.setData(types.getResult());
        RV.setMsg("");
        RV.setCount((int) types.getTotal());
        RV.setCode(0);
        return RV;
    }

    @GetMapping("/tags")
    @ResponseBody
    public ResultVo<TagtypeDto> findAllTags(@RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "limit", defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Tag> tags = (Page<Tag>)adminContent.selectPageTagList();
        List<TagtypeDto> collect = tags.stream().map((e) -> {
            TagtypeDto tagtypeDto = new TagtypeDto();
            tagtypeDto.setId(e.getId());
            tagtypeDto.setName(e.getName());
            String s = tagTypeService.selectTagTypeNamewithTagid(e.getTagid());
            tagtypeDto.setTagname(s);
            return tagtypeDto;
        }).collect(Collectors.toList());
        ResultVo<TagtypeDto> RV = new ResultVo<>();
        RV.setData(collect);
        RV.setMsg("");
        RV.setCount((int) tags.getTotal());
        RV.setCode(0);
        return RV;
    }
}
