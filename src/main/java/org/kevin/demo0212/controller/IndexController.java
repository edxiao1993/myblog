package org.kevin.demo0212.controller;

import org.kevin.demo0212.common.CommonUtils;
import org.kevin.demo0212.common.Constant;
import org.kevin.demo0212.config.annotations.AopLog;
import org.kevin.demo0212.model.*;
import org.kevin.demo0212.model.dto.PageModel;
import org.kevin.demo0212.service.ArticleService;
import org.kevin.demo0212.service.ArticleTypeService;
import org.kevin.demo0212.service.SecretMomentService;
import org.kevin.demo0212.service.impl.MomentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;

/**
 * @author Kevin.Z
 * @version 2020-03-12
 */
@Controller
public class IndexController extends BaseController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private SecretMomentService secretMomentService;
    @Autowired
    private ArticleTypeService articleTypeService;
    @Autowired
    private MomentServiceImpl momentService;

    @RequestMapping({"/", "", "/index"})
    public String index(ModelMap modelMap) {
        List<Article> articles = articleService.findList(8);
        modelMap.addAttribute("articles", articles);

        return "index";
    }

    @RequestMapping("/signin")
    public String signin(ModelMap modelMap) {
        return "signin";
    }

    @GetMapping("/newArticle")
    public String newArticle(ModelMap modelMap) {
        List<ArticleType> articleTypes = articleTypeService.findList();
        modelMap.addAttribute("articleTypes", articleTypes);

        return "newArticle";
    }

    @AopLog("Test Annotation AOP of Spring")
    @GetMapping("/article")
    public String article(@RequestParam("id") String id, ModelMap modelMap) {
        List<ArticleType> articleTypes = articleTypeService.findList();
        modelMap.addAttribute("articleTypes", articleTypes);

        Article article = articleService.selectById(id);
        modelMap.addAttribute("article", article);
        return "blog";
    }

    @GetMapping("/moment")
    public String moment(@RequestParam(value = "previousTime", required = false) String pt,
                         @RequestParam(value = "nextTime", required = false) String nt,
                         @RequestParam(value = "Statement", required = false) String statement,
                         ModelMap modelMap) {
        LocalDateTime previousTime = CommonUtils.parse2LocalDateTimeWithT(pt);
        LocalDateTime nextTime = CommonUtils.parse2LocalDateTimeWithT(nt);
        List<Moment> moments = momentService.findList(statement, previousTime, nextTime);
        PageModel pageModel = new PageModel(moments);

        previousTime = CommonUtils.parse2LocalDateTimeWithT(pageModel.getBeginTime());
        nextTime = CommonUtils.parse2LocalDateTimeWithT(pageModel.getEndTime());
        long previousCount = momentService.countPrevious(previousTime);
        long nextCount = momentService.countNext(nextTime);
        long tempCount = momentService.countNext(previousTime);
        List<Moment> lists = momentService.countNext1(CommonUtils.LocalDateTime2Date(nextTime));
        pageModel.checkTime(previousCount, nextCount);


        modelMap.addAttribute("moments", moments);
        modelMap.addAttribute("pageModel", pageModel);
        return "moment";
    }

    @GetMapping("/secretMoment")
    public String secretMoment(@RequestParam(value = "pageNum", required = false) Integer pageNum,
                               @RequestParam(value = "pageSize", required = false) Integer pageSize,
                               @RequestParam(value = "moment", required = false) String moment,
                               ModelMap modelMap) {
        List<SecretMoment> secretMoments = secretMomentService.findList(moment, pageNum, pageSize);
        long count = secretMomentService.count(moment);
        PageModel pageModel = new PageModel(pageNum, pageSize, count);

        modelMap.addAttribute("pageModel", pageModel);
        modelMap.addAttribute("secretMoments", secretMoments);
        return "secretMoment";
    }

    @GetMapping("/articles")
    public String articles(@RequestParam("articleType") Integer type,
                           @RequestParam(value = "pageNum", required = false) Integer pageNum,
                           @RequestParam(value = "pageSize", required = false) Integer pageSize,
                           ModelMap modelMap) {
        List<Article> articles = articleService.selectByTypes(type, pageNum, pageSize);
        long count = articleService.count(type);
        PageModel pageModel = new PageModel(pageNum, pageSize, count);

        modelMap.addAttribute("pageModel", pageModel);
        modelMap.addAttribute("articles", articles);
        modelMap.addAttribute("articleType", type);

        return "blogWithType";
    }

    @GetMapping("/spending")
    public String spending() {
        return "spending";
    }
}
