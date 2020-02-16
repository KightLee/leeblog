package com.lx.leeblog.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * create by @author lixing on 2020/2/14 21:05
 */
@Data
public class CommentDto {
    private Long id;
    private String content;
    private Long parentCommentId;
}
