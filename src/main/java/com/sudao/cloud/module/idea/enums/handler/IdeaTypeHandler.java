package com.sudao.cloud.module.idea.enums.handler;

import com.sudao.cloud.module.idea.enums.IdeaType;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes({IdeaType.class})
public class IdeaTypeHandler implements TypeHandler<IdeaType> {

    @Override
    public IdeaType getResult(ResultSet rs, String column) throws SQLException {
        return IdeaType.codeOf(rs.getInt(column));
    }

    @Override
    public IdeaType getResult(ResultSet rs, int i) throws SQLException {
        return IdeaType.codeOf(rs.getInt(i));
    }

    @Override
    public IdeaType getResult(CallableStatement cs, int i) throws SQLException {
        return IdeaType.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, IdeaType param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
