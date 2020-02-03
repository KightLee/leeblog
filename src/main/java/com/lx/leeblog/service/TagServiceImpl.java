package com.lx.leeblog.service;

import com.lx.leeblog.dao.TagMapper;
import com.lx.leeblog.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by @author lixing on 2020/2/3 20:48
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;
    @Override
    public List<Tag> selectAllTag() {
        return tagMapper.selectAllTags();
    }
}
