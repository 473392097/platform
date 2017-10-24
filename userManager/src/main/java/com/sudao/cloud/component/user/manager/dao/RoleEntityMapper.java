package com.sudao.cloud.component.user.manager.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface RoleEntityMapper {
    @SelectProvider(type=RoleEntitySqlProvider.class, method="countByExample")
    int countByExample(RoleEntityExample example);

    @DeleteProvider(type=RoleEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(RoleEntityExample example);

    @Delete({
        "delete from platform_role",
        "where role_id = #{roleId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long roleId);

    @Insert({
        "insert into platform_role (name, code, ",
        "remark, display_order, ",
        "version, status, ",
        "create_by, create_time, ",
        "update_by, update_time, ",
        "last_update, deleted)",
        "values (#{name,jdbcType=VARCHAR}, #{code,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{displayOrder,jdbcType=INTEGER}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP}, #{deleted,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="roleId", before=false, resultType=Long.class)
    int insert(RoleEntity record);

    @InsertProvider(type=RoleEntitySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="roleId", before=false, resultType=Long.class)
    int insertSelective(RoleEntity record);

    @SelectProvider(type=RoleEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
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
    List<RoleEntity> selectByExampleWithRowbounds(RoleEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=RoleEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
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
    List<RoleEntity> selectByExample(RoleEntityExample example);

    @Select({
        "select",
        "role_id, name, code, remark, display_order, version, status, create_by, create_time, ",
        "update_by, update_time, last_update, deleted",
        "from platform_role",
        "where role_id = #{roleId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
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
    RoleEntity selectByPrimaryKey(Long roleId);

    @UpdateProvider(type=RoleEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RoleEntity record, @Param("example") RoleEntityExample example);

    @UpdateProvider(type=RoleEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RoleEntity record, @Param("example") RoleEntityExample example);

    @UpdateProvider(type=RoleEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RoleEntity record);

    @Update({
        "update platform_role",
        "set name = #{name,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "display_order = #{displayOrder,jdbcType=INTEGER},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "create_by = #{createBy,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=BIGINT},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP},",
          "deleted = #{deleted,jdbcType=INTEGER}",
        "where role_id = #{roleId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(RoleEntity record);
}