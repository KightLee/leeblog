package com.lx.leeblog.service;

import com.lx.leeblog.pojo.Tag;

import java.util.List;

/**
 * create by @author lixing on 2020/2/3 20:48
 */
public interface TagService {
    public List<Tag> selectAllTag();
    public int updatetagByClass(Tag tag);
    public int addTag(Tag tag);
    public int deleteTag(Integer[] ids);
    public int deleteTagOne(Integer id);
}
