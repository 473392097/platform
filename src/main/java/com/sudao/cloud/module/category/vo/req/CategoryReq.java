package com.sudao.cloud.module.category.vo.req;

import com.sudao.cloud.module.category.dao.dto.CategoryDTO;

import java.io.Serializable;

public class CategoryReq extends CategoryDTO implements Serializable {

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
