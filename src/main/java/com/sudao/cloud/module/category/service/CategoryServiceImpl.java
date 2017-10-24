package com.sudao.cloud.module.category.service;

import com.sudao.cloud.module.base.config.enums.Status;
import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.service.BaseServiceImpl;
import com.sudao.cloud.module.base.utils.BeanUtils;
import com.sudao.cloud.module.category.dao.dto.CategoryDTO;
import com.sudao.cloud.module.category.dao.dto.CategoryDTOExample;
import com.sudao.cloud.module.category.dao.mapper.CategoryDTOMapper;
import com.sudao.cloud.module.category.vo.req.CategoryQuery;
import com.sudao.cloud.module.category.vo.req.CategoryReq;
import com.sudao.cloud.module.category.vo.resp.CategoryResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl extends BaseServiceImpl implements CategoryService {

    @Autowired
    private CategoryDTOMapper categoryDTOMapper;

    @Override
    public CategoryResp getById(Long categoryId) {
        CategoryDTO categoryDTO = this.categoryDTOMapper.selectByPrimaryKey(categoryId);
        if (categoryDTO != null && Status.NORMAL.code() == categoryDTO.getDeleted()) {
            return BeanUtils.copyProperties(categoryDTO, CategoryResp.class);
        }

        return null;
    }

    @Override
    public boolean create(CategoryReq obj) {
        logger.debug("Creating Category: {}", obj);
        Date date = new Date();

        CategoryDTO categoryDTO = BeanUtils.copyProperties(obj, CategoryDTO.class);
        categoryDTO.setDeleted(Status.NORMAL.code());
        categoryDTO.setCreateTime(date);
        categoryDTO.setCreateUserId(obj.getOperatorId());
        categoryDTO.setCreateUserName(obj.getOperatorName());
        categoryDTO.setUpdateTime(date);
        categoryDTO.setUpdateUserId(obj.getOperatorId());
        categoryDTO.setUpdateUserName(obj.getOperatorName());

        return this.categoryDTOMapper.insertSelective(categoryDTO) > 0;
    }

    @Override
    public boolean update(CategoryReq obj) {
        logger.debug("Updating Category: {}", obj);

        CategoryDTO categoryDTO = BeanUtils.copyProperties(obj, CategoryDTO.class);
        categoryDTO.setUpdateTime(new Date());
        categoryDTO.setUpdateUserId(obj.getOperatorId());
        categoryDTO.setUpdateUserName(obj.getOperatorName());
        return this.categoryDTOMapper.updateByPrimaryKeySelective(categoryDTO) > 0;
    }

    @Override
    public Page<CategoryResp> find(CategoryQuery query) {
        Page<CategoryResp> page = new Page<CategoryResp>(query);
        CategoryDTOExample example = new CategoryDTOExample();
        CategoryDTOExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(Status.NORMAL.code());
        example.setOrderByClause("category_id DESC");

        long total = this.categoryDTOMapper.countByExample(example);
        page.setTotal(total);
        if (total > query.getOffset()) {
            List<CategoryDTO> list = this.categoryDTOMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
            page.setItems(BeanUtils.copyListProperties(list, CategoryResp.class));
        }
        return page;
    }
}
