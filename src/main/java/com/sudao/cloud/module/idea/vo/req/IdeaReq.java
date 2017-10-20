package com.sudao.cloud.module.idea.vo.req;

import com.sudao.cloud.module.idea.dao.dto.IdeaDTO;

import java.io.Serializable;

public class IdeaReq extends IdeaDTO implements Serializable {

    private Long operatorId;
    private String operatorName;

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
}
