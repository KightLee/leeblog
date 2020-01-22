package com.lx.leeblog.service;

import com.lx.leeblog.dao.UserMapper;
import com.lx.leeblog.pojo.User;
import com.lx.leeblog.vo.Page;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by @author lixing on 2020/1/20 12:40
 * 拿表格数据接口的实现
 */
@Service
public class AdminContentImpl implements AdminContent {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectPageList() {
        List<User> users = userMapper.selectAll();
        return users;
    }

    @Override
    public Integer selectPageCount() {
        int cc = userMapper.selectPageCount();
        return cc;
    }
}
