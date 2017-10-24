package com.sudao.cloud.module.praise.dao.dto;

import com.sudao.cloud.module.praise.enums.ReadStatus;
import com.sudao.spec.dto.BaseSpecFields;
import java.io.Serializable;

public class FeedbackDTO extends BaseSpecFields implements Serializable {
    private Long id;

    private String feedbackUsername;

    private String feedbackCellphone;

    private ReadStatus readStatus;

    private String content;

    private String feedbackReply;

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
}