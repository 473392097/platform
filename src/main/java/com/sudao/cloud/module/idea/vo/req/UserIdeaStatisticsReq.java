package com.sudao.cloud.module.idea.vo.req;

import com.sudao.cloud.module.idea.dao.dto.UserIdeaStatisticsDTO;

import java.io.Serializable;

public class UserIdeaStatisticsReq extends UserIdeaStatisticsDTO implements Serializable {

    private Long operator;

    public Long getOperator() {
        return operator;
    }
    public void setOperator(Long operator) {
        this.operator = operator;
    }
}
