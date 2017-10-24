package com.sudao.cloud.component.user.manager.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface UserRoleEntityMapper {
    @SelectProvider(type=UserRoleEntitySqlProvider.class, method="countByExample")
    int countByExample(UserRoleEntityExample example);

    @DeleteProvider(type=UserRoleEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(UserRoleEntityExample example);

    @Delete({
        "delete from platform_user_role",
        "where user_role_id = #{userRoleId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long userRoleId);

    @Insert({
        "insert into platform_user_role (user_id, role_id, ",
        "display_order, remark, ",
        "version, status, ",
        "create_by, create_time, ",
        "update_by, update_time, ",
        "last_update, deleted)",
        "values (#{userId,jdbcType=BIGINT}, #{roleId,jdbcType=BIGINT}, ",
        "#{displayOrder,jdbcType=INTEGER}, #{remark,jdbcType=VARCHAR}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP}, #{deleted,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="userRoleId", before=false, resultType=Long.class)
    int insert(UserRoleEntity record);

    @InsertProvider(type=UserRoleEntitySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="userRoleId", before=false, resultType=Long.class)
    int insertSelective(UserRoleEntity record);

    @SelectProvider(type=UserRoleEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_role_id", property="userRoleId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT),
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
    List<UserRoleEntity> selectByExampleWithRowbounds(UserRoleEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=UserRoleEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_role_id", property="userRoleId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT),
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
    List<UserRoleEntity> selectByExample(UserRoleEntityExample example);

    @Select({
        "select",
        "user_role_id, user_id, role_id, display_order, remark, version, status, create_by, ",
        "create_time, update_by, update_time, last_update, deleted",
        "from platform_user_role",
        "where user_role_id = #{userRoleId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="user_role_id", property="userRoleId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT),
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
    UserRoleEntity selectByPrimaryKey(Long userRoleId);

    @UpdateProvider(type=UserRoleEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserRoleEntity record, @Param("example") UserRoleEntityExample example);

    @UpdateProvider(type=UserRoleEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserRoleEntity record, @Param("example") UserRoleEntityExample example);

    @UpdateProvider(type=UserRoleEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserRoleEntity record);

    @Update({
        "update platform_user_role",
        "set user_id = #{userId,jdbcType=BIGINT},",
          "role_id = #{roleId,jdbcType=BIGINT},",
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
        "where user_role_id = #{userRoleId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserRoleEntity record);
}