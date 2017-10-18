package com.sudao.cloud.module.praise.enums.handler;

import com.sudao.cloud.module.praise.enums.ActionType;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes({ActionType.class})
public class ActionTypeHandler implements TypeHandler<ActionType> {

    @Override
    public ActionType getResult(ResultSet rs, String column) throws SQLException {
        return ActionType.codeOf(rs.getInt(column));
    }

    @Override
    public ActionType getResult(ResultSet rs, int i) throws SQLException {
        return ActionType.codeOf(rs.getInt(i));
    }

    @Override
    public ActionType getResult(CallableStatement cs, int i) throws SQLException {
        return ActionType.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, ActionType param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
