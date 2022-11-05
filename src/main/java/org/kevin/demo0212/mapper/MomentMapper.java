package org.kevin.demo0212.mapper;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.kevin.demo0212.model.Moment;
import org.kevin.demo0212.model.MomentExample;

public interface MomentMapper {
    long countByExample(MomentExample example);

    int deleteByExample(MomentExample example);

    int deleteByPrimaryKey(String id);

    int insert(Moment record);

    int insertSelective(Moment record);

    List<Moment> selectByExampleWithRowbounds(MomentExample example, RowBounds rowBounds);

    List<Moment> selectByExample(MomentExample example);

    Moment selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Moment record, @Param("example") MomentExample example);

    int updateByExample(@Param("record") Moment record, @Param("example") MomentExample example);

    int updateByPrimaryKeySelective(Moment record);

    int updateByPrimaryKey(Moment record);

    List<Moment> findList(@Param("statement") String statement,
                          @Param("beginTime") LocalDateTime beginTime,
                          @Param("endTime") LocalDateTime endTime,
                          @Param("limit") int limit);

    long count(@Param("statement") String statement);

    long countPrevious(@Param("beginTime") LocalDateTime beginTime);
    long countNext(@Param("endTime") LocalDateTime endTime);
    List<Moment> countNext1(@Param("endTime") Date endTime);
}