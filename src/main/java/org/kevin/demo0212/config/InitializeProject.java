package org.kevin.demo0212.config;

import org.kevin.demo0212.common.Constant;
import org.kevin.demo0212.model.AlertWall;
import org.kevin.demo0212.model.ArticleType;
import org.kevin.demo0212.repository.MyRedisRepository;
import org.kevin.demo0212.service.AlertWallService;
import org.kevin.demo0212.service.ArticleTypeService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.util.List;

/**
 * @author Kevin.Z
 * @version 2020-03-14
 */
@Component
public class InitializeProject implements InitializingBean, ApplicationContextAware {

    @Autowired
    private ArticleTypeService articleTypeService;
    @Autowired
    private AlertWallService alertWallService;

    @Autowired
    private ServletContext sc;

    @Autowired
    private MyRedisRepository redisRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        List<ArticleType> articleTypes = articleTypeService.findList();
        sc.setAttribute("articleTypes", articleTypes);

        AlertWall blogWall = alertWallService.selectByType(Constant.ALERT_WALL_TYPE_BLOG);
        AlertWall secretMomentWall = alertWallService.selectByType(Constant.ALERT_WALL_TYPE_SECRET_MOMENT);
        AlertWall financeWall = alertWallService.selectByType(Constant.ALERT_WALL_TYPE_FINANCE);

        sc.setAttribute("blogWall", blogWall);
        sc.setAttribute("secretMomentWall", secretMomentWall);
        sc.setAttribute("financeWall", financeWall);

        redisRepository.set("name", "KevinZng");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
