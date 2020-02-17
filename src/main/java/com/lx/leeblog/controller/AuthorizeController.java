package com.lx.leeblog.controller;

import com.lx.leeblog.dto.AccessTokenDto;
import com.lx.leeblog.dto.GithubUser;
import com.lx.leeblog.pojo.User;
import com.lx.leeblog.service.ClientUser;
import com.lx.leeblog.service.UserCheck;
import com.lx.leeblog.util.GithubProvider;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
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
    private UserCheck userCheck;

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
        GithubUser githubUser = GithubProvider.getUser(accessToken);
        User user = new User();
        user.setUsername(githubUser.getLogin());
        user.setPassword(githubUser.getId().toString());
        user.setAvatar(githubUser.getAvatar_url());
        User user1 = userCheck.checkNormalUser(user);
        if (user1!=null) {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            try {
                subject.login(token);
                User user2 = (User) subject.getPrincipal();
                Session session = subject.getSession();
                session.setAttribute("user", user2);
                return "redirect:/index";
            } catch (UnknownAccountException e) {
                // 错误
                e.printStackTrace();
            }
        }else {
            Integer i = clientUser.addUser(user);
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            try {
                subject.login(token);
                User user3 = (User) subject.getPrincipal();
                Session session = subject.getSession();
                session.setAttribute("user", user3);
                return "redirect:/index";
            } catch (UnknownAccountException e) {
                // 错误
                e.printStackTrace();
            }
        }
        return "index";
    }
}
