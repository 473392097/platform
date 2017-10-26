package com.sudao.cloud.module.idea.service;

import com.sudao.cloud.component.user.manager.exception.ManagerUserException;
import com.sudao.cloud.component.user.manager.platform.base.crypt.PasswordCrypt;
import com.sudao.cloud.component.user.manager.service.ManagerUserService;
import com.sudao.cloud.module.base.config.enums.Deleted;
import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.service.BaseServiceImpl;
import com.sudao.cloud.module.base.utils.BeanUtils;
import com.sudao.cloud.module.idea.dao.dto.UserDTO;
import com.sudao.cloud.module.idea.dao.dto.UserDTOExample;
import com.sudao.cloud.module.idea.dao.mapper.UserDTOMapper;
import com.sudao.cloud.module.idea.vo.req.UserQuery;
import com.sudao.cloud.module.idea.vo.req.UserReq;
import com.sudao.cloud.module.idea.vo.req.biz.UpdatePasswordReq;
import com.sudao.cloud.module.idea.vo.resp.UserResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Autowired
    private UserDTOMapper userDTOMapper;

    @Override
    public UserResp getById(Long id) {
        UserDTO userDTO = this.userDTOMapper.selectByPrimaryKey(id);
        if (userDTO != null && Deleted.NORMAL.code() == userDTO.getDeleted()) {
            return BeanUtils.copyProperties(userDTO, UserResp.class);
        }

        return null;
    }

    @Override
    public boolean create(UserReq obj) {
        logger.debug("Creating User: {}", obj);
        Date date = new Date();

        UserDTO userDTO = BeanUtils.copyProperties(obj, UserDTO.class);
        userDTO.setDeleted(Deleted.NORMAL.code());
        userDTO.setCreateTime(date);
        userDTO.setCreateUserId(obj.getOperatorId());
        userDTO.setCreateUserName(obj.getOperatorName());
        userDTO.setUpdateTime(date);
        userDTO.setUpdateUserId(obj.getOperatorId());
        userDTO.setUpdateUserName(obj.getOperatorName());

        return this.userDTOMapper.insertSelective(userDTO) > 0;
    }

    @Override
    public boolean update(UserReq obj) {
        logger.debug("Updating User: {}", obj);

        UserDTO userDTO = BeanUtils.copyProperties(obj, UserDTO.class);
        userDTO.setUpdateTime(new Date());
        userDTO.setUpdateUserId(obj.getOperatorId());
        userDTO.setUpdateUserName(obj.getOperatorName());
        return this.userDTOMapper.updateByPrimaryKeySelective(userDTO) > 0;
    }

    @Override
    public Page<UserResp> find(UserQuery query) {
        Page<UserResp> page = new Page<UserResp>(query);
        UserDTOExample example = new UserDTOExample();
        UserDTOExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(Deleted.NORMAL.code());
        example.setOrderByClause("id DESC");

        long total = this.userDTOMapper.countByExample(example);
        page.setTotal(total);
        if (total > query.getOffset()) {
            List<UserDTO> list = this.userDTOMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
            page.setItems(BeanUtils.copyListProperties(list, UserResp.class));
        }
        return page;
    }

    @Override
    public UserResp getByTelephone(String telephone) {
        UserDTOExample example = new UserDTOExample();
        example.createCriteria().andTelephoneEqualTo(telephone);
        List<UserDTO> userDTOList = this.userDTOMapper.selectByExample(example);
        if (userDTOList.size() > 0) {
            UserDTO userDTO = userDTOList.get(0);
            UserResp userResp = BeanUtils.copyProperties(userDTO, UserResp.class);
            return userResp;
        }
        return null;
    }


    public void updatePassword(Long userId, UpdatePasswordReq param) throws ManagerUserException {
        //获取指定 ID 的用户信息
        UserResp user = this.getById(userId);
        if (user == null) {
            throw new ManagerUserException(com.sudao.cloud.component.user.manager.platform.base.result.ResultCode.UNAUTHORIZED);
        }
        String encrypt = PasswordCrypt.encrypt(param.getOldPassword());
        if (!user.getPassword().equals(encrypt)) {
            throw new ManagerUserException(com.sudao.cloud.component.user.manager.platform.base.result.ResultCode.USER_PASSWORD_ERROR);
        }

        UserReq userReq = BeanUtils.copyProperties(user, UserReq.class);
        //加密
        userReq.setPassword(PasswordCrypt.encrypt(param.getNewPassword()));
        this.update(userReq);
    }
}
