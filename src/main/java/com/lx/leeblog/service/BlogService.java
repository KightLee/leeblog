package com.lx.leeblog.service;

import com.lx.leeblog.dao.BlogMapper;
import com.lx.leeblog.pojo.Blog;
import com.lx.leeblog.pojo.User;
import com.lx.leeblog.vo.BlogVo;

import java.util.List;

/**
 * create by @author lixing on 2020/2/4 22:59
 */
public interface BlogService {
    public int save(Blog blog);
    public List<User> selectAllBlog();
    public List<User> selectBlogByTagId(String tag);
    public Blog selectBlogByBlogId(Long id);
    public Long addView(Long id);
}
