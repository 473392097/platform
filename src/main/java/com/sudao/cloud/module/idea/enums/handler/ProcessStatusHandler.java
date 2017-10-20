package com.sudao.cloud.module.idea.enums.handler;

import com.sudao.cloud.module.idea.enums.ProcessStatus;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes({ProcessStatus.class})
public class ProcessStatusHandler implements TypeHandler<ProcessStatus> {

    @Override
    public ProcessStatus getResult(ResultSet rs, String column) throws SQLException {
        return ProcessStatus.codeOf(rs.getInt(column));
    }

    @Override
    public ProcessStatus getResult(ResultSet rs, int i) throws SQLException {
        return ProcessStatus.codeOf(rs.getInt(i));
    }

    @Override
    public ProcessStatus getResult(CallableStatement cs, int i) throws SQLException {
        return ProcessStatus.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, ProcessStatus param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
