package com.sudao.cloud.module.idea.dao.dto;

import com.sudao.cloud.module.idea.enums.ContextType;
import com.sudao.spec.dto.BaseSpecFields;
import java.io.Serializable;

public class PlanContextDTO extends BaseSpecFields implements Serializable {
    private Long contextId;

    private Long planId;

    private ContextType contextType;

    private String value;

    private static final long serialVersionUID = 1L;

    public Long getContextId() {
        return contextId;
    }

    public void setContextId(Long contextId) {
        this.contextId = contextId;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public ContextType getContextType() {
        return contextType;
    }

    public void setContextType(ContextType contextType) {
        this.contextType = contextType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}