package com.lx.leeblog.controller;

import com.lx.leeblog.dto.CommentDto;
import com.lx.leeblog.pojo.Comment;
import com.lx.leeblog.pojo.User;
import com.lx.leeblog.service.CommentService;
import com.lx.leeblog.vo.ResultVo;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * create by @author lixing on 2020/2/14 19:53
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;
    @PostMapping("/comment")
    public String commentSave(CommentDto commentDto, HttpSession session, Model model) {
        if (StringUtils.isEmpty(commentDto.getContent())) {

        }
        if (commentDto.getParentCommentId() != -1) {
            User user = (User)session.getAttribute("user");
            Comment comment = new Comment();
            comment.setContent(commentDto.getContent());
            comment.setBlogId(commentDto.getId());
            comment.setNickname(user.getUsername());
            comment.setAvatar(user.getAvatar());
            comment.setParentCommentId(commentDto.getParentCommentId());
            Integer id = commentService.insertComment(comment);
            List<Comment> allComment = commentService.findAllCommentByUserBlogId(commentDto.getId());
            model.addAttribute("comm", allComment);
            return "detail :: commentList";
        }
        else {
            User user = (User)session.getAttribute("user");
            Comment comment = new Comment();
            comment.setContent(commentDto.getContent());
            comment.setBlogId(commentDto.getId());
            comment.setNickname(user.getUsername());
            comment.setAvatar(user.getAvatar());
            Integer id = commentService.insertComment(comment);
            List<Comment> allComment = commentService.findAllCommentByUserBlogId(commentDto.getId());
            model.addAttribute("comm", allComment);
            return "detail :: commentList";
        }
    }
/*  测试load回显div
    @PostMapping("/commentParent")
    public String commentParent(CommentDto commentDto, HttpSession session, Model model) {
        if (commentDto.getParentCommentId() != -1) {
            User user = (User)session.getAttribute("user");
            Comment comment = new Comment();
            comment.setContent(commentDto.getContent());
            comment.setBlogId(commentDto.getId());
            comment.setNickname(user.getUsername());
            comment.setAvatar(user.getAvatar());
            comment.setParentCommentId(commentDto.getParentCommentId());
            Integer id = commentService.insertComment(comment);
            List<Comment> allComment = commentService.findAllCommentByUserBlogId(commentDto.getId());
            model.addAttribute("comm", allComment);
            return "detail :: commentList";
        }
        return null;
    }*/
}
