package com.lx.leeblog.service;

import com.lx.leeblog.dao.BlogMapper;
import com.lx.leeblog.dao.TagMapper;
import com.lx.leeblog.dao.TypeMapper;
import com.lx.leeblog.dao.UserMapper;
import com.lx.leeblog.pojo.Blog;
import com.lx.leeblog.pojo.Tag;
import com.lx.leeblog.pojo.Type;
import com.lx.leeblog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by @author lixing on 2020/1/20 12:40
 * 拿表格数据接口的实现
 */
@Service
public class AdminContentImpl implements AdminContent {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private TypeMapper typeMapper;

    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Tag> selectPageTagList() {
        return tagMapper.selectAllTags();
    }

    @Override
    public List<Type> selectPageTypeList() {
        List<Type> types = typeMapper.selectAllType();
        return types;
    }

    @Override
    public List<Blog> selectPageBlogList() {
        return blogMapper.selectAllBlog();
    }

    @Override
    public List<User> selectPageList() {
        List<User> users = userMapper.selectAll();
        return users;
    }

    @Override
    public Integer selectPageCount() {
        int cc = userMapper.selectPageCount();
        return cc;
    }
}
