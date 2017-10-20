package com.sudao.cloud.module.idea.vo.req;

import com.sudao.cloud.module.idea.dao.dto.UserIdeaStatisticsDTO;

import java.io.Serializable;

public class UserIdeaStatisticsReq extends UserIdeaStatisticsDTO implements Serializable {

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
