package org.kevin.demo0212.service;

import org.kevin.demo0212.model.Moment;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author Kevin.Z
 * @version 2020/5/3
 */
public interface MomentService {
    List<Moment> findList(String statement, LocalDateTime previousTime, LocalDateTime nextTime);

    long count(String statement);

    long countPrevious(LocalDateTime beginTime);

    long countNext(LocalDateTime endTime);
    List<Moment> countNext1(Date endTime);
}
