package com.sudao.cloud.module.idea.enums.handler;

import com.sudao.cloud.module.idea.enums.AuditStatus;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes({AuditStatus.class})
public class AuditStatusHandler implements TypeHandler<AuditStatus> {

    @Override
    public AuditStatus getResult(ResultSet rs, String column) throws SQLException {
        return AuditStatus.codeOf(rs.getInt(column));
    }

    @Override
    public AuditStatus getResult(ResultSet rs, int i) throws SQLException {
        return AuditStatus.codeOf(rs.getInt(i));
    }

    @Override
    public AuditStatus getResult(CallableStatement cs, int i) throws SQLException {
        return AuditStatus.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, AuditStatus param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
