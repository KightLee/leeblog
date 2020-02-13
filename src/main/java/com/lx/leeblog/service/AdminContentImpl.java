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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
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

    @Override
    public int updateBlogByUserId(Blog blog) {
        return blogMapper.updateByPrimaryKeySelective(blog);
    }

    /**
     *  后续删除还得连同评论表的数据一起清了
     * @param ids
     * @return
     */
    @Transactional
    @Override
    public int deleteBlogById(Integer[] ids) {
        for (int i = 0; i < ids.length; i++) {
            int i1 = blogMapper.deleteByPrimaryKey(ids[i].longValue());
            if (i1 == 0) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
        return 1;
    }


}
