package com.sudao.cloud.component.user.manager.dao;

import com.sudao.cloud.component.user.manager.dao.MenuEntityExample.Criteria;
import com.sudao.cloud.component.user.manager.dao.MenuEntityExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class MenuEntitySqlProvider {

    public String countByExample(MenuEntityExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("platform_menu");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(MenuEntityExample example) {
        BEGIN();
        DELETE_FROM("platform_menu");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(MenuEntity record) {
        BEGIN();
        INSERT_INTO("platform_menu");
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            VALUES("code", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getMenuType() != null) {
            VALUES("menu_type", "#{menuType,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            VALUES("url", "#{url,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            VALUES("parent_id", "#{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getDisplayOrder() != null) {
            VALUES("display_order", "#{displayOrder,jdbcType=INTEGER}");
        }
        
        if (record.getVersion() != null) {
            VALUES("version", "#{version,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateBy() != null) {
            VALUES("create_by", "#{createBy,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateBy() != null) {
            VALUES("update_by", "#{updateBy,jdbcType=BIGINT}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastUpdate() != null) {
            VALUES("last_update", "#{lastUpdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDeleted() != null) {
            VALUES("deleted", "#{deleted,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String selectByExample(MenuEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("menu_id");
        } else {
            SELECT("menu_id");
        }
        SELECT("name");
        SELECT("code");
        SELECT("menu_type");
        SELECT("remark");
        SELECT("url");
        SELECT("parent_id");
        SELECT("display_order");
        SELECT("version");
        SELECT("status");
        SELECT("create_by");
        SELECT("create_time");
        SELECT("update_by");
        SELECT("update_time");
        SELECT("last_update");
        SELECT("deleted");
        FROM("platform_menu");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        MenuEntity record = (MenuEntity) parameter.get("record");
        MenuEntityExample example = (MenuEntityExample) parameter.get("example");
        
        BEGIN();
        UPDATE("platform_menu");
        
        if (record.getMenuId() != null) {
            SET("menu_id = #{record.menuId,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            SET("code = #{record.code,jdbcType=VARCHAR}");
        }
        
        if (record.getMenuType() != null) {
            SET("menu_type = #{record.menuType,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            SET("url = #{record.url,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            SET("parent_id = #{record.parentId,jdbcType=BIGINT}");
        }
        
        if (record.getDisplayOrder() != null) {
            SET("display_order = #{record.displayOrder,jdbcType=INTEGER}");
        }
        
        if (record.getVersion() != null) {
            SET("version = #{record.version,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateBy() != null) {
            SET("create_by = #{record.createBy,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateBy() != null) {
            SET("update_by = #{record.updateBy,jdbcType=BIGINT}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastUpdate() != null) {
            SET("last_update = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDeleted() != null) {
            SET("deleted = #{record.deleted,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("platform_menu");
        
        SET("menu_id = #{record.menuId,jdbcType=BIGINT}");
        SET("name = #{record.name,jdbcType=VARCHAR}");
        SET("code = #{record.code,jdbcType=VARCHAR}");
        SET("menu_type = #{record.menuType,jdbcType=INTEGER}");
        SET("remark = #{record.remark,jdbcType=VARCHAR}");
        SET("url = #{record.url,jdbcType=VARCHAR}");
        SET("parent_id = #{record.parentId,jdbcType=BIGINT}");
        SET("display_order = #{record.displayOrder,jdbcType=INTEGER}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("create_by = #{record.createBy,jdbcType=BIGINT}");
        SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("update_by = #{record.updateBy,jdbcType=BIGINT}");
        SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("last_update = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        SET("deleted = #{record.deleted,jdbcType=INTEGER}");
        
        MenuEntityExample example = (MenuEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(MenuEntity record) {
        BEGIN();
        UPDATE("platform_menu");
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            SET("code = #{code,jdbcType=VARCHAR}");
        }
        
        if (record.getMenuType() != null) {
            SET("menu_type = #{menuType,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            SET("url = #{url,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            SET("parent_id = #{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getDisplayOrder() != null) {
            SET("display_order = #{displayOrder,jdbcType=INTEGER}");
        }
        
        if (record.getVersion() != null) {
            SET("version = #{version,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateBy() != null) {
            SET("create_by = #{createBy,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateBy() != null) {
            SET("update_by = #{updateBy,jdbcType=BIGINT}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastUpdate() != null) {
            SET("last_update = #{lastUpdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDeleted() != null) {
            SET("deleted = #{deleted,jdbcType=INTEGER}");
        }
        
        WHERE("menu_id = #{menuId,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(MenuEntityExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}