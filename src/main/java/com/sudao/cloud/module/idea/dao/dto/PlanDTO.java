package com.sudao.cloud.module.idea.dao.dto;

import com.sudao.cloud.module.base.config.enums.Status;
import com.sudao.cloud.module.base.config.enums.YesOrNoEnum;
import com.sudao.cloud.module.idea.enums.AuditStatus;
import java.io.Serializable;
import java.util.Date;

public class PlanDTO implements Serializable {
    private Long planId;

    private Long ideaId;

    private Long ownerId;

    private String ownerName;

    private Long categoryId;

    private String categoryName;

    private String title;

    private String description;

    private String coverImage;

    private String version;

    private YesOrNoEnum isOrigin;

    private String iterationDescription;

    private AuditStatus audit;

    private Long auditUserId;

    private String auditUserName;

    private Date auditTime;

    private Integer praiseNumber;

    private Integer displayOrder;

    private Status status;

    private Long createUserId;

    private String createUserName;

    private Date createTime;

    private Long updateUserId;

    private String updateUserName;

    private Date updateTime;

    private Date lastUpdate;

    private static final long serialVersionUID = 1L;

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public YesOrNoEnum getIsOrigin() {
        return isOrigin;
    }

    public void setIsOrigin(YesOrNoEnum isOrigin) {
        this.isOrigin = isOrigin;
    }

    public String getIterationDescription() {
        return iterationDescription;
    }

    public void setIterationDescription(String iterationDescription) {
        this.iterationDescription = iterationDescription == null ? null : iterationDescription.trim();
    }

    public AuditStatus getAudit() {
        return audit;
    }

    public void setAudit(AuditStatus audit) {
        this.audit = audit;
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

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Integer getPraiseNumber() {
        return praiseNumber;
    }

    public void setPraiseNumber(Integer praiseNumber) {
        this.praiseNumber = praiseNumber;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
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