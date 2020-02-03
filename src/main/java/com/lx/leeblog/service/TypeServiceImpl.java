package com.lx.leeblog.service;

import com.lx.leeblog.dao.TypeMapper;
import com.lx.leeblog.pojo.Type;
import jdk.nashorn.internal.codegen.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
