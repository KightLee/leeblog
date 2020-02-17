package com.lx.leeblog.service;

import com.lx.leeblog.dao.BlogMapper;
import com.lx.leeblog.dao.TypeMapper;
import com.lx.leeblog.dao.UserMapper;
import com.lx.leeblog.pojo.Blog;
import com.lx.leeblog.pojo.Type;
import com.lx.leeblog.pojo.User;
import com.lx.leeblog.util.MarkdownUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * create by @author lixing on 2020/2/4 22:59
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public int save(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setCommentabled(true);
        blog.setPublished(false);
        blog.setRecommend(new Long(0));
        blog.setShareStatement(new Long(0));
        blog.setViews(new Long(0));
        return blogMapper.insertSelective(blog);
    }

    @Override
    public List<User> selectAllBlog() {
        List<User> blogs = blogMapper.selectAllBlogWithUser();
        return blogs;
    }

    @Override
    public List<User> selectBlogByTagId(String tag) {
        List<User> users = blogMapper.selectAllBlogWithUserAndTagName('%'+tag+'%');
        if (users.size() == 0) {
            users = blogMapper.selectAllBlogWithUser();
        }
        return users;
    }

    @Override
    public Blog selectBlogByBlogId(Long id) {
        Blog blog = blogMapper.selectByPrimaryKey(id);
        String content = blog.getContent();
        String contentChange = MarkdownUtil.markdownToHtmlExtensions(content);
        blog.setContent(contentChange);
        return blog;
    }

    @Override
    public Long addView(Long id) {
        int i = blogMapper.updateByPrimaryKeyView(id);
        Long aLong = blogMapper.selectViewWithId(id);
        return aLong;
    }
}
