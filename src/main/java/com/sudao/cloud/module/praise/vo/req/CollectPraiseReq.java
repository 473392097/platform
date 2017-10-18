package com.sudao.cloud.module.praise.vo.req;

import com.sudao.cloud.module.praise.dao.dto.CollectPraiseDTO;

import java.io.Serializable;

public class CollectPraiseReq extends CollectPraiseDTO implements Serializable {

    private Long operator;

    public Long getOperator() {
        return operator;
    }
    public void setOperator(Long operator) {
        this.operator = operator;
    }
}
