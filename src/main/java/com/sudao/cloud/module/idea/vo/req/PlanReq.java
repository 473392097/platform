package com.sudao.cloud.module.idea.vo.req;

import com.sudao.cloud.module.idea.dao.dto.PlanDTO;

import java.io.Serializable;

public class PlanReq extends PlanDTO implements Serializable {

    private Long operator;

    public Long getOperator() {
        return operator;
    }
    public void setOperator(Long operator) {
        this.operator = operator;
    }
}
