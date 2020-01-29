package com.lx.leeblog.service;

import com.lx.leeblog.pojo.User;

/**
 * create by @author lixing on 2020/1/19 17:59
 */
public interface UserCheck {
    public User checkAdminUser(User user);

    public User checkNormalUser(User user);
}
