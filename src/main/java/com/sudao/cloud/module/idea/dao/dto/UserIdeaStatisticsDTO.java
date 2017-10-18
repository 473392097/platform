package com.sudao.cloud.module.idea.dao.dto;

import com.sudao.cloud.module.base.config.enums.Status;
import java.io.Serializable;
import java.util.Date;

public class UserIdeaStatisticsDTO implements Serializable {
    private Long id;

    private Long userId;

    private Integer publishedIdeaNumber;

    private Integer participantIdeaNumber;

    private Integer reportedIdeaNumber;

    private Status status;

    private Long createdById;

    private Long createdTime;

    private Long updatedById;

    private Long updatedTime;

    private Date lastupdate;

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

    public Date getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Date lastupdate) {
        this.lastupdate = lastupdate;
    }
}