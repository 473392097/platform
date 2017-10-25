package com.sudao.cloud.component.user.manager.service.impl;

import com.sudao.cloud.component.user.manager.dao.UserRoleEntity;
import com.sudao.cloud.component.user.manager.dao.UserRoleEntityExample;
import com.sudao.cloud.component.user.manager.dao.UserRoleEntityMapper;
import com.sudao.cloud.component.user.manager.service.UserRoleService;
import com.sudao.cloud.component.user.manager.platform.base.result.Page;
import com.sudao.cloud.component.user.manager.platform.base.service.BaseServiceImpl;
import com.sudao.cloud.component.user.manager.platform.common.utils.BeanUtils;
import com.sudao.cloud.component.user.manager.platform.enums.Deleted;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class UserRoleServiceImpl extends BaseServiceImpl implements UserRoleService {


    private static final String TRACKING_TYPE = "UserRole";

    @Autowired
    private UserRoleEntityMapper userRoleEntityMapper;

    @Override
    public UserRole getById(Long userRoleId) {
        UserRoleEntity entity = this.userRoleEntityMapper.selectByPrimaryKey(userRoleId);
        if (entity != null && Deleted.NORMAL.equals(entity.getDeleted())) {
            return BeanUtils.copyProperties(entity, UserRole.class);
        }

        return null;
    }

    @Override
    public void deleteByObj(UserRole obj) {
        UserRoleEntityExample example = new UserRoleEntityExample();
        UserRoleEntityExample.Criteria criteria = example.createCriteria();

        if (obj.getUserId() != null) {
            criteria.andUserIdEqualTo(obj.getUserId());
        }

        UserRoleEntity entity = BeanUtils.copyProperties(obj, UserRoleEntity.class);
        entity.setDeleted(Deleted.DELETED);
        entity.setUpdateBy(obj.getOperator());
        entity.setUpdateTime(new Date());

        this.userRoleEntityMapper.updateByExampleSelective(entity, example);

        logger.info("Delete UserRole: {}", obj);
    }

    @Override
    public Long create(UserRole obj) {
        logger.debug("Creating UserRole: {}", obj);

//		obj.setUserRoleId(this.getSequenceService().nextLong());

        UserRoleEntity entity = BeanUtils.copyProperties(obj, UserRoleEntity.class);
        entity.setDeleted(Deleted.NORMAL);
        entity.setCreateBy(obj.getOperator());
        entity.setCreateTime(new Date());
        entity.setUpdateBy(obj.getOperator());
        entity.setUpdateTime(new Date());

        this.userRoleEntityMapper.insertSelective(entity);

//		this.getTrackingService().save(TRACKING_TYPE, entity.getUserRoleId(), "create", entity);

        logger.info("Created UserRole: {}", obj);

        return entity.getUserRoleId();
    }

    @Override
    public void update(UserRole obj) {
        logger.debug("Updating UserRole: {}", obj);

        UserRoleEntity entity = BeanUtils.copyProperties(obj, UserRoleEntity.class);
        entity.setUpdateBy(obj.getOperator());
        entity.setUpdateTime(new Date());
        this.userRoleEntityMapper.updateByPrimaryKeySelective(entity);

//		this.getTrackingService().save(TRACKING_TYPE, entity.getUserRoleId(), "update", entity);

        logger.info("Updated UserRole: {}", obj);
    }

    @Override
    public Long save(UserRole obj) {
        logger.debug("Saving UserRole: {}", obj);

        if (obj.getUserRoleId() == null) {
            this.create(obj);
        } else {
            this.update(obj);
        }

        return obj.getUserRoleId();
    }

    @Override
    public Page<UserRole> find(UserRoleQuery query) {
        Page<UserRole> page = new Page<UserRole>(query);
        UserRoleEntityExample example = new UserRoleEntityExample();
        UserRoleEntityExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(Deleted.NORMAL);
        example.setOrderByClause("user_role_id DESC");
        page.setTotal(this.userRoleEntityMapper.countByExample(example));
        if (page.getTotal() > query.getOffset()) {
            List<UserRoleEntity> list = this.userRoleEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
            page.setItems(BeanUtils.copyListProperties(list, UserRole.class));
        }

        return page;
    }

    @Override
    public List<UserRole> findByObj(UserRole obj) {
        UserRoleEntityExample example = new UserRoleEntityExample();
        UserRoleEntityExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(Deleted.NORMAL);
        if (obj.getUserId() != null) {
            criteria.andUserIdEqualTo(obj.getUserId());
        }
        if (obj.getRoleId() != null) {
            criteria.andRoleIdEqualTo(obj.getRoleId());
        }

        example.setOrderByClause("user_role_id DESC");
        List<UserRoleEntity> list = this.userRoleEntityMapper.selectByExample(example);
        return BeanUtils.copyListProperties(list, UserRole.class);

    }

    @Override
    public List<UserRole> findByUserId(Long userId) {

        if (userId == null) {
            return null;
        }
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        return findByObj(userRole);
    }

}
