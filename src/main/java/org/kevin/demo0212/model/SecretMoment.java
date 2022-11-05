package org.kevin.demo0212.model;

import java.time.LocalDateTime;

public class SecretMoment extends BaseModel {

    private String moment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getMoment() {
        return moment;
    }

    public void setMoment(String moment) {
        this.moment = moment == null ? null : moment.trim();
    }
}