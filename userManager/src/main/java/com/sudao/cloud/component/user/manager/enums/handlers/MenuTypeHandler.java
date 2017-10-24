package com.sudao.cloud.component.user.manager.enums.handlers;

import com.sudao.cloud.component.user.manager.enums.MenuType;
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
@MappedTypes({MenuType.class})
public class MenuTypeHandler implements TypeHandler<MenuType> {

    @Override
    public void setParameter(PreparedStatement ps, int i, MenuType parameter, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, Byte.parseByte(String.valueOf(parameter.code())));
    }

    @Override
    public MenuType getResult(ResultSet rs, String columnName) throws SQLException {
        return MenuType.codeOf(rs.getInt(columnName));
    }

    @Override
    public MenuType getResult(ResultSet rs, int columnIndex) throws SQLException {
        return MenuType.codeOf(rs.getInt(columnIndex));
    }

    @Override
    public MenuType getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return MenuType.codeOf(cs.getInt(columnIndex));
    }

}
