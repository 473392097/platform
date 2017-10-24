package com.sudao.cloud.component.user.manager.dao;

import com.sudao.cloud.component.user.manager.dao.UserRoleEntityExample.Criteria;
import com.sudao.cloud.component.user.manager.dao.UserRoleEntityExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class UserRoleEntitySqlProvider {

    public String countByExample(UserRoleEntityExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("platform_user_role");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(UserRoleEntityExample example) {
        BEGIN();
        DELETE_FROM("platform_user_role");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(UserRoleEntity record) {
        BEGIN();
        INSERT_INTO("platform_user_role");
        
        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=BIGINT}");
        }
        
        if (record.getRoleId() != null) {
            VALUES("role_id", "#{roleId,jdbcType=BIGINT}");
        }
        
        if (record.getDisplayOrder() != null) {
            VALUES("display_order", "#{displayOrder,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            VALUES("remark", "#{remark,jdbcType=VARCHAR}");
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

    public String selectByExample(UserRoleEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("user_role_id");
        } else {
            SELECT("user_role_id");
        }
        SELECT("user_id");
        SELECT("role_id");
        SELECT("display_order");
        SELECT("remark");
        SELECT("version");
        SELECT("status");
        SELECT("create_by");
        SELECT("create_time");
        SELECT("update_by");
        SELECT("update_time");
        SELECT("last_update");
        SELECT("deleted");
        FROM("platform_user_role");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        UserRoleEntity record = (UserRoleEntity) parameter.get("record");
        UserRoleEntityExample example = (UserRoleEntityExample) parameter.get("example");
        
        BEGIN();
        UPDATE("platform_user_role");
        
        if (record.getUserRoleId() != null) {
            SET("user_role_id = #{record.userRoleId,jdbcType=BIGINT}");
        }
        
        if (record.getUserId() != null) {
            SET("user_id = #{record.userId,jdbcType=BIGINT}");
        }
        
        if (record.getRoleId() != null) {
            SET("role_id = #{record.roleId,jdbcType=BIGINT}");
        }
        
        if (record.getDisplayOrder() != null) {
            SET("display_order = #{record.displayOrder,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{record.remark,jdbcType=VARCHAR}");
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
        UPDATE("platform_user_role");
        
        SET("user_role_id = #{record.userRoleId,jdbcType=BIGINT}");
        SET("user_id = #{record.userId,jdbcType=BIGINT}");
        SET("role_id = #{record.roleId,jdbcType=BIGINT}");
        SET("display_order = #{record.displayOrder,jdbcType=INTEGER}");
        SET("remark = #{record.remark,jdbcType=VARCHAR}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("create_by = #{record.createBy,jdbcType=BIGINT}");
        SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("update_by = #{record.updateBy,jdbcType=BIGINT}");
        SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("last_update = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        SET("deleted = #{record.deleted,jdbcType=INTEGER}");
        
        UserRoleEntityExample example = (UserRoleEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(UserRoleEntity record) {
        BEGIN();
        UPDATE("platform_user_role");
        
        if (record.getUserId() != null) {
            SET("user_id = #{userId,jdbcType=BIGINT}");
        }
        
        if (record.getRoleId() != null) {
            SET("role_id = #{roleId,jdbcType=BIGINT}");
        }
        
        if (record.getDisplayOrder() != null) {
            SET("display_order = #{displayOrder,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{remark,jdbcType=VARCHAR}");
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
        
        WHERE("user_role_id = #{userRoleId,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(UserRoleEntityExample example, boolean includeExamplePhrase) {
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