package com.lx.leeblog.controller;

import com.lx.leeblog.dao.BlogMapper;
import com.lx.leeblog.pojo.Blog;
import com.lx.leeblog.pojo.Tag;
import com.lx.leeblog.pojo.Type;
import com.lx.leeblog.service.AdminContent;
import com.lx.leeblog.service.TagService;
import com.lx.leeblog.service.TypeService;
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

    @Autowired
    private TagService tagService;

    @Autowired
    private TypeService typeService;

    @PostMapping("/tagedit")
    @ResponseBody
    public Integer Tagedit(Tag tag) {
        int i = tagService.updatetagByClass(tag);
        return i;
    }

    @PostMapping("/tagadd")
    @ResponseBody
    public Integer Tagadd(Tag tag) {
        int i = tagService.addTag(tag);
        return i;
    }

    @PostMapping("/tagdelete")
    @ResponseBody
    public Integer TagDelete(@RequestBody Integer[] arrDel) {
        int i = tagService.deleteTag(arrDel);
        return i;
    }

    @PostMapping("/tagdeleteone")
    @ResponseBody
    public Integer tagdeleteone(Integer arrDel) {
        int i = tagService.deleteTagOne(arrDel);
        return i;
    }

    @PostMapping("/typedelete")
    @ResponseBody
    public Integer typedelete(Integer arrDel) {
        int i = typeService.deleteTypeFromids(arrDel);
        return i;
    }

    @PostMapping("/typeadd")
    @ResponseBody
    public Integer typeadd(Type type) {
        if (type == null) {
            return 0;
        }
        int i = typeService.addType(type);
        return i;
    }

    @PostMapping("/typeedit")
    @ResponseBody
    public Integer typeedit(Type type) {
        if (type == null) {
            return 0;
        }
        int i = typeService.editType(type);
        return i;
    }

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

    @PostMapping("/blogdeleteone")
    @ResponseBody
    public Integer BlogDelete(Long arrDel) {
        int i = adminContent.deleteBlogOneById(arrDel);
        return i;
    }
}
