package com.sudao.cloud.component.user.manager.service.impl;

import com.sudao.cloud.component.user.manager.dao.RoleEntity;
import com.sudao.cloud.component.user.manager.dao.RoleEntityExample;
import com.sudao.cloud.component.user.manager.dao.RoleEntityMapper;
import com.sudao.cloud.component.user.manager.service.RoleService;
import com.sudao.cloud.component.user.manager.platform.base.result.Page;
import com.sudao.cloud.component.user.manager.platform.base.service.BaseServiceImpl;
import com.sudao.cloud.component.user.manager.platform.common.utils.BeanUtils;
import com.sudao.cloud.component.user.manager.platform.enums.Deleted;
import com.sudao.cloud.component.user.manager.platform.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class RoleServiceImpl extends BaseServiceImpl implements RoleService {
	private static final String TRACKING_TYPE = "Role";

    @Autowired
    private RoleEntityMapper roleEntityMapper;

	@Override
	public Role getById(Long roleId) {
		RoleEntity entity = this.roleEntityMapper.selectByPrimaryKey(roleId);
		if (entity != null && Deleted.NORMAL.equals(entity.getDeleted())) {
			return BeanUtils.copyProperties(entity, Role.class);
		}
		
		return null;
	}

	@Override
	public Long create(Role obj) {
		logger.debug("Creating Role: {}", obj);

//		obj.setRoleId(this.getSequenceService().nextLong());
		
		RoleEntity entity = BeanUtils.copyProperties(obj, RoleEntity.class);
		entity.setDeleted(Deleted.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.roleEntityMapper.insertSelective(entity);

//		this.getTrackingService().save(TRACKING_TYPE, entity.getRoleId(), "create", entity);
		
		logger.info("Created Role: {}", obj);

		return entity.getRoleId();
	}

	@Override
	public void update(Role obj) {
		logger.debug("Updating Role: {}", obj);

		RoleEntity entity = BeanUtils.copyProperties(obj, RoleEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.roleEntityMapper.updateByPrimaryKeySelective(entity);

//		this.getTrackingService().save(TRACKING_TYPE, entity.getRoleId(), "update", entity);

		logger.info("Updated Role: {}", obj);
	}

	@Override
	public Long save(Role obj) {
		logger.debug("Saving Role: {}", obj);

		if (obj.getRoleId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getRoleId();
	}

	@Override
	public Page<Role> find(RoleQuery query) {
		Page<Role> page = new Page<Role>(query);
		RoleEntityExample example = new RoleEntityExample();
		RoleEntityExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.ACTIVATE);
		criteria.andDeletedEqualTo(Deleted.NORMAL);
		example.setOrderByClause("role_id DESC");
		page.setTotal(this.roleEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<RoleEntity> list = this.roleEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, Role.class));
		}
		
		return page;
	}
}
