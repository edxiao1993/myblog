package org.kevin.demo0212.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.kevin.demo0212.model.Cuser;
import org.kevin.demo0212.model.CuserExample;

public interface CuserMapper {
    long countByExample(CuserExample example);

    int deleteByExample(CuserExample example);

    int deleteByPrimaryKey(String id);

    int insert(Cuser record);

    int insertSelective(Cuser record);

    List<Cuser> selectByExampleWithRowbounds(CuserExample example, RowBounds rowBounds);

    List<Cuser> selectByExample(CuserExample example);

    Cuser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Cuser record, @Param("example") CuserExample example);

    int updateByExample(@Param("record") Cuser record, @Param("example") CuserExample example);

    int updateByPrimaryKeySelective(Cuser record);

    int updateByPrimaryKey(Cuser record);

    Cuser getUserPost(@Param("cuserId") String cuserId);
}