package com.lx.leeblog.service;

import com.lx.leeblog.pojo.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by @author lixing on 2020/2/22 19:39
 */
public interface YourLike {
    public List<Blog> yourlike(Blog blog);
}
