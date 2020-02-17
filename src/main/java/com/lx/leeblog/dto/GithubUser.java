package com.lx.leeblog.dto;

import lombok.Data;

/**
 * create by @author lixing on 2020/1/15 9:31
 * github 返回给我的数据对象
 */
@Data
public class GithubUser {
    private String login;
    private Long id;
    private String avatar_url;
}
