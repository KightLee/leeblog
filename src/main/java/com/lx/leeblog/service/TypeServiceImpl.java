package com.lx.leeblog.service;

import com.lx.leeblog.dao.TypeMapper;
import com.lx.leeblog.pojo.Type;
import jdk.nashorn.internal.codegen.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.acl.LastOwnerException;
import java.util.List;

/**
 * create by @author lixing on 2020/2/3 20:44
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;
    @Override
    public List<Type> selectAllType() {
        return typeMapper.selectAllType();
    }

    @Override
    public Type selectTypeByTypeId(Long id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteTypeFromids(Integer ids) {
        return typeMapper.deleteByPrimaryKey(Long.valueOf(ids));
    }

    @Override
    public int addType(Type type) {
        int i = typeMapper.insertSelective(type);
        return i;
    }

    @Override
    public int editType(Type type) {
        int i = typeMapper.updateByPrimaryKeySelective(type);
        return i;
    }
}
