package com.sudao.cloud.component.user.manager.controller;

import com.sudao.cloud.component.user.manager.controller.vo.ManagerUserVo;
import com.sudao.cloud.component.user.manager.platform.base.crypt.AuthToken;
import com.sudao.cloud.component.user.manager.platform.common.cons.Constants;
import com.sudao.cloud.component.user.manager.platform.common.utils.BeanUtils;
import com.sudao.cloud.component.user.manager.service.ManagerUserService;
import com.sudao.cloud.component.user.manager.service.ManagerUserService.UpdatePassword;
import com.sudao.cloud.component.user.manager.service.ManagerUserService.ManagerUser;
import com.sudao.cloud.component.user.manager.service.MenuService;
import com.sudao.cloud.component.user.manager.service.UserRoleService;
import com.sudao.framework.controller.RestPrototypeController;
import com.sudao.cloud.component.user.manager.platform.base.controller.LocalBasicController;
import com.sudao.cloud.component.user.manager.platform.base.core.Session;
import com.sudao.cloud.component.user.manager.platform.base.crypt.PasswordCrypt;
import com.sudao.cloud.component.user.manager.platform.base.result.Page;
import com.sudao.cloud.component.user.manager.platform.base.result.Result;
import com.sudao.cloud.component.user.manager.platform.base.result.ResultCode;
import com.sudao.cloud.component.user.manager.platform.enums.Deleted;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestPrototypeController
@RequestMapping("/cloud/component/managerUser")
public class ManagerUserController extends LocalBasicController {

    @Autowired
    private ManagerUserService managerUserService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private UserRoleService userRoleService;

    @PostMapping("")
    public Map<String, Object> create(@RequestBody final ManagerUser obj) {
        Session session = getSession();
        obj.setOperator(session.getUserId());
        ManagerUser user = this.managerUserService.getByLoginName(obj.getLoginName());
        if (user != null) {
            this.logger.warn("登录名已存在: {}", obj.getLoginName());
            return resultMap(ResultCode.CONFLICT);
        }
        if (StringUtils.isBlank(obj.getPassword())) {
            //初始密码666666
            obj.setPassword("666666");
        }
        //加密
        obj.setPassword(PasswordCrypt.encrypt(obj.getPassword()));

        Long id = this.managerUserService.create(obj);

        if(CollectionUtils.isNotEmpty(obj.getRoleIds())){
            for (Long roleId:obj.getRoleIds()
                 ) {
                UserRoleService.UserRole userRole = new UserRoleService.UserRole();
                userRole.setUserId(id);
                userRole.setRoleId(roleId);
                userRole.setOperator(session.getUserId());
                userRoleService.create(userRole);
            }
        }

        return resultMap(ResultCode.OK, "ManagerUser_id", id);
    }

    @PostMapping("/newPassword")
    public Map<String,Object> updatePass(@RequestBody final  UpdatePassword updatePassword){

        if (updatePassword == null || updatePassword.getOldPassword() == null ||updatePassword.getNewPassword() == null) {
            return  resultMap(ResultCode.NULL_PARAMETER);
        }
        //当前登录的用户ID
        Long userId = getSessionQuietly().getUserId();
        if (userId == null || userId == 0) {
            return resultMap(ResultCode.UNAUTHORIZED);
        }

        //需要被修改密码的用户ID
        Long targetUserId = updatePassword.getUserId();
        if (targetUserId != null && targetUserId != 0) {
            userId = targetUserId;
        }
        //获取指定 ID 的用户信息
        ManagerUser user = managerUserService.getById(userId);
        if (user ==  null) {
            return resultMap(ResultCode.UNAUTHORIZED);
        }
        String encrypt = PasswordCrypt.encrypt(updatePassword.getOldPassword());
        if (! user.getPassword().equals(encrypt)) {
            return resultMap(ResultCode.USER_PASSWORD_ERROR);
        }
        user = new ManagerUser();
        user.setOperator(userId);
        user.setManagerUserId(userId);
        //加密
        user.setPassword(PasswordCrypt.encrypt(updatePassword.getNewPassword()));
        this.managerUserService.update(user);

        return resultMap(ResultCode.OK);

    }

