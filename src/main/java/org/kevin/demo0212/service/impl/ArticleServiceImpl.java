package org.kevin.demo0212.service.impl;

import org.apache.ibatis.session.RowBounds;
import org.kevin.demo0212.common.CommonUtils;
import org.kevin.demo0212.common.Constant;
import org.kevin.demo0212.mapper.ArticleMapper;
import org.kevin.demo0212.model.Article;
import org.kevin.demo0212.model.ArticleExample;
import org.kevin.demo0212.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Kevin.Z
 * @version 2020-03-14
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Article> findList() {
        return this.findList(Integer.MAX_VALUE);
    }

    @Override
    public List<Article> findList(int limit) {
        return this.findList(0, limit);
    }

    @Override
    public List<Article> findList(int page, int limit) {
        return this.selectByTypes(null, page, limit);
    }

    @Override
    public List<Article> selectByTypes(Integer articleType, Integer page, Integer limit) {
        ArticleExample example = new ArticleExample();
        example.setOrderByClause("create_time DESC");
        if (articleType != null) {
            example.createCriteria().andArticleTypeEqualTo(articleType);
        }
        page = page == null ? 0 : page;
        limit = limit == null ? Constant.DEFAULT_PAGE_SIZE : limit;
        RowBounds rowBounds = new RowBounds(page * limit, limit);

        return articleMapper.selectByExampleWithBLOBsWithRowbounds(example, rowBounds);
    }

    @Override
    public Article selectById(String id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public long count(int articleType) {
        ArticleExample example = new ArticleExample();
        example.createCriteria().andArticleTypeEqualTo(articleType);
        return articleMapper.countByExample(example);
    }

    @Override
    public int insert(Article record) {
        record.setUpdateTime(LocalDateTime.now());
        record.setDeleteFlag(Boolean.FALSE);
        record.setForeword(CommonUtils.replaceLineCharacter(record.getForeword()));
//        record.setContent(CommonUtils.replaceLineCharacter(record.getContent()));

        return articleMapper.insert(record);
    }
}
