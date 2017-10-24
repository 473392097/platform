package com.sudao.cloud.component.user.manager.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface MenuEntityMapper {
    @SelectProvider(type=MenuEntitySqlProvider.class, method="countByExample")
    int countByExample(MenuEntityExample example);

    @DeleteProvider(type=MenuEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(MenuEntityExample example);

    @Delete({
        "delete from platform_menu",
        "where menu_id = #{menuId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long menuId);

    @Insert({
        "insert into platform_menu (name, code, ",
        "menu_type, remark, ",
        "url, parent_id, display_order, ",
        "version, status, ",
        "create_by, create_time, ",
        "update_by, update_time, ",
        "last_update, deleted)",
        "values (#{name,jdbcType=VARCHAR}, #{code,jdbcType=VARCHAR}, ",
        "#{menuType,jdbcType=INTEGER}, #{remark,jdbcType=VARCHAR}, ",
        "#{url,jdbcType=VARCHAR}, #{parentId,jdbcType=BIGINT}, #{displayOrder,jdbcType=INTEGER}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP}, #{deleted,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="menuId", before=false, resultType=Long.class)
    int insert(MenuEntity record);

    @InsertProvider(type=MenuEntitySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="menuId", before=false, resultType=Long.class)
    int insertSelective(MenuEntity record);

    @SelectProvider(type=MenuEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="menu_id", property="menuId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="menu_type", property="menuType", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="display_order", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_update", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleted", property="deleted", jdbcType=JdbcType.INTEGER)
    })
    List<MenuEntity> selectByExampleWithRowbounds(MenuEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=MenuEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="menu_id", property="menuId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="menu_type", property="menuType", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="display_order", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_update", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleted", property="deleted", jdbcType=JdbcType.INTEGER)
    })
    List<MenuEntity> selectByExample(MenuEntityExample example);

    @Select({
        "select",
        "menu_id, name, code, menu_type, remark, url, parent_id, display_order, version, ",
        "status, create_by, create_time, update_by, update_time, last_update, deleted",
        "from platform_menu",
        "where menu_id = #{menuId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="menu_id", property="menuId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="menu_type", property="menuType", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="display_order", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_update", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleted", property="deleted", jdbcType=JdbcType.INTEGER)
    })
    MenuEntity selectByPrimaryKey(Long menuId);

    @UpdateProvider(type=MenuEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") MenuEntity record, @Param("example") MenuEntityExample example);

    @UpdateProvider(type=MenuEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") MenuEntity record, @Param("example") MenuEntityExample example);

    @UpdateProvider(type=MenuEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MenuEntity record);

    @Update({
        "update platform_menu",
        "set name = #{name,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR},",
          "menu_type = #{menuType,jdbcType=INTEGER},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "parent_id = #{parentId,jdbcType=BIGINT},",
          "display_order = #{displayOrder,jdbcType=INTEGER},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "create_by = #{createBy,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=BIGINT},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP},",
          "deleted = #{deleted,jdbcType=INTEGER}",
        "where menu_id = #{menuId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(MenuEntity record);
}