package com.lx.leeblog.service;

import com.lx.leeblog.pojo.Type;

import java.util.List;

/**
 * create by @author lixing on 2020/2/3 20:38
 */
public interface TypeService {
    public List<Type> selectAllType();
    public Type selectTypeByTypeId(Long id);
    public int deleteTypeFromids(Integer ids);
    public int addType(Type type);
    public int editType(Type type);
}
