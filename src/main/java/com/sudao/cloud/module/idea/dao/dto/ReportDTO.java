package com.sudao.cloud.module.idea.dao.dto;

import com.sudao.cloud.module.base.config.enums.Status;
import com.sudao.cloud.module.idea.enums.ProcessStatus;
import java.io.Serializable;
import java.util.Date;

public class ReportDTO implements Serializable {
    private Long reportId;

    private Long relationId;

    private Boolean relationType;

    private Long parentId;

    private String title;

    private String reason;

    private String reportVersion;

    private String reportUserPhone;

    private String beReportedName;

    private ProcessStatus processStatus;

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

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public Boolean getRelationType() {
        return relationType;
    }

    public void setRelationType(Boolean relationType) {
        this.relationType = relationType;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getReportVersion() {
        return reportVersion;
    }

    public void setReportVersion(String reportVersion) {
        this.reportVersion = reportVersion == null ? null : reportVersion.trim();
    }

    public String getReportUserPhone() {
        return reportUserPhone;
    }

    public void setReportUserPhone(String reportUserPhone) {
        this.reportUserPhone = reportUserPhone == null ? null : reportUserPhone.trim();
    }

    public String getBeReportedName() {
        return beReportedName;
    }

    public void setBeReportedName(String beReportedName) {
        this.beReportedName = beReportedName == null ? null : beReportedName.trim();
    }

    public ProcessStatus getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(ProcessStatus processStatus) {
        this.processStatus = processStatus;
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