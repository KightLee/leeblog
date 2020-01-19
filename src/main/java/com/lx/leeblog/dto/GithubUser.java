package com.lx.leeblog.dto;

import lombok.Data;

/**
 * create by @author lixing on 2020/1/15 9:31
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;
}
