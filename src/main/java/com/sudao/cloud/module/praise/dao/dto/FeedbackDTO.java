package com.sudao.cloud.module.praise.dao.dto;

import com.sudao.cloud.module.base.config.enums.Status;
import com.sudao.cloud.module.praise.enums.ReadStatus;
import java.io.Serializable;
import java.util.Date;

public class FeedbackDTO implements Serializable {
    private Long id;

    private String feedbackUsername;

    private String feedbackCellphone;

    private ReadStatus readStatus;

    private String content;

    private String feedbackReply;

    private Status status;

    private Long createdById;

    private Long createdTime;

    private Long updatedById;

    private Long updatedTime;

    private Date lastUpdate;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFeedbackUsername() {
        return feedbackUsername;
    }

    public void setFeedbackUsername(String feedbackUsername) {
        this.feedbackUsername = feedbackUsername == null ? null : feedbackUsername.trim();
    }

    public String getFeedbackCellphone() {
        return feedbackCellphone;
    }

    public void setFeedbackCellphone(String feedbackCellphone) {
        this.feedbackCellphone = feedbackCellphone == null ? null : feedbackCellphone.trim();
    }

    public ReadStatus getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(ReadStatus readStatus) {
        this.readStatus = readStatus;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getFeedbackReply() {
        return feedbackReply;
    }

    public void setFeedbackReply(String feedbackReply) {
        this.feedbackReply = feedbackReply == null ? null : feedbackReply.trim();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Long createdById) {
        this.createdById = createdById;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    public Long getUpdatedById() {
        return updatedById;
    }

    public void setUpdatedById(Long updatedById) {
        this.updatedById = updatedById;
    }

    public Long getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Long updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}