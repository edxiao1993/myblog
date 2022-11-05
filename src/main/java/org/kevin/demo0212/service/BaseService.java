package org.kevin.demo0212.service;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 2020/5/3
 */
public interface BaseService<T> {
    int insert(T record);

    T getById(String id);

    List<T> findList();

}
