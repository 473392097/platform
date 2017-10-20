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

    private Integer displayOrder;

    private Integer version;

    private Status status;

    private Long createUserId;

    private String createUserName;

    private Date createTime;

    private Long updateUserId;

    private String updateUserName;

    private Date updateTime;

    private Date lastUpdate;

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

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}