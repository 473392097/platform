
## 初始化数据
/*
Navicat MySQL Data Transfer

Source Server         : 172.19.71.10_3306
Source Server Version : 50636
Source Host           : 172.19.71.10:3306
Source Database       : sudao_platform

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2017-08-30 17:09:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for platform_manager_user
-- ----------------------------
DROP TABLE IF EXISTS `platform_manager_user`;
CREATE TABLE `platform_manager_user` (
  `manager_user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `login_name` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `user_name` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `password` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `gender` int(2) DEFAULT NULL COMMENT '0.保密,1:男,2:女',
  `email` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `telephone` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `remark` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  `display_order` int(11) DEFAULT '1' COMMENT '列表显示顺序',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `status` int(1) DEFAULT '1' COMMENT '1:激活,0:冻结',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `deleted` int(1) DEFAULT '1' COMMENT '1:正常,0:删除(默认1)',
  PRIMARY KEY (`manager_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='平台后台用户表';

-- ----------------------------
-- Table structure for platform_menu
-- ----------------------------


DROP TABLE IF EXISTS `platform_menu`;
CREATE TABLE `platform_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '菜单名称',
  `code` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '菜单标识',
  `menu_type` int(1) DEFAULT NULL COMMENT '菜单类型0:菜单,1:功能',
  `remark` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '菜单描述',
  `url` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '路径',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父权限编号',
  `display_order` int(11) DEFAULT '1' COMMENT '列表显示顺序',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `status` int(1) DEFAULT '1' COMMENT '1:激活,0:冻结',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `deleted` int(1) DEFAULT '1' COMMENT '1:正常,0:删除(默认1)',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='平台菜单表';

-- ----------------------------
-- Table structure for platform_role
-- ----------------------------
DROP TABLE IF EXISTS `platform_role`;
CREATE TABLE `platform_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色名称',
  `code` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色标识',
  `remark` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色描述',
  `display_order` int(11) DEFAULT '1' COMMENT '列表显示顺序',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `status` int(11) DEFAULT '1' COMMENT '1:激活,0:冻结(默认1)',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `deleted` int(1) DEFAULT '1' COMMENT '1:正常,0:删除(默认1)',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='平台角色表';

-- ----------------------------
-- Table structure for platform_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `platform_role_menu`;
CREATE TABLE `platform_role_menu` (
  `role_menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单id',
  `display_order` int(11) DEFAULT '1' COMMENT '列表显示顺序',
  `remark` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `status` int(1) DEFAULT '1' COMMENT '1:激活,0:冻结',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `deleted` int(1) DEFAULT '1' COMMENT '1:正常,0:删除(默认1)',
  PRIMARY KEY (`role_menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='平台角色权限关系表';

-- ----------------------------
-- Table structure for platform_user_role
-- ----------------------------
DROP TABLE IF EXISTS `platform_user_role`;
CREATE TABLE `platform_user_role` (
  `user_role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  `display_order` int(11) DEFAULT '1' COMMENT '列表显示顺序',
  `remark` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `status` int(1) DEFAULT '1' COMMENT '1:激活,0:冻结',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `deleted` int(1) DEFAULT '1' COMMENT '1:正常,0:删除(默认1)',
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='平台用户角色关系表';



-- 初始化超级用户、角色、菜单
INSERT INTO platform_manager_user (manager_user_id, login_name, user_name, password, gender, email, telephone, remark, display_order, version, status, create_by, create_time, update_by, update_time, last_update, deleted) VALUES ('-1', 'admin', 'admin', '8895d5a664f3d5fb1f0bd6523abc1b4a', '1', 'admin@qq.com', '15821820391', 'admin', '1', '1', '1', NULL, now(), NULL,now(), now(), '1');

INSERT INTO platform_role (role_id, name, code, remark, display_order, version, status, create_by, create_time, update_by, update_time, last_update, deleted) VALUES ('-1', '超级管理员', 'super_admin', '可以访问全系统的任何功能', '1', '1', '1', NULL, now(), NULL, now(), now(), '1');

INSERT INTO platform_user_role (user_role_id, user_id, role_id, display_order, remark, version, status, create_by, create_time, update_by, update_time, last_update, deleted) VALUES ('-1', '-1', '-1', '1', NULL, '1', '1', NULL, now(), NULL, now(), now(), '1');

INSERT INTO platform_menu (menu_id, name, code, menu_type, remark, url, parent_id, display_order, version, status, create_by, create_time, update_by, update_time, last_update, deleted) VALUES ('-1', '系统管理', 'system', '0', '系统管理', NULL, '0', '1', '1', '1', NULL, now(), NULL, now(),now(), '1');
INSERT INTO platform_menu (menu_id, name, code, menu_type, remark, url, parent_id, display_order, version, status, create_by, create_time, update_by, update_time, last_update, deleted) VALUES ('-11', '菜单管理', 'menu', '0', '菜单管理', '/platfrom/menu', '-1', '1', '1', '1', NULL,now(), NULL, now(), now(), '1');
INSERT INTO platform_menu (menu_id, name, code, menu_type, remark, url, parent_id, display_order, version, status, create_by, create_time, update_by, update_time, last_update, deleted) VALUES ('-12', '角色管理', 'root', '0', '角色管理', '/platfrom/role', '-1', '1', '1', '1', NULL, now(), NULL, now(), now(), '1');
INSERT INTO platform_menu (menu_id, name, code, menu_type, remark, url, parent_id, display_order, version, status, create_by, create_time, update_by, update_time, last_update, deleted) VALUES ('-13', '用户管理', 'managerUser', '0', '用户管理', '/platfrom/managerUser', '-1', '1', '1', '1', NULL, now(), NULL, now(),now(), '1');

INSERT INTO platform_menu (menu_id, name, code, menu_type, remark, url, parent_id, display_order, version, status, create_by, create_time, update_by, update_time, last_update, deleted) VALUES ('-111', '新增菜单', 'addMenu', '1', '新增菜单', '/platform/menu', '-11', '1', '1', '1', NULL, now(), NULL, now(), now(), '1');
INSERT INTO platform_menu (menu_id, name, code, menu_type, remark, url, parent_id, display_order, version, status, create_by, create_time, update_by, update_time, last_update, deleted) VALUES ('-112', '修改菜单', 'updateMenu', '1', '修改菜单', '/platform/menu', '-11', '1', '1', '1', NULL, now(), NULL, now(),now(), '1');
INSERT INTO platform_menu (menu_id, name, code, menu_type, remark, url, parent_id, display_order, version, status, create_by, create_time, update_by, update_time, last_update, deleted) VALUES ('-113', '删除菜单', 'deleteMenu', '1', '删除菜单', '/platform/menu', '-11', '1', '1', '1', NULL, now(), NULL, now(), now(), '1');

INSERT INTO platform_role_menu (role_menu_id, role_id, menu_id, display_order, remark, version, status, create_by, create_time, update_by, update_time, last_update, deleted) VALUES ('-1', '-1', '-1', '1', NULL, '1', '1', NULL, now(), NULL, now(), now(), '1');
INSERT INTO platform_role_menu (role_menu_id, role_id, menu_id, display_order, remark, version, status, create_by, create_time, update_by, update_time, last_update, deleted) VALUES ('-2', '-1', '-11', '1', NULL, '1', '1', NULL, now(), NULL, now(), now(), '1');
INSERT INTO platform_role_menu (role_menu_id, role_id, menu_id, display_order, remark, version, status, create_by, create_time, update_by, update_time, last_update, deleted) VALUES ('-3', '-1', '-12', '1', NULL, '1', '1', NULL, now(), NULL, now(), now(), '1');
INSERT INTO platform_role_menu (role_menu_id, role_id, menu_id, display_order, remark, version, status, create_by, create_time, update_by, update_time, last_update, deleted) VALUES ('-4', '-1', '-13', '1', NULL, '1', '1', NULL, now(), NULL, now(), now(), '1');
INSERT INTO platform_role_menu (role_menu_id, role_id, menu_id, display_order, remark, version, status, create_by, create_time, update_by, update_time, last_update, deleted) VALUES ('-5', '-1', '-14', '1', NULL, '1', '1', NULL, now(), NULL, now(), now(), '1');
INSERT INTO platform_role_menu (role_menu_id, role_id, menu_id, display_order, remark, version, status, create_by, create_time, update_by, update_time, last_update, deleted) VALUES ('-6', '-1', '-111', '1', NULL, '1', '1', NULL, now(), NULL, now(), now(), '1');
INSERT INTO platform_role_menu (role_menu_id, role_id, menu_id, display_order, remark, version, status, create_by, create_time, update_by, update_time, last_update, deleted) VALUES ('-7', '-1', '-112', '1', NULL, '1', '1', NULL, now(), NULL, now(), now(), '1');
INSERT INTO platform_role_menu (role_menu_id, role_id, menu_id, display_order, remark, version, status, create_by, create_time, update_by, update_time, last_update, deleted) VALUES ('-8', '-1', '-113', '1', NULL, '1', '1', NULL, now(), NULL, now(), now(), '1');
