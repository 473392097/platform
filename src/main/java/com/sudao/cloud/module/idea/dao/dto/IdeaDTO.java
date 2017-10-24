package com.sudao.cloud.module.idea.dao.dto;

import com.sudao.cloud.module.idea.enums.AuditStatus;
import com.sudao.cloud.module.idea.enums.IdeaType;
import com.sudao.spec.dto.BaseSpecFields;
import java.io.Serializable;

public class IdeaDTO extends BaseSpecFields implements Serializable {
    private Long ideaId;

    private Long ownerId;

    private String ownerName;

    private Long categoryId;

    private String categoryName;

    private IdeaType ideaType;

    private String title;

    private String description;

    private String coverImage;

    private String currentVersion;

    private AuditStatus audit;

    private Long auditPlanId;

    private Long auditUserId;

    private String auditUserName;

    private Long auditTime;

    private Integer praiseNumber;

    private static final long serialVersionUID = 1L;

    public Long getIdeaId() {
        return ideaId;
    }

    public void setIdeaId(Long ideaId) {
        this.ideaId = ideaId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName == null ? null : ownerName.trim();
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public IdeaType getIdeaType() {
        return ideaType;
    }

    public void setIdeaType(IdeaType ideaType) {
        this.ideaType = ideaType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage == null ? null : coverImage.trim();
    }

    public String getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion == null ? null : currentVersion.trim();
    }

    public AuditStatus getAudit() {
        return audit;
    }

    public void setAudit(AuditStatus audit) {
        this.audit = audit;
    }

    public Long getAuditPlanId() {
        return auditPlanId;
    }

    public void setAuditPlanId(Long auditPlanId) {
        this.auditPlanId = auditPlanId;
    }

    public Long getAuditUserId() {
        return auditUserId;
    }

    public void setAuditUserId(Long auditUserId) {
        this.auditUserId = auditUserId;
    }

    public String getAuditUserName() {
        return auditUserName;
    }

    public void setAuditUserName(String auditUserName) {
        this.auditUserName = auditUserName == null ? null : auditUserName.trim();
    }

    public Long getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Long auditTime) {
        this.auditTime = auditTime;
    }

    public Integer getPraiseNumber() {
        return praiseNumber;
    }

    public void setPraiseNumber(Integer praiseNumber) {
        this.praiseNumber = praiseNumber;
    }
}