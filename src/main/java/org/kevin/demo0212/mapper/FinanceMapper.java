package org.kevin.demo0212.mapper;

import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.kevin.demo0212.model.Finance;
import org.kevin.demo0212.model.FinanceExample;

public interface FinanceMapper {
    long countByExample(FinanceExample example);

    int deleteByExample(FinanceExample example);

    int deleteByPrimaryKey(String id);

    int insert(Finance record);

    int insertSelective(Finance record);

    List<Finance> selectByExampleWithRowbounds(FinanceExample example, RowBounds rowBounds);

    List<Finance> selectByExample(FinanceExample example);

    Finance selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Finance record, @Param("example") FinanceExample example);

    int updateByExample(@Param("record") Finance record, @Param("example") FinanceExample example);

    int updateByPrimaryKeySelective(Finance record);

    int updateByPrimaryKey(Finance record);

    double sumByDate(@Param("fDate")LocalDateTime fDate, @Param("eDate")LocalDateTime eDate);
}