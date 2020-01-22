package com.lx.leeblog.service;

import com.lx.leeblog.pojo.User;
import com.lx.leeblog.vo.Page;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * create by @author lixing on 2020/1/20 12:39
 */
public interface AdminContent {
    List<User> selectPageList();
    Integer selectPageCount();
}
