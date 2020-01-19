package com.lx.leeblog.dto;

import lombok.Data;

/**
 * create by @author lixing on 2020/1/14 22:19
 */
@Data
public class AccessTokenDto {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
