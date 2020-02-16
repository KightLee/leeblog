package com.lx.leeblog.service;

import com.lx.leeblog.pojo.User;

/**
 * create by @author lixing on 2020/1/20 22:19
 */
public interface ClientUser {
    Integer addUser(User user);
    User selectUserByUsername(String username);
    User selectUserByUserId(Long id);
}
