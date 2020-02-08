package com.lx.leeblog.service;

import com.lx.leeblog.pojo.Blog;
import com.lx.leeblog.pojo.Tag;
import com.lx.leeblog.pojo.Type;
import com.lx.leeblog.pojo.User;

import java.util.List;

/**
 * create by @author lixing on 2020/1/20 12:39
 */
public interface AdminContent {
    List<Tag> selectPageTagList();
    List<Type> selectPageTypeList();
    List<Blog> selectPageBlogList();
    List<User> selectPageList();
    Integer selectPageCount();
}
