package com.lx.leeblog.service;

import com.lx.leeblog.dao.UserMapper;
import com.lx.leeblog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by @author lixing on 2020/1/20 22:19
 */
@Service
public class ClientUserImpl implements ClientUser {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer addUser(User user) {
        int state = userMapper.insert(user);
        return state;
    }

    @Override
    public User selectUserByUsername(String username) {
        User user = userMapper.selectByUsername(username);
        return user;
    }
}
