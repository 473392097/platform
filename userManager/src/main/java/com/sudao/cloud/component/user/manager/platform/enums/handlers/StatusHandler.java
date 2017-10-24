package com.sudao.cloud.component.user.manager.platform.enums.handlers;

import com.sudao.cloud.component.user.manager.platform.enums.Status;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by fuqinqin on 2017/7/18.
 */
@MappedTypes({Status.class})
public class StatusHandler implements TypeHandler<Status> {

    @Override
    public void setParameter(PreparedStatement ps, int i, Status parameter, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, Byte.parseByte(String.valueOf(parameter.code())));
    }

    @Override
    public Status getResult(ResultSet rs, String columnName) throws SQLException {
        return Status.codeOf(rs.getInt(columnName));
    }

    @Override
    public Status getResult(ResultSet rs, int columnIndex) throws SQLException {
        return Status.codeOf(rs.getInt(columnIndex));
    }

    @Override
    public Status getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return Status.codeOf(cs.getInt(columnIndex));
    }
}
