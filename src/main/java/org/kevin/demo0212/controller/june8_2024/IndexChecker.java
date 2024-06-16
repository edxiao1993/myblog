package org.kevin.demo0212.controller.june8_2024;

import org.kevin.demo0212.mapper.june8_2024.IndexCheckerMapper;
import org.kevin.demo0212.model.june8_2024.JuneAttr;
import org.kevin.demo0212.model.june8_2024.JuneResource;
import org.kevin.demo0212.model.june8_2024.JuneSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Kevin.Zng
 * @date 2024/6/8 19:02
 */
@RestController
@RequestMapping("/indexer")
public class IndexChecker {

    private static final String STARTER_OF_MSISDN = "20240608_1_";
    private static final String STARTER_OF_ICCID = "20240608_2_";
    private static final String STARTER_OF_RESIS = "20240608_3_";

    private static final String ATTRID = "19930322";

    private static final Random ATTRVALUE_CREATOR = new Random();

    @Autowired
    private IndexCheckerMapper indexCheckerMapper;

    @GetMapping("/prepare")
    public String checkIndexPrepare() {
        List<JuneSubscriber> subscriberList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            JuneSubscriber temp = new JuneSubscriber(
                    STARTER_OF_MSISDN + i, "custId" + i, "whatever" + i,
                    STARTER_OF_ICCID + i);
            subscriberList.add(temp);
        }

        List<JuneResource> sourceList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            JuneResource temp = new JuneResource(
                    STARTER_OF_RESIS + i, subscriberList.get(i).getIccid());
            sourceList.add(temp);
        }

        List<JuneAttr> attrList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            JuneAttr temp = new JuneAttr(
                    sourceList.get(i).getResid(), ATTRID, String.valueOf(ATTRVALUE_CREATOR.nextLong()
            ));
            attrList.add(temp);
        }

        indexCheckerMapper.insertBatchSubscriber(subscriberList);
        indexCheckerMapper.insertBatchResource(sourceList);
        indexCheckerMapper.insertBatchAttr(attrList);

        return "done";
    }

    /**
     * checked ~~~
     * @return
     */
    @GetMapping("/default")
    public String checkInsertDefault() {
        indexCheckerMapper.checkDefaultBehaviour();
        return "done";
    }

    /**
     * checked ~~~
     * @return
     */
    @GetMapping("/ignore")
    public String checkInsertIgnore() {
        indexCheckerMapper.checkInsertIgnoreInto();
        return "done";
    }

    @GetMapping("/duplicate")
    public String checkInsertDuplicate() {
        indexCheckerMapper.checkDuplicateKey();
        return "done";
    }

    @GetMapping("/replace")
    public String checkInsertReplace() {
        indexCheckerMapper.checkReplaceInto();
        return "done";
    }
}
