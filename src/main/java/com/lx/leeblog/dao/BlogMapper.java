package com.lx.leeblog.dao;

import com.lx.leeblog.pojo.Blog;
import com.lx.leeblog.pojo.BlogExample;
import java.util.List;

import com.lx.leeblog.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface BlogMapper {
    int countByExample(BlogExample example);

    int deleteByExample(BlogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Blog record);

    int insertSelective(Blog record);

    List<Blog> selectByExampleWithBLOBs(BlogExample example);

    List<Blog> selectByExample(BlogExample example);

    List<Blog> selectAllBlog();

    List<User> selectAllBlogWithUser();

    List<User> selectAllBlogWithUserAndTagName(String tag);

    Blog selectByPrimaryKey(Long id);

    Long selectViewWithId(Long id);

    int updateByPrimaryKeyView(Long id);

    int updateByExampleSelective(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByExampleWithBLOBs(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByExample(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKeyWithBLOBs(Blog record);

    int updateByPrimaryKey(Blog record);
}
