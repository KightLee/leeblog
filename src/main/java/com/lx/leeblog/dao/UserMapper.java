package com.lx.leeblog.dao;

import com.lx.leeblog.pojo.User;
import com.lx.leeblog.pojo.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    int insertFocuOn(@Param("fid") Long id, @Param("uid") Long uid);

    int selectsCountWithNotCheck();

    List<User> selectByExample(UserExample example);

    List<User> selectAll();

    List<User> selectUserFocuon(Long id);

    List<Long> selectFocuon(Long id);

    int selectPageCount();

    User selectByPrimaryKey(Long id);

    User selectByUsername(String username);

    User selectPermissionByUsername(String username);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}
