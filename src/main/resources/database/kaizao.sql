/*
 Navicat Premium Data Transfer

 Source Server         : location
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost:3306
 Source Schema         : kaizao

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 25/10/2017 22:16:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cloud_component_category
-- ----------------------------
DROP TABLE IF EXISTS `cloud_component_category`;
CREATE TABLE `cloud_component_category` (
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT '0' COMMENT '类别上级 默认为0',
  `name` varchar(200) DEFAULT NULL COMMENT '类目名',
  `code` varchar(200) DEFAULT NULL COMMENT '类目code',
  `description` varchar(500) DEFAULT NULL COMMENT '类目描述',
  `image` varchar(500) DEFAULT NULL COMMENT '类目图标',
  `keywords` varchar(1000) DEFAULT NULL COMMENT '关键字, 优化搜索项.\n请用; 分割',
  `display_order` int(11) DEFAULT '0' COMMENT '列表显示顺序',
  `version` int(11) NOT NULL DEFAULT '0',
  `deleted` int(11) NOT NULL DEFAULT '0' COMMENT '通用状态 Status: 1:正常, 2:已删除',
  `create_user_id` bigint(20) DEFAULT '0',
  `create_user_name` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user_id` bigint(20) DEFAULT '0',
  `update_user_name` varchar(100) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for cloud_component_collect_praise
-- ----------------------------
DROP TABLE IF EXISTS `cloud_component_collect_praise`;
CREATE TABLE `cloud_component_collect_praise` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户Id',
  `relation_id` bigint(20) NOT NULL COMMENT '关联ID',
  `relation_type` tinyint(1) DEFAULT '0' COMMENT '关联类型: 1:创意',
  `action_type` tinyint(1) DEFAULT '0' COMMENT '操作类型：1:点赞, 2:取消点赞, 3:添加收藏, 4:取消收藏',
  `display_order` int(11) DEFAULT '0' COMMENT '列表显示顺序',
  `version` int(11) NOT NULL DEFAULT '0',
  `deleted` int(11) NOT NULL DEFAULT '0' COMMENT '通用状态 Status: 1:正常, 2:已删除',
  `create_user_id` bigint(20) DEFAULT '0',
  `create_user_name` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user_id` bigint(20) DEFAULT '0',
  `update_user_name` varchar(100) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户收藏、点赞';

-- ----------------------------
-- Table structure for cloud_component_feedback
-- ----------------------------
DROP TABLE IF EXISTS `cloud_component_feedback`;
CREATE TABLE `cloud_component_feedback` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `feedback_username` varchar(50) DEFAULT NULL COMMENT '反馈人',
  `feedback_cellphone` varchar(20) DEFAULT NULL COMMENT '反馈人的手机号码',
  `read_status` tinyint(1) DEFAULT '0' COMMENT '阅读状态：1:未读, 2:已读',
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '反馈信息',
  `feedback_reply` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '反馈回复',
  `display_order` int(11) DEFAULT '0' COMMENT '列表显示顺序',
  `version` int(11) NOT NULL DEFAULT '0',
  `deleted` int(11) NOT NULL DEFAULT '0' COMMENT '通用状态 Status: 1:正常, 2:已删除',
  `create_user_id` bigint(20) DEFAULT '0',
  `create_user_name` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user_id` bigint(20) DEFAULT '0',
  `update_user_name` varchar(100) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='意见反馈表';

-- ----------------------------
-- Table structure for cloud_component_information
-- ----------------------------
DROP TABLE IF EXISTS `cloud_component_information`;
CREATE TABLE `cloud_component_information` (
  `information_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `type` varchar(100) NOT NULL COMMENT '字典类型',
  `type_desc` varchar(200) NOT NULL COMMENT '字典类型 描述',
  `value_code` varchar(100) NOT NULL COMMENT '字典值 code',
  `value_desc` varchar(200) NOT NULL COMMENT '字典值 描述',
  `display_order` int(11) DEFAULT '0' COMMENT '列表显示顺序',
  `version` int(11) NOT NULL DEFAULT '0',
  `deleted` int(11) NOT NULL DEFAULT '0' COMMENT '通用状态 Status: 1:正常, 2:已删除',
  `create_user_id` bigint(20) DEFAULT '0',
  `create_user_name` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user_id` bigint(20) DEFAULT '0',
  `update_user_name` varchar(100) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`information_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='数据字典\n 多行聚合类型设计方式, 以行冗余的方式描述字典项(type)所包含的值列表, 每条值(value_code)为一条数据';

-- ----------------------------
-- Table structure for cloud_component_report
-- ----------------------------
DROP TABLE IF EXISTS `cloud_component_report`;
CREATE TABLE `cloud_component_report` (
  `report_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `relation_id` bigint(20) NOT NULL COMMENT '关联ID',
  `relation_type` tinyint(1) DEFAULT '0' COMMENT '关联类型: 1:PLAN',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '上层举报项',
  `title` varchar(250) NOT NULL COMMENT '创意标题',
  `reason` varchar(500) NOT NULL COMMENT '举报理由',
  `report_version` varchar(45) NOT NULL COMMENT '举报迭代版本',
  `report_user_phone` varchar(20) DEFAULT NULL COMMENT '举报人手机号',
  `be_reported_name` varchar(100) DEFAULT NULL COMMENT '被举报人',
  `process_status` varchar(20) DEFAULT '0' COMMENT '处理状态, UN_PROCESS-待处理，PROCESSED-已处理, REBACK-驳回',
  `display_order` int(11) DEFAULT '0' COMMENT '列表显示顺序',
  `version` int(11) NOT NULL DEFAULT '0',
  `deleted` int(11) NOT NULL DEFAULT '0' COMMENT '通用状态 Status: 1:正常, 2:已删除',
  `create_user_id` bigint(20) DEFAULT '0',
  `create_user_name` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user_id` bigint(20) DEFAULT '0',
  `update_user_name` varchar(100) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`report_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='创意举报';

-- ----------------------------
-- Table structure for cloud_component_user
-- ----------------------------
DROP TABLE IF EXISTS `cloud_component_user`;
CREATE TABLE `cloud_component_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `nike_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `gender` int(2) DEFAULT NULL COMMENT '0.保密,1:男,2:女',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `telephone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `image` varchar(500) DEFAULT NULL COMMENT '头像',
  `profession` varchar(100) DEFAULT NULL COMMENT '职业',
  `display_order` int(11) DEFAULT '0' COMMENT '列表显示顺序',
  `version` int(11) NOT NULL DEFAULT '0',
  `deleted` int(11) NOT NULL DEFAULT '0' COMMENT '通用状态 Status: 1:正常, 2:已删除',
  `create_user_id` bigint(20) DEFAULT '0',
  `create_user_name` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user_id` bigint(20) DEFAULT '0',
  `update_user_name` varchar(100) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for kz_idea
-- ----------------------------
DROP TABLE IF EXISTS `kz_idea`;
CREATE TABLE `kz_idea` (
  `idea_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `owner_id` bigint(20) NOT NULL COMMENT '发起人ID',
  `owner_name` varchar(250) NOT NULL COMMENT '发起人姓名',
  `category_id` bigint(20) NOT NULL COMMENT '类别ID',
  `category_name` varchar(250) NOT NULL COMMENT '类别名',
  `idea_type` tinyint(1) DEFAULT '0' COMMENT '类型：1:创意, 2:产品案例',
  `title` varchar(250) NOT NULL COMMENT '标题',
  `description` varchar(2000) DEFAULT NULL COMMENT '描述',
  `cover_image` varchar(1000) NOT NULL COMMENT '封面',
  `current_version` varchar(45) NOT NULL COMMENT '当前版本',
  `audit` tinyint(1) NOT NULL DEFAULT '0' COMMENT '审核是否通过 1通过, 2:未通过',
  `audit_plan_id` bigint(20) DEFAULT NULL COMMENT '审核通过的',
  `audit_user_id` bigint(20) DEFAULT NULL COMMENT '审核人ID',
  `audit_user_name` varchar(250) DEFAULT NULL COMMENT '审核人名',
  `audit_time` bigint(20) DEFAULT '0' COMMENT '审核时间',
  `praise_number` int(11) DEFAULT '0' COMMENT '点赞数',
  `display_order` int(11) DEFAULT '0' COMMENT '列表显示顺序',
  `version` int(11) NOT NULL DEFAULT '0',
  `deleted` int(11) NOT NULL DEFAULT '0' COMMENT '通用状态 Status: 1:正常, 2:已删除',
  `create_user_id` bigint(20) DEFAULT '0',
  `create_user_name` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user_id` bigint(20) DEFAULT '0',
  `update_user_name` varchar(100) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for kz_plan
-- ----------------------------
DROP TABLE IF EXISTS `kz_plan`;
CREATE TABLE `kz_plan` (
  `plan_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `idea_id` bigint(20) NOT NULL,
  `owner_id` bigint(20) NOT NULL COMMENT '发起人ID',
  `owner_name` varchar(250) NOT NULL COMMENT '发起人姓名',
  `category_id` bigint(20) NOT NULL COMMENT '类别ID',
  `category_name` varchar(250) NOT NULL COMMENT '类别名',
  `title` varchar(250) NOT NULL COMMENT '标题',
  `description` varchar(2000) DEFAULT NULL COMMENT '描述',
  `cover_image` varchar(1000) NOT NULL COMMENT '封面',
  `plan_version` varchar(45) NOT NULL COMMENT '版本',
  `is_origin` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否是idea首个plan\n\n0 为 false, 1 为 true',
  `iteration_description` varchar(2000) DEFAULT NULL COMMENT '迭代理由',
  `audit` bit(1) NOT NULL DEFAULT b'0' COMMENT '审核是否通过 1通过, 2:未通过',
  `audit_user_id` bigint(20) DEFAULT NULL COMMENT '审核人ID',
  `audit_user_name` varchar(250) DEFAULT NULL COMMENT '审核人名',
  `audit_time` datetime DEFAULT NULL COMMENT '审核时间',
  `praise_number` int(11) DEFAULT '0' COMMENT '点赞数',
  `display_order` int(11) DEFAULT '0' COMMENT '列表显示顺序',
  `version` int(11) NOT NULL DEFAULT '0',
  `deleted` int(11) NOT NULL DEFAULT '0' COMMENT '通用状态 Status: 1:正常, 2:已删除',
  `create_user_id` bigint(20) DEFAULT '0',
  `create_user_name` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user_id` bigint(20) DEFAULT '0',
  `update_user_name` varchar(100) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`plan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for kz_plan_context
-- ----------------------------
DROP TABLE IF EXISTS `kz_plan_context`;
CREATE TABLE `kz_plan_context` (
  `context_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `plan_id` bigint(20) NOT NULL COMMENT '方案ID',
  `context_type` varchar(45) NOT NULL COMMENT '内容类型：1:IMAGE 图片, 2:TEXT 文本 3:GRAFFTI 涂鸦 4:VIDEO 视频',
  `value` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '内容\n如果非TEXT 类型, 则为相对路径',
  `display_order` int(11) DEFAULT '0' COMMENT '列表显示顺序',
  `version` int(11) NOT NULL DEFAULT '0',
  `deleted` int(11) NOT NULL DEFAULT '0' COMMENT '通用状态 Status: 1:正常, 2:已删除',
  `create_user_id` bigint(20) DEFAULT '0',
  `create_user_name` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user_id` bigint(20) DEFAULT '0',
  `update_user_name` varchar(100) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`context_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for kz_user_idea_statistics
-- ----------------------------
DROP TABLE IF EXISTS `kz_user_idea_statistics`;
CREATE TABLE `kz_user_idea_statistics` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `published_idea_number` int(11) DEFAULT '0' COMMENT '已发布创意数',
  `participant_idea_number` int(11) DEFAULT '0' COMMENT '参与的创意数',
  `reported_idea_number` int(11) DEFAULT '0' COMMENT '被举报的创意数',
  `display_order` int(11) DEFAULT '0' COMMENT '列表显示顺序',
  `version` int(11) NOT NULL DEFAULT '0',
  `deleted` int(11) NOT NULL DEFAULT '0' COMMENT '通用状态 Status: 1:正常, 2:已删除',
  `create_user_id` bigint(20) DEFAULT '0',
  `create_user_name` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user_id` bigint(20) DEFAULT '0',
  `update_user_name` varchar(100) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户创意统计';


DROP TABLE IF EXISTS `kz_article`;
CREATE TABLE `kz_article` (
  `article_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文章主键',
  `article_title` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文章标题',
  `article_code` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文章编码',
  `article_content` text COLLATE utf8mb4_unicode_ci COMMENT '文章内容',
  `remark` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '描述',
  `display_order` int(11) DEFAULT '0' COMMENT '列表显示顺序',
  `version` int(11) NOT NULL DEFAULT '0',
  `deleted` int(11) NOT NULL DEFAULT '0' COMMENT '通用状态 Status: 1:正常, 2:已删除',
  `create_user_id` bigint(20) DEFAULT '0',
  `create_user_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user_id` bigint(20) DEFAULT '0',
  `update_user_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='平台文章表';

SET FOREIGN_KEY_CHECKS = 1;
