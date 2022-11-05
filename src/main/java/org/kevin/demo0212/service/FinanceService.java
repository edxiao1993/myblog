package org.kevin.demo0212.service;

import org.kevin.demo0212.model.Finance;
import org.kevin.demo0212.model.FinanceExample;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 2020-03-18
 */
public interface FinanceService {
    List<Finance> findList();

    List<Finance> findList(Integer limit);

    List<Finance> findList(Integer page, Integer limit);

    List<Finance> findList(FinanceExample example, Integer page, Integer limit);

    int insert(Finance record);

    double sumByDate(String fromDate, String endDate);

    long count(FinanceExample example);
}
