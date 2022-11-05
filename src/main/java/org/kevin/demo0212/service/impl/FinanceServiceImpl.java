package org.kevin.demo0212.service.impl;

import org.apache.ibatis.session.RowBounds;
import org.kevin.demo0212.common.CommonUtils;
import org.kevin.demo0212.common.Constant;
import org.kevin.demo0212.mapper.FinanceMapper;
import org.kevin.demo0212.model.Finance;
import org.kevin.demo0212.model.FinanceExample;
import org.kevin.demo0212.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Kevin.Z
 * @version 2020-03-18
 */
@Service
public class FinanceServiceImpl implements FinanceService {
    @Autowired
    private FinanceMapper financeMapper;

    @Override
    public List<Finance> findList() {
        return this.findList(null);
    }

    @Override
    public List<Finance> findList(Integer limit) {
        return this.findList(null, limit);
    }

    @Override
    public List<Finance> findList(Integer page, Integer limit) {
        return this.findList(null, page, limit);
    }

    @Override
    public List<Finance> findList(FinanceExample example, Integer page, Integer limit) {
        example = example==null? new FinanceExample():example;
        example.setOrderByClause("create_time DESC");

        page = page==null? 0:page;
        limit = limit==null? Constant.DEFAULT_PAGE_SIZE:limit;
        RowBounds rw = new RowBounds(page*limit, limit);
        return financeMapper.selectByExampleWithRowbounds(example, rw);
    }

    @Override
    public int insert(Finance record) {
        return financeMapper.insert(record);
    }

    @Override
    public double sumByDate(String fromDate, String endDate) {
        LocalDateTime fDate = CommonUtils.parseStr2LocalDateTime(fromDate, true);
        LocalDateTime eDate = CommonUtils.parseStr2LocalDateTime(endDate, false);
        return financeMapper.sumByDate(fDate, eDate);
    }

    @Override
    public long count(FinanceExample example) {
        return financeMapper.countByExample(example);
    }
}
