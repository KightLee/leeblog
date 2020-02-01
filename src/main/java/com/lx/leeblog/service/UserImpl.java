package com.lx.leeblog.service;

import com.lx.leeblog.dao.UserMapper;
import com.lx.leeblog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.UnknownServiceException;

/**
 * create by @author lixing on 2020/1/19 18:00
 */
@Service
public class UserImpl implements UserCheck{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User checkAdminUser(User user) {
        return userMapper.selectByPrimaryKey(user.getId());
    }

    @Override
    public User checkNormalUser(User user) {
        return userMapper.selectByUsername(user.getUsername());
    }

    @Override
    public User checkPermission(String username) {
        return userMapper.selectPermissionByUsername(username);
    }
}
