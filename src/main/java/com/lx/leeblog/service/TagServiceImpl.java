package com.lx.leeblog.service;

import com.lx.leeblog.dao.TagMapper;
import com.lx.leeblog.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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

    @Override
    public int updatetagByClass(Tag tag) {
        return tagMapper.updateByPrimaryKeySelective(tag);
    }

    @Override
    public int addTag(Tag tag) {
        return tagMapper.insertSelective(tag);
    }

    @Transactional
    @Override
    public int deleteTag(Integer[] ids) {
        for (int i = 0; i < ids.length; i++) {
            int i1 = tagMapper.deleteByPrimaryKey(ids[i].longValue());
            if (i1 == 0) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
        return 1;
    }

    @Override
    public int deleteTagOne(Integer id) {
        return tagMapper.deleteByPrimaryKey(Long.valueOf(id));
    }
}
