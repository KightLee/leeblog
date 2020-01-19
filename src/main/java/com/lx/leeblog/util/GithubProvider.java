package com.lx.leeblog.util;

import com.alibaba.fastjson.JSON;
import com.lx.leeblog.dto.*;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * create by @author lixing on 2020/1/14 22:49
 */
@Component
public class GithubProvider {
    /**
     * 获取token
     * @param accessTokenDto
     * @return
     */
    public static String getAccessToken(AccessTokenDto accessTokenDto) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDto));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String res = response.body().string();
            System.out.println(res);
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * TOken 获取用户信息
     * @param accessToken
     * @return
     */
    public static GithubUser getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?"+accessToken)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String str = response.body().string();
            GithubUser githubUser = JSON.parseObject(str, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
