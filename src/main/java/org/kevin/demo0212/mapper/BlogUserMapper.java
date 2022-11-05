package org.kevin.demo0212.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.kevin.demo0212.model.BlogUser;
import org.kevin.demo0212.model.BlogUserExample;

public interface BlogUserMapper {
    long countByExample(BlogUserExample example);

    int deleteByExample(BlogUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(BlogUser record);

    int insertSelective(BlogUser record);

    List<BlogUser> selectByExampleWithRowbounds(BlogUserExample example, RowBounds rowBounds);

    List<BlogUser> selectByExample(BlogUserExample example);

    BlogUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BlogUser record, @Param("example") BlogUserExample example);

    int updateByExample(@Param("record") BlogUser record, @Param("example") BlogUserExample example);

    int updateByPrimaryKeySelective(BlogUser record);

    int updateByPrimaryKey(BlogUser record);
}