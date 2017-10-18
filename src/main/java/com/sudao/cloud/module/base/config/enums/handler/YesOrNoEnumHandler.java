package com.sudao.cloud.module.base.config.enums.handler;

import com.sudao.cloud.module.base.config.enums.YesOrNoEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes({YesOrNoEnum.class})
public class YesOrNoEnumHandler implements TypeHandler<YesOrNoEnum> {

    @Override
    public YesOrNoEnum getResult(ResultSet rs, String column) throws SQLException {
        return YesOrNoEnum.codeOf(rs.getInt(column));
    }

    @Override
    public YesOrNoEnum getResult(ResultSet rs, int i) throws SQLException {
        return YesOrNoEnum.codeOf(rs.getInt(i));
    }

    @Override
    public YesOrNoEnum getResult(CallableStatement cs, int i) throws SQLException {
        return YesOrNoEnum.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, YesOrNoEnum param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
