package com.lx.leeblog.service;

import com.lx.leeblog.pojo.User;

import java.util.List;

/**
 * create by @author lixing on 2020/1/20 22:19
 */
public interface ClientUser {
    Integer addUser(User user);
    User selectUserByUsername(String username);
    User selectUserByUserId(Long id);
    int selectCountNotCheck();
    Boolean selectFocuOn(Long id,Long userid);
    int insertFocuOn(Long id,Long userid);
    List<User> selectUserFocuon(Long id);
}
