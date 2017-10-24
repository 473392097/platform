package com.sudao.cloud.component.user.manager.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ManagerUserEntityMapper {
    @SelectProvider(type=ManagerUserEntitySqlProvider.class, method="countByExample")
    int countByExample(ManagerUserEntityExample example);

    @DeleteProvider(type=ManagerUserEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(ManagerUserEntityExample example);

    @Delete({
        "delete from platform_manager_user",
        "where manager_user_id = #{managerUserId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long managerUserId);

    @Insert({
        "insert into platform_manager_user (login_name, user_name, ",
        "password, gender, ",
        "email, telephone, ",
        "remark, display_order, ",
        "version, status, ",
        "create_by, create_time, ",
        "update_by, update_time, ",
        "last_update, deleted)",
        "values (#{loginName,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{gender,jdbcType=INTEGER}, ",
        "#{email,jdbcType=VARCHAR}, #{telephone,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{displayOrder,jdbcType=INTEGER}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP}, #{deleted,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="managerUserId", before=false, resultType=Long.class)
    int insert(ManagerUserEntity record);

    @InsertProvider(type=ManagerUserEntitySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="managerUserId", before=false, resultType=Long.class)
    int insertSelective(ManagerUserEntity record);

    @SelectProvider(type=ManagerUserEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="manager_user_id", property="managerUserId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="login_name", property="loginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.INTEGER),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="telephone", property="telephone", jdbcType=JdbcType.VARCHAR),
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
    List<ManagerUserEntity> selectByExampleWithRowbounds(ManagerUserEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ManagerUserEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="manager_user_id", property="managerUserId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="login_name", property="loginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.INTEGER),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="telephone", property="telephone", jdbcType=JdbcType.VARCHAR),
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
    List<ManagerUserEntity> selectByExample(ManagerUserEntityExample example);

    @Select({
        "select",
        "manager_user_id, login_name, user_name, password, gender, email, telephone, ",
        "remark, display_order, version, status, create_by, create_time, update_by, update_time, ",
        "last_update, deleted",
        "from platform_manager_user",
        "where manager_user_id = #{managerUserId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="manager_user_id", property="managerUserId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="login_name", property="loginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.INTEGER),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="telephone", property="telephone", jdbcType=JdbcType.VARCHAR),
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
    ManagerUserEntity selectByPrimaryKey(Long managerUserId);

    @UpdateProvider(type=ManagerUserEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ManagerUserEntity record, @Param("example") ManagerUserEntityExample example);

    @UpdateProvider(type=ManagerUserEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ManagerUserEntity record, @Param("example") ManagerUserEntityExample example);

    @UpdateProvider(type=ManagerUserEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ManagerUserEntity record);

    @Update({
        "update platform_manager_user",
        "set login_name = #{loginName,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "gender = #{gender,jdbcType=INTEGER},",
          "email = #{email,jdbcType=VARCHAR},",
          "telephone = #{telephone,jdbcType=VARCHAR},",
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
        "where manager_user_id = #{managerUserId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ManagerUserEntity record);
}