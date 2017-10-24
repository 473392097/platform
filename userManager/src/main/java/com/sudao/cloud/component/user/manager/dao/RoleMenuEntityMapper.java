package com.sudao.cloud.component.user.manager.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface RoleMenuEntityMapper {
    @SelectProvider(type=RoleMenuEntitySqlProvider.class, method="countByExample")
    int countByExample(RoleMenuEntityExample example);

    @DeleteProvider(type=RoleMenuEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(RoleMenuEntityExample example);

    @Delete({
        "delete from platform_role_menu",
        "where role_menu_id = #{roleMenuId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long roleMenuId);

    @Insert({
        "insert into platform_role_menu (role_id, menu_id, ",
        "display_order, remark, ",
        "version, status, ",
        "create_by, create_time, ",
        "update_by, update_time, ",
        "last_update, deleted)",
        "values (#{roleId,jdbcType=BIGINT}, #{menuId,jdbcType=BIGINT}, ",
        "#{displayOrder,jdbcType=INTEGER}, #{remark,jdbcType=VARCHAR}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP}, #{deleted,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="roleMenuId", before=false, resultType=Long.class)
    int insert(RoleMenuEntity record);

    @InsertProvider(type=RoleMenuEntitySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="roleMenuId", before=false, resultType=Long.class)
    int insertSelective(RoleMenuEntity record);

    @SelectProvider(type=RoleMenuEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="role_menu_id", property="roleMenuId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT),
        @Result(column="menu_id", property="menuId", jdbcType=JdbcType.BIGINT),
        @Result(column="display_order", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_update", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleted", property="deleted", jdbcType=JdbcType.INTEGER)
    })
    List<RoleMenuEntity> selectByExampleWithRowbounds(RoleMenuEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=RoleMenuEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="role_menu_id", property="roleMenuId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT),
        @Result(column="menu_id", property="menuId", jdbcType=JdbcType.BIGINT),
        @Result(column="display_order", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_update", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleted", property="deleted", jdbcType=JdbcType.INTEGER)
    })
    List<RoleMenuEntity> selectByExample(RoleMenuEntityExample example);

    @Select({
        "select",
        "role_menu_id, role_id, menu_id, display_order, remark, version, status, create_by, ",
        "create_time, update_by, update_time, last_update, deleted",
        "from platform_role_menu",
        "where role_menu_id = #{roleMenuId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="role_menu_id", property="roleMenuId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT),
        @Result(column="menu_id", property="menuId", jdbcType=JdbcType.BIGINT),
        @Result(column="display_order", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_update", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleted", property="deleted", jdbcType=JdbcType.INTEGER)
    })
    RoleMenuEntity selectByPrimaryKey(Long roleMenuId);

    @UpdateProvider(type=RoleMenuEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RoleMenuEntity record, @Param("example") RoleMenuEntityExample example);

    @UpdateProvider(type=RoleMenuEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RoleMenuEntity record, @Param("example") RoleMenuEntityExample example);

    @UpdateProvider(type=RoleMenuEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RoleMenuEntity record);

    @Update({
        "update platform_role_menu",
        "set role_id = #{roleId,jdbcType=BIGINT},",
          "menu_id = #{menuId,jdbcType=BIGINT},",
          "display_order = #{displayOrder,jdbcType=INTEGER},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "create_by = #{createBy,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=BIGINT},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP},",
          "deleted = #{deleted,jdbcType=INTEGER}",
        "where role_menu_id = #{roleMenuId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(RoleMenuEntity record);
}