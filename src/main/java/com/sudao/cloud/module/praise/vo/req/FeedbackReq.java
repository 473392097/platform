package com.sudao.cloud.module.praise.vo.req;

import com.sudao.cloud.module.praise.dao.dto.FeedbackDTO;

import java.io.Serializable;

public class FeedbackReq extends FeedbackDTO implements Serializable {

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
