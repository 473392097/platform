package com.sudao.cloud.module.idea.dao.dto;

import com.sudao.spec.dto.BaseSpecFields;
import java.io.Serializable;

public class UserIdeaStatisticsDTO extends BaseSpecFields implements Serializable {
    private Long id;

    private Long userId;

    private Integer publishedIdeaNumber;

    private Integer participantIdeaNumber;

    private Integer reportedIdeaNumber;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getPublishedIdeaNumber() {
        return publishedIdeaNumber;
    }

    public void setPublishedIdeaNumber(Integer publishedIdeaNumber) {
        this.publishedIdeaNumber = publishedIdeaNumber;
    }

    public Integer getParticipantIdeaNumber() {
        return participantIdeaNumber;
    }

    public void setParticipantIdeaNumber(Integer participantIdeaNumber) {
        this.participantIdeaNumber = participantIdeaNumber;
    }

    public Integer getReportedIdeaNumber() {
        return reportedIdeaNumber;
    }

    public void setReportedIdeaNumber(Integer reportedIdeaNumber) {
        this.reportedIdeaNumber = reportedIdeaNumber;
    }
}