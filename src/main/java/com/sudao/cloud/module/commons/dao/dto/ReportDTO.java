package com.sudao.cloud.module.commons.dao.dto;

import com.sudao.cloud.module.idea.enums.ProcessStatus;
import com.sudao.spec.dto.BaseSpecFields;
import java.io.Serializable;

public class ReportDTO extends BaseSpecFields implements Serializable {
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
}