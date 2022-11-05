package org.kevin.demo0212.service;

import org.kevin.demo0212.model.Article;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 2020-03-14
 */
public interface ArticleService {

    List<Article> findList();

    List<Article> findList(int limit);

    List<Article> findList(int page, int limit);

    List<Article> selectByTypes(Integer articleType, Integer page, Integer limit);

    Article selectById(String id);

    long count(int articleType);

    int insert(Article record);
}
