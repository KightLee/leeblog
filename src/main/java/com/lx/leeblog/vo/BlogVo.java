package com.lx.leeblog.vo;

import lombok.Data;

import java.util.Date;

/**
 * create by @author lixing on 2020/2/8 19:00
 */
@Data
public class BlogVo {
    private Long id;
    private String avatar;
    private Date createTime;
    private Long recommend;
    private String title;
    private Long views;
    private Long userId;
}
