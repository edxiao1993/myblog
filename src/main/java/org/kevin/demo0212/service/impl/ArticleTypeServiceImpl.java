package org.kevin.demo0212.service.impl;

import org.kevin.demo0212.mapper.ArticleTypeMapper;
import org.kevin.demo0212.model.ArticleType;
import org.kevin.demo0212.model.ArticleTypeExample;
import org.kevin.demo0212.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 2020-03-14
 */
@Service
public class ArticleTypeServiceImpl implements ArticleTypeService {
    @Autowired
    private ArticleTypeMapper articleTypeMapper;

    @Override
    public List<ArticleType> findList() {
        return articleTypeMapper.selectByExample(null);
    }
}
