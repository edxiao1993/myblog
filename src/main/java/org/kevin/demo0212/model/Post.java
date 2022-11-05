package org.kevin.demo0212.model;

import org.kevin.demo0212.model.mongo.Customer;

import java.time.LocalDateTime;

public class Post extends BaseModel {
    private String cuserId;

    private String title;

    private String content;

    private Cuser cuser;

    public Cuser getCuser() {
        return cuser;
    }

    public void setCuser(Cuser cuser) {
        this.cuser = cuser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCuserId() {
        return cuserId;
    }

    public void setCuserId(String cuserId) {
        this.cuserId = cuserId == null ? null : cuserId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}