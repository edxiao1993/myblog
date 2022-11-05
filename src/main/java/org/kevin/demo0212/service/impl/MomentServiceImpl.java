package org.kevin.demo0212.service.impl;

import org.kevin.demo0212.common.Constant;
import org.kevin.demo0212.mapper.MomentMapper;
import org.kevin.demo0212.model.Moment;
import org.kevin.demo0212.service.BaseService;
import org.kevin.demo0212.service.MomentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Kevin.Z
 * @version 2020/5/3
 */
@Service
public class MomentServiceImpl implements BaseService<Moment>, MomentService {
    @Autowired
    private MomentMapper momentMapper;

    @Override
    public int insert(Moment record) {
        return momentMapper.insert(record);
    }

    @Override
    public Moment getById(String id) {
        return null;
    }

    @Override
    public List<Moment> findList() {
        return null;
    }

    @Override
    public List<Moment> findList(String statement, LocalDateTime previousTime, LocalDateTime nextTime) {
        if (previousTime == null && nextTime == null) {
            nextTime = LocalDateTime.now();
        }

        List<Moment> moments = momentMapper.findList(statement, previousTime, nextTime, Constant.BIG_PAGE_SIZE);
        if (moments != null) {
            if (moments.size() >= 10) {
                moments = moments.subList(0, 10);
            }
            return moments;
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public long count(String statement) {
        return momentMapper.count(statement);
    }

    @Override
    public long countPrevious(LocalDateTime beginTime) {
        if (beginTime == null) {
            return 0;
        }
        return momentMapper.countPrevious(beginTime.plusDays(10));
    }

    @Override
    public long countNext(LocalDateTime endTime) {
        endTime = endTime == null ? LocalDateTime.now() : endTime;
        return momentMapper.countNext(endTime);
    }

    @Override
    public List<Moment> countNext1(Date endTime) {
        return momentMapper.countNext1(endTime);
    }
}
