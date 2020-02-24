package com.lx.leeblog.service;

import com.lx.leeblog.dao.UserMapper;
import com.lx.leeblog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        user.setCreateTime(new Date());
        String email = user.getEmail();
        if (email != null) {
            user.setType(1);
        } else {
            user.setType(0);
        }
        int id = userMapper.insert(user);

        return id == 0?1:0;
    }

    @Override
    public User selectUserByUsername(String username) {
        User user = userMapper.selectByUsername(username);
        return user;
    }

    @Override
    public User selectUserByUserId(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public int selectCountNotCheck() {
        int i = userMapper.selectsCountWithNotCheck();
        return i;
    }

    @Override
    public Boolean selectFocuOn(Long id,Long userid) {
        List<Long> longs = userMapper.selectFocuon(id);
        for (Long aLong : longs) {
            if (aLong.equals(userid)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int insertFocuOn(Long id, Long userid) {
        int i = userMapper.insertFocuOn(id, userid);
        return i;
    }

    @Override
    public List<User> selectUserFocuon(Long id) {
        List<User> users = userMapper.selectUserFocuon(id);
        return users;
    }
}
