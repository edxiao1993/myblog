package org.kevin.demo0212.model.dto;

import lombok.Data;
import org.kevin.demo0212.common.CommonUtils;
import org.kevin.demo0212.common.Constant;
import org.kevin.demo0212.model.Moment;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Kevin.Z
 * @version 2020-03-15
 */
@Data
public class PageModel {
    private boolean hasPrevious;
    private boolean hasNext;
    private int currentPage;
    private int pageSize;
    private long count;
    private long totalPage;
    private int previousPage;
    private int nextPage;

    private String beginTime;
    private String endTime;

    public PageModel() {

    }

    public PageModel(Integer currentPage, Integer pageSize, long count) {
        this.currentPage = currentPage == null ? 0 : currentPage;
        this.pageSize = pageSize == null ? Constant.DEFAULT_PAGE_SIZE : pageSize;

        totalPage = count / this.pageSize;

        if (this.currentPage == 0 || totalPage == 0) {
            this.hasPrevious = false;
        } else {
            this.hasPrevious = true;
            this.previousPage = currentPage - 1;
        }

        if (this.currentPage == totalPage) {
            this.hasNext = false;
        } else {
            this.hasNext = true;
            this.nextPage = this.currentPage + 1;
        }
    }

    public PageModel(List<Moment> momentList) {
        if (momentList.size() > 0) {
            LocalDateTime firstTime = momentList.get(0).getCreateTime();
            LocalDateTime lastTime = momentList.get(momentList.size() - 1).getCreateTime();
            LocalDateTime tempTime;
            if(firstTime.compareTo(lastTime) < 0){
                tempTime = firstTime;
                firstTime = lastTime;
                lastTime = tempTime;
            }

            beginTime = CommonUtils.LocalDateTime2String(firstTime);
            endTime = CommonUtils.LocalDateTime2String(lastTime);
        }
    }

    public void checkTime(long countPrevious, long countNext) {
        this.hasPrevious = countPrevious > 0;
        this.hasNext = countNext > 0;
    }
}
