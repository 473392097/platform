package com.sudao.cloud.module.base.config.enums.handler;

import com.sudao.cloud.module.base.config.enums.Deleted;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes({Deleted.class})
public class DeletedHandler implements TypeHandler<Deleted> {

    @Override
    public Deleted getResult(ResultSet rs, String column) throws SQLException {
        return Deleted.codeOf(rs.getInt(column));
    }

    @Override
    public Deleted getResult(ResultSet rs, int i) throws SQLException {
        return Deleted.codeOf(rs.getInt(i));
    }

    @Override
    public Deleted getResult(CallableStatement cs, int i) throws SQLException {
        return Deleted.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, Deleted param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
