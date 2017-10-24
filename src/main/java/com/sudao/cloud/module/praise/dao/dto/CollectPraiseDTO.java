package com.sudao.cloud.module.praise.dao.dto;

import com.sudao.cloud.module.praise.enums.ActionType;
import com.sudao.cloud.module.praise.enums.RelationType;
import com.sudao.spec.dto.BaseSpecFields;
import java.io.Serializable;

public class CollectPraiseDTO extends BaseSpecFields implements Serializable {
    private Long id;

    private Long userId;

    private Long relationId;

    private RelationType relationType;

    private ActionType actionType;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public RelationType getRelationType() {
        return relationType;
    }

    public void setRelationType(RelationType relationType) {
        this.relationType = relationType;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }
}