    @PutMapping("/{id}")
    public Map<String, Object> update(
            @PathVariable("id") final Long id,
            @RequestBody final ManagerUser obj) {

        Session session = getSession();
        obj.setOperator(session.getUserId());
        ManagerUser user = this.managerUserService.getByLoginName(obj.getLoginName());
        if (user != null && id.longValue() !=  user.getManagerUserId().longValue()) {
            this.logger.warn("登录名已存在: {}", obj.getLoginName());
            return resultMap(ResultCode.CONFLICT);
        }
        if (StringUtils.isBlank(obj.getPassword())) {
            //初始密码666666
            obj.setPassword("666666");
        }
        obj.setManagerUserId(id);
        this.managerUserService.update(obj);

        //删除关联角色
        UserRoleService.UserRole ur = new UserRoleService.UserRole();
        ur.setUserId(id);
        userRoleService.deleteByObj(ur);

        if (CollectionUtils.isNotEmpty(obj.getRoleIds())) {
            for (Long roleId:obj.getRoleIds()) {
                 UserRoleService.UserRole userRole = new UserRoleService.UserRole();
                 userRole.setUserId(id);
                 userRole.setRoleId(roleId);
                 userRole.setOperator(session.getUserId());
                 userRoleService.create(userRole);
            }
        }
        return resultMap(ResultCode.OK);
    }


    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable("id") final Long id) {
        ManagerUser obj = new ManagerUser();
        obj.setDeleted(Deleted.DELETED);
        return update(id, obj);
    }

    @DeleteMapping("")
    public Map<String, Object> deleteMore(@RequestBody final List<Long> ids) {
    	if (!CollectionUtils.isEmpty(ids)) {
			for (Long id : ids) {
				delete(id);
			}
    	}
        return resultMap(ResultCode.OK);
    }

    @GetMapping("/{id}")
    public  Result<ManagerUser> get(@PathVariable("id") final Long id) {
        ManagerUser obj = this.managerUserService.getById(id);
        if (obj == null) {
            return  new Result<ManagerUser>(ResultCode.NOT_FOUND);
        }

        List<UserRoleService.UserRole> userRoles = userRoleService.findByUserId(id);
        if (CollectionUtils.isNotEmpty(userRoles)) {
            obj.setRoleIds(new ArrayList<Long>());
            for (UserRoleService.UserRole userRole:userRoles
                 ) {
                obj.getRoleIds().add(userRole.getRoleId());
            }
        }

        return  new Result<ManagerUser>(ResultCode.OK,obj);
    }

    @GetMapping("")
    public Result<Page<ManagerUser>> find(
              @RequestParam(value = "offset", required = false) Integer offset,
              @RequestParam(value = "limit", required = false) Integer limit,
              @RequestParam(value = "page", required = false) Integer pageNum
            ) {
		ManagerUserService.ManagerUserQuery query = new ManagerUserService.ManagerUserQuery();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
		
		Page<ManagerUser> page = managerUserService.find(query);
        return new Result<Page<ManagerUser>>(ResultCode.OK, page);
    }

    /**
     * 获取用户权限
     * @return
     */
    @GetMapping("/permissions")
    public Result<Map<String,Object>> findPermissions(@RequestParam(value = "userId", required = false) Long userId) {

        if (userId == null) {
            userId =  getSession().getUserId();
        }
        if (userId == null) {
            this.logger.warn("无效的用户信息");
            return new Result<Map<String,Object>>(ResultCode.UNAUTHORIZED, null);
        }
        Map<String,Object>  resultMpa = menuService.findPermissionsByUserId(userId);
        return new Result<Map<String,Object>>(ResultCode.OK,resultMpa );
    }

    /**
     * 获取通过token用户信息
     * @return
     */
    @GetMapping("/info")
    public Result<ManagerUserVo.SimpleUserInfo> findUserByToken(@RequestParam(value = "session_authToken", required = false) String token) {

        if (StringUtils.isBlank(token)) {
            token = request.getHeader(Constants.SESSION_AUTH_TOKEN);
        }
        if (StringUtils.isBlank(token)) {
            return new Result<ManagerUserVo.SimpleUserInfo>(ResultCode.AUTH_FAILED);
        }

        // parse AuthToken
        AuthToken authToken = AuthToken.parse(token);
        if (authToken == null) {
            return new Result<ManagerUserVo.SimpleUserInfo>(ResultCode.BAD_REQUEST);
        }

        ManagerUser user = managerUserService.getById(authToken.userId);

        ManagerUserVo.SimpleUserInfo userInfo = BeanUtils.copyProperties(user, ManagerUserVo.SimpleUserInfo.class);

        return new Result<ManagerUserVo.SimpleUserInfo>(ResultCode.OK,userInfo );

    }

    public static void main(String[] args) {
        System.out.println(PasswordCrypt.encrypt("111111"));
    }

}
