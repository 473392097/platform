package com.sudao.cloud.component.user.manager.platform.enums.handlers;

import com.sudao.cloud.component.user.manager.platform.enums.Deleted;
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
@MappedTypes({Deleted.class})
public class DeletedHandler implements TypeHandler<Deleted> {

    @Override
    public void setParameter(PreparedStatement ps, int i, Deleted parameter, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, Byte.parseByte(String.valueOf(parameter.code())));
    }

    @Override
    public Deleted getResult(ResultSet rs, String columnName) throws SQLException {
        return Deleted.codeOf(rs.getInt(columnName));
    }

    @Override
    public Deleted getResult(ResultSet rs, int columnIndex) throws SQLException {
        return Deleted.codeOf(rs.getInt(columnIndex));
    }

    @Override
    public Deleted getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return Deleted.codeOf(cs.getInt(columnIndex));
    }
}
