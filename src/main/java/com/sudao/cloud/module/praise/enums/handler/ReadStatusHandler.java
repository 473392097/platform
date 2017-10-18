package com.sudao.cloud.module.praise.enums.handler;

import com.sudao.cloud.module.praise.enums.ReadStatus;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes({ReadStatus.class})
public class ReadStatusHandler implements TypeHandler<ReadStatus> {

    @Override
    public ReadStatus getResult(ResultSet rs, String column) throws SQLException {
        return ReadStatus.codeOf(rs.getInt(column));
    }

    @Override
    public ReadStatus getResult(ResultSet rs, int i) throws SQLException {
        return ReadStatus.codeOf(rs.getInt(i));
    }

    @Override
    public ReadStatus getResult(CallableStatement cs, int i) throws SQLException {
        return ReadStatus.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, ReadStatus param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
