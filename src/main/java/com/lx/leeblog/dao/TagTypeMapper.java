package com.lx.leeblog.dao;

import com.lx.leeblog.pojo.TagType;
import com.lx.leeblog.pojo.TagTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TagTypeMapper {
    int countByExample(TagTypeExample example);

    int deleteByExample(TagTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TagType record);

    int insertSelective(TagType record);

    List<TagType> selectByExample(TagTypeExample example);

    List<TagType> selectTypeAndTag();

    TagType selectByPrimaryKey(Long id);

    String selectTagTypeNameWithTagid(Long id);

    int updateByExampleSelective(@Param("record") TagType record, @Param("example") TagTypeExample example);

    int updateByExample(@Param("record") TagType record, @Param("example") TagTypeExample example);

    int updateByPrimaryKeySelective(TagType record);

    int updateByPrimaryKey(TagType record);
}
