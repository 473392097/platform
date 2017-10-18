package com.sudao.cloud.module.praise.enums.handler;

import com.sudao.cloud.module.praise.enums.RelationType;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes({RelationType.class})
public class RelationTypeHandler implements TypeHandler<RelationType> {

    @Override
    public RelationType getResult(ResultSet rs, String column) throws SQLException {
        return RelationType.codeOf(rs.getInt(column));
    }

    @Override
    public RelationType getResult(ResultSet rs, int i) throws SQLException {
        return RelationType.codeOf(rs.getInt(i));
    }

    @Override
    public RelationType getResult(CallableStatement cs, int i) throws SQLException {
        return RelationType.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, RelationType param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
