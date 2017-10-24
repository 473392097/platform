package com.sudao.cloud.component.user.manager.platform.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.sudao.cloud.component.user.manager.platform.enums.Deleted;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/14.
 */
public abstract class BaseEntity implements Serializable {
    private String remark;       //备注
    private Integer displayOrder;//列表显示顺序
    private Integer version; //版本号
    //private Status status;  //每张表的枚举状态不一样用,不能做通用字段
    private Long createBy;//创建者
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime; //创建日期
    private Long updateBy;//更新者
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime; //创建者
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdate; //更新日期
    private Deleted deleted; //逻辑删除
    private Long operator;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    /*public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }*/

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
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

    public Long getOperator() {
        return operator;
    }

    public void setOperator(Long operator) {
        this.operator = operator;
    }
}

