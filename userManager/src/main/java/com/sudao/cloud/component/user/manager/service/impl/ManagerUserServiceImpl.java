package com.sudao.cloud.component.user.manager.service.impl;

import com.sudao.cloud.component.user.manager.dao.ManagerUserEntity;
import com.sudao.cloud.component.user.manager.dao.ManagerUserEntityExample;
import com.sudao.cloud.component.user.manager.dao.ManagerUserEntityExample.Criteria;
import com.sudao.cloud.component.user.manager.dao.ManagerUserEntityMapper;
import com.sudao.cloud.component.user.manager.service.ManagerUserService;
import com.sudao.cloud.component.user.manager.platform.base.result.Page;
import com.sudao.cloud.component.user.manager.platform.base.service.BaseServiceImpl;
import com.sudao.cloud.component.user.manager.platform.common.utils.BeanUtils;
import com.sudao.cloud.component.user.manager.platform.enums.Deleted;
import com.sudao.cloud.component.user.manager.platform.enums.Status;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class ManagerUserServiceImpl extends BaseServiceImpl implements ManagerUserService {
	private static final String TRACKING_TYPE = "ManagerUser";

    @Autowired
    private ManagerUserEntityMapper managerUserEntityMapper;

	@Override
	public ManagerUser getById(Long managerUserId) {
		ManagerUserEntity entity = this.managerUserEntityMapper.selectByPrimaryKey(managerUserId);
		if (entity != null && Deleted.NORMAL == entity.getDeleted()) {
			return BeanUtils.copyProperties(entity, ManagerUser.class);
		}
		
		return null;
	}

	@Override
	public ManagerUser getByLoginName(String loginName) {
		if (StringUtils.isBlank(loginName)){
			return null;
		}
		ManagerUser obj = new ManagerUser();
		obj.setLoginName(loginName);
		List<ManagerUser> userList = findByObj(obj);
		return CollectionUtils.isNotEmpty(userList) ? userList.get(0) : null;
	}

	@Override
	public List<ManagerUser> findByObj(ManagerUser obj) {

		ManagerUserEntityExample example = new ManagerUserEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(Deleted.NORMAL);
		criteria.andStatusEqualTo(Status.ACTIVATE);

		if (StringUtils.isNotBlank(obj.getLoginName())) {
			criteria.andLoginNameEqualTo(obj.getLoginName());
		}
		if (StringUtils.isNotBlank(obj.getUserName())) {
            criteria.andUserNameEqualTo(obj.getUserName());
		}

		example.setOrderByClause("manager_user_id DESC");
		List<ManagerUserEntity> list = this.managerUserEntityMapper.selectByExample(example);
		return BeanUtils.copyListProperties(list, ManagerUser.class);
	}

	@Override
	public Long create(ManagerUser obj) {
		logger.debug("Creating ManagerUser: {}", obj);

//		obj.setManagerUserId(this.getSequenceService().nextLong());
		
		ManagerUserEntity entity = BeanUtils.copyProperties(obj, ManagerUserEntity.class);
		entity.setDeleted(Deleted.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.managerUserEntityMapper.insertSelective(entity);
//		this.getTrackingService().save(TRACKING_TYPE, entity.getManagerUserId(), "create", entity);
		
		logger.info("Created ManagerUser: {}", obj);

		return entity.getManagerUserId();
	}

	@Override
	public void update(ManagerUser obj) {
		logger.debug("Updating ManagerUser: {}", obj);

		ManagerUserEntity entity = BeanUtils.copyProperties(obj, ManagerUserEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.managerUserEntityMapper.updateByPrimaryKeySelective(entity);

//		this.getTrackingService().save(TRACKING_TYPE, entity.getManagerUserId(), "update", entity);

		logger.info("Updated ManagerUser: {}", obj);
	}

	@Override
	public Long save(ManagerUser obj) {
		logger.debug("Saving ManagerUser: {}", obj);

		if (obj.getManagerUserId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getManagerUserId();
	}

	@Override
	public Page<ManagerUser> find(ManagerUserQuery query) {
		Page<ManagerUser> page = new Page<ManagerUser>(query);
		ManagerUserEntityExample example = new ManagerUserEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andDeletedEqualTo(Deleted.NORMAL);
		criteria.andStatusEqualTo(Status.ACTIVATE);

		example.setOrderByClause("manager_user_id DESC");
		page.setTotal(this.managerUserEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<ManagerUserEntity> list = this.managerUserEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, ManagerUser.class));
		}
		
		return page;
	}
}
