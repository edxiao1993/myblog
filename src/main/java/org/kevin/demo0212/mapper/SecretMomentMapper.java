package org.kevin.demo0212.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.kevin.demo0212.model.SecretMoment;
import org.kevin.demo0212.model.SecretMomentExample;

public interface SecretMomentMapper {
    long countByExample(SecretMomentExample example);

    int deleteByExample(SecretMomentExample example);

    int deleteByPrimaryKey(String id);

    int insert(SecretMoment record);

    int insertSelective(SecretMoment record);

    List<SecretMoment> selectByExampleWithBLOBsWithRowbounds(SecretMomentExample example, RowBounds rowBounds);

    List<SecretMoment> selectByExampleWithBLOBs(SecretMomentExample example);

    List<SecretMoment> selectByExampleWithRowbounds(SecretMomentExample example, RowBounds rowBounds);

    List<SecretMoment> selectByExample(SecretMomentExample example);

    SecretMoment selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SecretMoment record, @Param("example") SecretMomentExample example);

    int updateByExampleWithBLOBs(@Param("record") SecretMoment record, @Param("example") SecretMomentExample example);

    int updateByExample(@Param("record") SecretMoment record, @Param("example") SecretMomentExample example);

    int updateByPrimaryKeySelective(SecretMoment record);

    int updateByPrimaryKeyWithBLOBs(SecretMoment record);

    int updateByPrimaryKey(SecretMoment record);
}