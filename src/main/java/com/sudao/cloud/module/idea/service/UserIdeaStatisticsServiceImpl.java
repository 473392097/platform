package com.sudao.cloud.module.idea.service;

import com.sudao.cloud.module.base.config.enums.Deleted;
import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.service.BaseServiceImpl;
import com.sudao.cloud.module.base.utils.BeanUtils;
import com.sudao.cloud.module.idea.dao.dto.UserIdeaStatisticsDTO;
import com.sudao.cloud.module.idea.dao.dto.UserIdeaStatisticsDTOExample;
import com.sudao.cloud.module.idea.dao.mapper.UserIdeaStatisticsDTOMapper;
import com.sudao.cloud.module.idea.vo.req.UserIdeaStatisticsQuery;
import com.sudao.cloud.module.idea.vo.req.UserIdeaStatisticsReq;
import com.sudao.cloud.module.idea.vo.resp.UserIdeaStatisticsResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserIdeaStatisticsServiceImpl extends BaseServiceImpl implements UserIdeaStatisticsService {

    @Autowired
    private UserIdeaStatisticsDTOMapper userIdeaStatisticsDTOMapper;

	@Override
	public UserIdeaStatisticsResp getById(Long id) {
		UserIdeaStatisticsDTO userIdeaStatisticsDTO = this.userIdeaStatisticsDTOMapper.selectByPrimaryKey(id);
		if (userIdeaStatisticsDTO != null && Deleted.NORMAL.code() == userIdeaStatisticsDTO.getDeleted()) {
			return BeanUtils.copyProperties(userIdeaStatisticsDTO, UserIdeaStatisticsResp.class);
		}

		return null;
	}

	@Override
	public boolean create(UserIdeaStatisticsReq obj) {
		logger.debug("Creating UserIdeaStatistics: {}", obj);
		Date date = new Date();

		UserIdeaStatisticsDTO userIdeaStatisticsDTO = BeanUtils.copyProperties(obj, UserIdeaStatisticsDTO.class);
		userIdeaStatisticsDTO.setDeleted(Deleted.NORMAL.code());
        userIdeaStatisticsDTO.setCreateTime(date);
        userIdeaStatisticsDTO.setCreateUserId(obj.getOperatorId());
        userIdeaStatisticsDTO.setCreateUserName(obj.getOperatorName());
        userIdeaStatisticsDTO.setUpdateTime(date);
        userIdeaStatisticsDTO.setUpdateUserId(obj.getOperatorId());
        userIdeaStatisticsDTO.setUpdateUserName(obj.getOperatorName());

		return this.userIdeaStatisticsDTOMapper.insertSelective(userIdeaStatisticsDTO) > 0;
	}

	@Override
	public boolean update(UserIdeaStatisticsReq obj) {
		logger.debug("Updating UserIdeaStatistics: {}", obj);

		UserIdeaStatisticsDTO userIdeaStatisticsDTO = BeanUtils.copyProperties(obj, UserIdeaStatisticsDTO.class);
		userIdeaStatisticsDTO.setUpdateTime(new Date());
        userIdeaStatisticsDTO.setUpdateUserId(obj.getOperatorId());
        userIdeaStatisticsDTO.setUpdateUserName(obj.getOperatorName());
		return this.userIdeaStatisticsDTOMapper.updateByPrimaryKeySelective(userIdeaStatisticsDTO) > 0;
	}

	@Override
	public Page<UserIdeaStatisticsResp> find(UserIdeaStatisticsQuery query) {
		Page<UserIdeaStatisticsResp> page = new Page<UserIdeaStatisticsResp>(query);
        UserIdeaStatisticsDTOExample example = new UserIdeaStatisticsDTOExample();
        UserIdeaStatisticsDTOExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(Deleted.NORMAL.code());
        example.setOrderByClause("id DESC");

        long total = this.userIdeaStatisticsDTOMapper.countByExample(example);
        page.setTotal(total);
        if (total > query.getOffset()) {
            List<UserIdeaStatisticsDTO> list = this.userIdeaStatisticsDTOMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
            page.setItems(BeanUtils.copyListProperties(list, UserIdeaStatisticsResp.class));
        }
        return page;
	}
}
