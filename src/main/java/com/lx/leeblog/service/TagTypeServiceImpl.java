package com.lx.leeblog.service;

import com.lx.leeblog.dao.TagTypeMapper;
import com.lx.leeblog.pojo.TagType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by @author lixing on 2020/2/3 21:25
 */
@Service
public class TagTypeServiceImpl implements TagTypeService {

    @Autowired
    private TagTypeMapper tagTypeMapper;
    @Override
    public List<TagType> selectTypeAndTag() {
        return tagTypeMapper.selectTypeAndTag();
    }

    @Override
    public String selectTagTypeNamewithTagid(Long id) {
        return tagTypeMapper.selectTagTypeNameWithTagid(id);
    }
}
