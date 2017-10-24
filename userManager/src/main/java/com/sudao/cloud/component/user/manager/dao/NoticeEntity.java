package com.sudao.cloud.component.user.manager.dao;

import com.alibaba.fastjson.annotation.JSONField;
import com.sudao.cloud.component.user.manager.platform.base.BaseEntity;
import com.sudao.cloud.component.user.manager.platform.enums.Deleted;
import com.sudao.cloud.component.user.manager.platform.enums.Status;

import java.io.Serializable;
import java.util.Date;

public class NoticeEntity extends BaseEntity implements Serializable {
    private Long noticeId;

    private String noticeTitle;

    private Long noticeNum;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    private Integer version;

    private Integer displayOrder;

    private String remark;

    private Status status;

    private Long createBy;

    private String createName;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private Long updateBy;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdate;

    private Deleted deleted;

    private String noticeContent;

    private static final long serialVersionUID = 1L;

    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle == null ? null : noticeTitle.trim();
    }

    public Long getNoticeNum() {
        return noticeNum;
    }

    public void setNoticeNum(Long noticeNum) {
        this.noticeNum = noticeNum;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
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

    public Deleted getDeleted() {
        return deleted;
    }

    public void setDeleted(Deleted deleted) {
        this.deleted = deleted;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent == null ? null : noticeContent.trim();
    }
}