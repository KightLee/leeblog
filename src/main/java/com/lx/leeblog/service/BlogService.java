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
    int save(Blog blog);
    List<User> selectAllBlog();
    List<User> selectAllBlogHot();
    List<User> selectAllBlogNew();
    List<User> selectAllBlogMost();
    List<User> selectAllBlogRecommend();
    List<User> selectBlogByTagId(String tag);
    List<User> selectBlogByTypeId(Long id);
    List<User> selectBlogBySearch(String str);
    List<Blog> selectBlogByUserId(Long id);
    Blog selectBlogByBlogId(Long id);
    Long addView(Long id);
    int selectBlogWithNoPublished();
    int selectUserFocuon(Long id);
    int selectUserBeFocuon(Long id);
}
