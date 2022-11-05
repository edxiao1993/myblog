package org.kevin.demo0212.service;

import org.kevin.demo0212.model.SecretMoment;
import org.kevin.demo0212.model.SecretMomentExample;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 2020-03-12
 */
public interface SecretMomentService {

    int insert(SecretMoment record);

    int insertNewRecord(String content);

    List<SecretMoment> findList(SecretMomentExample example);

    List<SecretMoment> findList();

    /**
     * myBatis 生成的 Example 里没有 moment 相关的检索。
     * 需要的话可以在 criteria 里自己添加一个 LIKE 的方法。
     * @param moment
     * @return
     */
    List<SecretMoment> findList(String moment);

    List<SecretMoment> findList(Integer limit);

    List<SecretMoment> findList(String moment, Integer page, Integer limit);

    long count(String moment);
}
