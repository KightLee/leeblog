package com.lx.leeblog.controller;

import com.lx.leeblog.dto.AccessTokenDto;
import com.lx.leeblog.dto.GithubUser;
import com.lx.leeblog.service.ClientUser;
import com.lx.leeblog.util.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * create by @author lixing on 2020/1/14 21:22
 * github登录controller
 */
@Controller
public class AuthorizeController {
    @Autowired
    private ClientUser clientUser;
    @GetMapping("/callback")
    public String callback(String code, String state) {
        AccessTokenDto accessTokenDto = new  AccessTokenDto();
        accessTokenDto.setCode(code);
        accessTokenDto.setState(state);
        accessTokenDto.setRedirect_uri("http://localhost:8088/callback");
        accessTokenDto.setClient_id("94c859cbf53a5eed0642");
        accessTokenDto.setClient_secret("6b7cd7ea1c871a3329422647783f167b7450ae97");
        String accessToken = GithubProvider.getAccessToken(accessTokenDto);
        GithubUser user = GithubProvider.getUser(accessToken);
        // 拿到用户名存入数据库, 更新session
//        clientUser.addUser(user);
        return "index";
    }
}
