package com.sudao.cloud.module.idea.enums.handler;

import com.sudao.cloud.module.idea.enums.AuditStatus;
import com.sudao.cloud.module.idea.enums.EnumInformationType;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes({EnumInformationType.class})
public class EnumInformationTypeHandler implements TypeHandler<EnumInformationType> {

    @Override
    public EnumInformationType getResult(ResultSet rs, String column) throws SQLException {
        return EnumInformationType.codeOf(rs.getInt(column));
    }

    @Override
    public EnumInformationType getResult(ResultSet rs, int i) throws SQLException {
        return EnumInformationType.codeOf(rs.getInt(i));
    }

    @Override
    public EnumInformationType getResult(CallableStatement cs, int i) throws SQLException {
        return EnumInformationType.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, EnumInformationType param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
