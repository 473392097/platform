package com.sudao.cloud.module.catelog.vo.req;

import com.sudao.cloud.module.catelog.dao.dto.CatelogDTO;

import java.io.Serializable;

public class CatelogReq extends CatelogDTO implements Serializable {

    private Long operator;

    public Long getOperator() {
        return operator;
    }
    public void setOperator(Long operator) {
        this.operator = operator;
    }
}
