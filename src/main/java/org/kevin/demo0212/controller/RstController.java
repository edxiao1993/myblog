package org.kevin.demo0212.controller;

import com.alibaba.fastjson.JSON;
import org.apache.tomcat.jni.Local;
import org.kevin.demo0212.common.CommonUtils;
import org.kevin.demo0212.common.MyException;
import org.kevin.demo0212.model.*;
import org.kevin.demo0212.model.dto.DataTables;
import org.kevin.demo0212.service.ArticleService;
import org.kevin.demo0212.service.FinanceService;
import org.kevin.demo0212.service.PictureService;
import org.kevin.demo0212.service.SecretMomentService;
import org.kevin.demo0212.service.impl.MomentServiceImpl;
import org.kevin.demo0212.service.impl.PictureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Kevin.Z
 * @version 2020-03-15
 */
@RestController
public class RstController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private SecretMomentService secretMomentService;
    @Autowired
    private FinanceService financeService;
    @Autowired
    private PictureServiceImpl pictureService;
    @Autowired
    private MomentServiceImpl momentService;

    @Value("${myblog.config.imgPath}")
    private String UPLOAD_IMG_PATH;

    @PostMapping("/saveArticle")
    public int saveArticle(Article record) {
        return articleService.insert(record);
    }

    @PostMapping("/saveSecretMoment")
    public int saveSecretMoment(@RequestParam(value = "content") String content) {
        return secretMomentService.insertNewRecord(content);
    }

    @PostMapping("/saveSpending")
    public int saveSpending(Finance record) {
        return financeService.insert(record);
    }

    @PostMapping("/saveMoment")
    public int saveMoment( @RequestParam("statement") String statement,
                           @RequestParam("file[]") MultipartFile[] picFile) {
        if(picFile.length > 0) {
            Moment m = new Moment();
            m.setStatement(statement);
            if(momentService.insert(m) == 0){
                throw new MyException("插入 Moment 失败");
            }

            List<Picture> list = new ArrayList<>();
            for (int i = 0; i < picFile.length; i++) {
                MultipartFile mf = picFile[i];
                String dest = UPLOAD_IMG_PATH + "0_"
                        + CommonUtils.convertSpecialCharacter(LocalDateTime.now().toString())
                        + "_" + mf.getOriginalFilename();
                dest = CommonUtils.replaceBlank(dest);

                try {
                    mf.transferTo(new File(dest));
                    Picture picture = new Picture();
                    picture.setPicType(0);
                    picture.setSrc(dest);
                    picture.setMomentId(m.getId());

                    list.add(picture);
                } catch (Exception e) {
                    throw new MyException("转存图片失败～");
                }
            }
            return pictureService.insertBatch(list);
        }
        return 1;
    }

    @PostMapping("/spending/list")
    public String spendingList(@RequestParam(value = "start") Integer start,
                               @RequestParam(value = "length") Integer length,
                               @RequestParam(value = "draw") Integer draw) {
        List<Finance> finances = financeService.findList(start / length, length);
        long count = financeService.count(null);

        DataTables<Finance> dt = new DataTables<>((int) count, draw);
        dt.setData(finances);

        return JSON.toJSONString(dt);
    }

    @GetMapping("/getPicture")
    public void getPicTemp(@RequestParam("src") String imgSrc,HttpServletResponse response){
        try(InputStream is = new FileInputStream(imgSrc);
            OutputStream toClient = response.getOutputStream()){
            int size = is.available();
            byte[] data = new byte[size];
            is.read(data);
            response.setContentType("image/jpeg");
            toClient.write(data);
        } catch (Exception e){
            System.err.println("can't find a picture." + imgSrc);
            e.printStackTrace();
        }
    }

    @GetMapping("/testImgPath")
    public String testImgPath(){
        String s = UPLOAD_IMG_PATH;
        System.out.println(s);
        return "s";
    }
}
