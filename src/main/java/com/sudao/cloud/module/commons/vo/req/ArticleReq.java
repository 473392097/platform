package com.sudao.cloud.module.commons.vo.req;

import com.sudao.cloud.module.commons.dao.dto.ArticleDTO;

import java.io.Serializable;

public class ArticleReq extends ArticleDTO implements Serializable {

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
