package com.lx.leeblog.service;

import com.lx.leeblog.dao.CommentMapper;
import com.lx.leeblog.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * create by @author lixing on 2020/2/14 20:16
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> findAllComment() {
        List<Comment> comments = commentMapper.selectAllComment();
        return comments;
    }

    @Override
    public List<Comment> findAllCommentByUserBlogId(Long id) {
        List<Comment> comments = commentMapper.selectCommentByUserBlogId(id);
        return comments;
    }

    @Override
    public Integer insertComment(Comment comment) {
        comment.setCreateTime(new Date());
        comment.setLikeCount(new Long(0));
        int i = commentMapper.insertSelective(comment);
        return i;
    }
}
