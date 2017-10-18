package com.sudao.cloud.module.idea.vo.req;

import com.sudao.cloud.module.idea.dao.dto.IdeaDTO;

import java.io.Serializable;

public class IdeaReq extends IdeaDTO implements Serializable {

    private Long operator;

    public Long getOperator() {
        return operator;
    }
    public void setOperator(Long operator) {
        this.operator = operator;
    }
}
