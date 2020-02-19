package com.lx.leeblog.service;

import com.lx.leeblog.pojo.TagType;

import java.util.List;

/**
 * create by @author lixing on 2020/2/3 21:24
 */
public interface TagTypeService {
    public List<TagType> selectTypeAndTag();

    public String selectTagTypeNamewithTagid(Long id);
}
