package com.sudao.cloud.module.commons.dao.dto;

import com.sudao.cloud.module.idea.enums.EnumInformationType;
import com.sudao.spec.dto.BaseSpecFields;
import java.io.Serializable;

public class InformationDTO extends BaseSpecFields implements Serializable {
    private Long informationId;

    private EnumInformationType type;

    private String typeDesc;

    private String valueCode;

    private String valueDesc;

    private static final long serialVersionUID = 1L;

    public Long getInformationId() {
        return informationId;
    }

    public void setInformationId(Long informationId) {
        this.informationId = informationId;
    }

    public EnumInformationType getType() {
        return type;
    }

    public void setType(EnumInformationType type) {
        this.type = type;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc == null ? null : typeDesc.trim();
    }

    public String getValueCode() {
        return valueCode;
    }

    public void setValueCode(String valueCode) {
        this.valueCode = valueCode == null ? null : valueCode.trim();
    }

    public String getValueDesc() {
        return valueDesc;
    }

    public void setValueDesc(String valueDesc) {
        this.valueDesc = valueDesc == null ? null : valueDesc.trim();
    }
}