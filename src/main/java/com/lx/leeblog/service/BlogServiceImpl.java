package com.lx.leeblog.service;

import com.lx.leeblog.dao.BlogMapper;
import com.lx.leeblog.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * create by @author lixing on 2020/2/4 22:59
 */
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;
    @Override
    public int save(Blog blog) {
        blog.setCreateTime(new Date());
        return blogMapper.insertSelective(blog);
    }
}
