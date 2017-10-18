package com.sudao.cloud.module.catelog.dao.dto;

import com.sudao.cloud.module.base.config.enums.Status;
import java.io.Serializable;
import java.util.Date;

public class CatelogDTO implements Serializable {
    private Long catelogId;

    private String catelogIcon;

    private String catelogName;

    private Boolean type;

    private Boolean disableStatus;

    private Status status;

    private Long createdById;

    private Long createdTime;

    private Long updatedById;

    private Long updatedTime;

    private Date lastUpdate;

    private static final long serialVersionUID = 1L;

    public Long getCatelogId() {
        return catelogId;
    }

    public void setCatelogId(Long catelogId) {
        this.catelogId = catelogId;
    }

    public String getCatelogIcon() {
        return catelogIcon;
    }

    public void setCatelogIcon(String catelogIcon) {
        this.catelogIcon = catelogIcon == null ? null : catelogIcon.trim();
    }

    public String getCatelogName() {
        return catelogName;
    }

    public void setCatelogName(String catelogName) {
        this.catelogName = catelogName == null ? null : catelogName.trim();
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Boolean getDisableStatus() {
        return disableStatus;
    }

    public void setDisableStatus(Boolean disableStatus) {
        this.disableStatus = disableStatus;
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