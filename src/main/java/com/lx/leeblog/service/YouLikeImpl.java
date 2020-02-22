package com.lx.leeblog.service;

import com.lx.leeblog.dao.BlogMapper;
import com.lx.leeblog.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by @author lixing on 2020/2/22 19:40
 */
@Service
public class YouLikeImpl implements YourLike {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public List<Blog> yourlike(Blog blog) {
        String flag = blog.getFlag();
        String replaceflag = flag.replace(',', '|');
        Long id = blog.getId();
        List<Blog> like = blogMapper.findLike(replaceflag, id);
        return like;
    }
}
