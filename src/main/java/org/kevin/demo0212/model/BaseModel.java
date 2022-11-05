package org.kevin.demo0212.model;

import lombok.Data;
import org.kevin.demo0212.common.CommonUtils;

import java.time.LocalDateTime;

/**
 * @author Kevin.Z
 * @version 2020-03-12
 */
public class BaseModel {
    protected String id;
    protected LocalDateTime createTime;

    public BaseModel() {
        this.id = CommonUtils.generateUUID();
        this.createTime = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
