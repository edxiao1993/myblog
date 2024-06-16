package org.kevin.demo0212.mapper.june8_2024;

import org.apache.ibatis.annotations.Param;
import org.kevin.demo0212.model.june8_2024.JuneAttr;
import org.kevin.demo0212.model.june8_2024.JuneResource;
import org.kevin.demo0212.model.june8_2024.JuneSubscriber;

import java.util.List;

/**
 * @author Kevin.Zng
 * @date 2024/6/8 19:05
 */
public interface IndexCheckerMapper {
    int insertBatchSubscriber(@Param("subscriberList") List<JuneSubscriber> subscriberList);
    int insertBatchResource(@Param("resourceList") List<JuneResource> resourceList);
    int insertBatchAttr(@Param("attrList") List<JuneAttr> attrList);

    void checkDefaultBehaviour();

    void checkInsertIgnoreInto();

    void checkDuplicateKey();

    void checkReplaceInto();
}
