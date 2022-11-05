package org.kevin.demo0212.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.kevin.demo0212.model.Post;
import org.kevin.demo0212.model.PostExample;

public interface PostMapper {
    long countByExample(PostExample example);

    int deleteByExample(PostExample example);

    int deleteByPrimaryKey(String id);

    int insert(Post record);

    int insertSelective(Post record);

    List<Post> selectByExampleWithRowbounds(PostExample example, RowBounds rowBounds);

    List<Post> selectByExample(PostExample example);

    Post selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Post record, @Param("example") PostExample example);

    int updateByExample(@Param("record") Post record, @Param("example") PostExample example);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);

    Post getPostWithUser(@Param("postId") String postId);
}