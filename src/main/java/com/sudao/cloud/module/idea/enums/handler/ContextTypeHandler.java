package com.sudao.cloud.module.idea.enums.handler;

import com.sudao.cloud.module.idea.enums.ContextType;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes({ContextType.class})
public class ContextTypeHandler implements TypeHandler<ContextType> {

    @Override
    public ContextType getResult(ResultSet rs, String column) throws SQLException {
        return ContextType.codeOf(rs.getInt(column));
    }

    @Override
    public ContextType getResult(ResultSet rs, int i) throws SQLException {
        return ContextType.codeOf(rs.getInt(i));
    }

    @Override
    public ContextType getResult(CallableStatement cs, int i) throws SQLException {
        return ContextType.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, ContextType param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
