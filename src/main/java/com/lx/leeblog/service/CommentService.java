package com.lx.leeblog.service;

import com.lx.leeblog.pojo.Comment;

import java.util.List;

/**
 * create by @author lixing on 2020/2/14 20:16
 */
public interface CommentService {
    List<Comment> findAllComment();
    List<Comment> findAllCommentByUserBlogId(Long id);
    Integer insertComment(Comment comment);

}
