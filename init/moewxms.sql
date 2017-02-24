/*
Navicat MySQL Data Transfer

Source Server         : 192.168.12.106
Source Server Version : 50516
Source Host           : 192.168.12.106:3306
Source Database       : moewxms

Target Server Type    : MYSQL
Target Server Version : 50516
File Encoding         : 65001

Date: 2017-02-24 18:19:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for qx_department
-- ----------------------------
DROP TABLE IF EXISTS `qx_department`;
CREATE TABLE `qx_department` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `parent_did` int(11) NOT NULL COMMENT '父级编号',
  `parent_dids` varchar(255) NOT NULL DEFAULT '' COMMENT '所有父级编号',
  `dname` varchar(255) NOT NULL COMMENT '部门名称',
  `manager` varchar(100) DEFAULT NULL COMMENT '负责人',
  `sort` int(11) NOT NULL DEFAULT '30' COMMENT '排序',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `del_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0:正常1:删除）',
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=20004 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qx_department
-- ----------------------------
INSERT INTO `qx_department` VALUES ('10001', '0', '0', '软信公司', 'LQ', '30', '1', '2016-12-13 17:13:16', '', '0');
INSERT INTO `qx_department` VALUES ('10002', '10001', '0,10001', '开发部', 'LQ', '30', '1', '2016-12-08 15:51:48', '', '0');
INSERT INTO `qx_department` VALUES ('10003', '10001', '0,10001', '市场部', 'LQ', '30', '1', '2016-12-08 15:53:12', '', '0');
INSERT INTO `qx_department` VALUES ('10004', '10001', '0,10001', '产品部', 'LQ', '30', '1', '2016-12-13 16:12:53', '', '0');
INSERT INTO `qx_department` VALUES ('10008', '10001', '0,10001', '综合部', '张三', '50', '1', '2016-12-16 17:46:13', 'fff', '0');
INSERT INTO `qx_department` VALUES ('20001', '10001', '0,10001', '财务部', 'aaa', '30', '1', '2017-01-17 10:41:21', 'gbgbg', '1');
INSERT INTO `qx_department` VALUES ('20002', '10001', '0,10001', 'CDC', 'aaa', '30', '1', '2017-01-17 17:04:38', '', '1');
INSERT INTO `qx_department` VALUES ('20003', '10001', '0,10001', '经营部', 'IJIJ', '30', '1', '2017-02-15 17:20:22', '', '1');

-- ----------------------------
-- Table structure for qx_menu
-- ----------------------------
DROP TABLE IF EXISTS `qx_menu`;
CREATE TABLE `qx_menu` (
  `menuid` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NOT NULL,
  `parent_ids` varchar(255) NOT NULL,
  `mname` varchar(255) NOT NULL,
  `sort` tinyint(4) NOT NULL DEFAULT '30' COMMENT '排序',
  `href` varchar(255) NOT NULL DEFAULT '' COMMENT '链接',
  `icon` varchar(255) DEFAULT '' COMMENT '图标',
  `mtype` tinyint(4) DEFAULT '0' COMMENT '菜单类型(0菜单1按钮)',
  `create_by` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `del_flag` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`menuid`)
) ENGINE=InnoDB AUTO_INCREMENT=10023 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qx_menu
-- ----------------------------
INSERT INTO `qx_menu` VALUES ('10001', '0', '0', '顶级菜单', '30', '', '', '10', null, null, null, '0');
INSERT INTO `qx_menu` VALUES ('10002', '10001', '0,10001', '系统设置', '20', '', '', '0', null, null, '', '0');
INSERT INTO `qx_menu` VALUES ('10003', '10002', '0,10001,10002', '用户中心', '31', '', '', '0', null, null, '', '0');
INSERT INTO `qx_menu` VALUES ('10004', '10002', '0,10001,10002', '角色管理', '30', '/sys/role/list', '', '0', null, null, null, '0');
INSERT INTO `qx_menu` VALUES ('10008', '10002', '0,10001,10002', '组织机构', '30', '/sys/department/list', '', '0', '1', '2016-12-19 17:31:27', '', '0');
INSERT INTO `qx_menu` VALUES ('10009', '10002', '0,10001,10002', '菜单管理', '30', '/sys/menu/list', '', '0', '1', '2016-12-19 17:33:29', '', '0');
INSERT INTO `qx_menu` VALUES ('10011', '10003', '0,10001,10002,10003', '用户管理', '30', '/sys/user/list', '', '0', '1', '2016-12-27 14:45:52', '', '0');
INSERT INTO `qx_menu` VALUES ('10012', '10003', '0,10001,10002,10003', '密码重置', '30', '/sys/user/pwform', '', '0', '1', '2016-12-27 14:46:21', '', '0');
INSERT INTO `qx_menu` VALUES ('10013', '10011', '0,10001,10002,10003,10011', '添加/修改', '30', '/sys/user/form', '', '1', '1', '2016-12-28 09:28:12', '', '0');
INSERT INTO `qx_menu` VALUES ('10014', '10004', '0,10001,10002,10004', '添加/修改', '30', '/sys/role/form', '', '1', '1', '2016-12-28 09:34:39', '', '0');
INSERT INTO `qx_menu` VALUES ('10015', '10008', '0,10001,10002,10008', '添加/修改', '30', '/sys/department/form', '', '1', '1', '2016-12-28 09:35:00', '', '0');
INSERT INTO `qx_menu` VALUES ('10016', '10009', '0,10001,10002,10009', '添加/修改', '30', '/sys/menu/form', '', '1', '1', '2016-12-28 09:35:13', '', '0');
INSERT INTO `qx_menu` VALUES ('10017', '10004', '0,10001,10002,10004', '功能授权', '30', '/sys/role/grantform', '', '1', '1', '2016-12-28 16:48:27', '', '0');
INSERT INTO `qx_menu` VALUES ('10018', '10001', '0,10001', '测试网站', '30', 'http://www.hnsi.cn', '', '0', '1', '2017-02-15 17:21:34', '', '1');
INSERT INTO `qx_menu` VALUES ('10019', '10001', '0,10001', '微信管理', '30', '/weixin/index/', '', '0', '1', '2017-02-21 17:41:58', '', '0');
INSERT INTO `qx_menu` VALUES ('10020', '10019', '0,10001,10019', '公众号管理', '30', '/weixin/index/list', '', '0', '1', '2017-02-21 17:43:06', '', '0');
INSERT INTO `qx_menu` VALUES ('10021', '10020', '0,10001,10019,10020', '添加/修改', '30', '/weixin/index/form', '', '1', '1', '2017-02-21 17:44:34', '', '0');
INSERT INTO `qx_menu` VALUES ('10022', '10019', '0,10001,10019', '素材管理', '30', '/weixin/material/', '', '0', '1', '2017-02-23 17:10:27', '', '0');

-- ----------------------------
-- Table structure for qx_role
-- ----------------------------
DROP TABLE IF EXISTS `qx_role`;
CREATE TABLE `qx_role` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(255) NOT NULL COMMENT '角色名称',
  `role_type` varchar(255) DEFAULT '' COMMENT '角色类型',
  `create_by` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `del_flag` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qx_role
-- ----------------------------
INSERT INTO `qx_role` VALUES ('1', '超级管理员', 'global', '1', '2016-12-08 16:00:22', 'ddd', '0');
INSERT INTO `qx_role` VALUES ('2', '普通用户', '', '1', '2016-12-12 10:11:27', 'zxc', '0');
INSERT INTO `qx_role` VALUES ('3', '微信管理员', '', '1', '2016-12-28 18:06:45', '', '0');

-- ----------------------------
-- Table structure for qx_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `qx_role_menu`;
CREATE TABLE `qx_role_menu` (
  `rmid` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  PRIMARY KEY (`rmid`),
  KEY `rid_mid1` (`role_id`),
  KEY `rid_mid2` (`menu_id`),
  CONSTRAINT `qx_role_menu_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `qx_role` (`roleid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `qx_role_menu_ibfk_2` FOREIGN KEY (`menu_id`) REFERENCES `qx_menu` (`menuid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qx_role_menu
-- ----------------------------
INSERT INTO `qx_role_menu` VALUES ('41', '2', '10015');
INSERT INTO `qx_role_menu` VALUES ('42', '2', '10008');
INSERT INTO `qx_role_menu` VALUES ('43', '2', '10012');
INSERT INTO `qx_role_menu` VALUES ('44', '2', '10003');
INSERT INTO `qx_role_menu` VALUES ('45', '2', '10002');
INSERT INTO `qx_role_menu` VALUES ('46', '2', '10001');
INSERT INTO `qx_role_menu` VALUES ('87', '3', '10012');
INSERT INTO `qx_role_menu` VALUES ('88', '3', '10013');
INSERT INTO `qx_role_menu` VALUES ('89', '3', '10011');
INSERT INTO `qx_role_menu` VALUES ('90', '3', '10003');
INSERT INTO `qx_role_menu` VALUES ('91', '3', '10002');
INSERT INTO `qx_role_menu` VALUES ('92', '3', '10001');

-- ----------------------------
-- Table structure for qx_user
-- ----------------------------
DROP TABLE IF EXISTS `qx_user`;
CREATE TABLE `qx_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(100) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nickname` varchar(100) DEFAULT '' COMMENT '昵称',
  `turename` varchar(100) DEFAULT '',
  `did` int(11) DEFAULT NULL COMMENT '部门编号',
  `gender` enum('女','男') DEFAULT '男',
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(50) DEFAULT '' COMMENT '手机号',
  `registerdate` datetime DEFAULT NULL,
  `logindate` datetime DEFAULT NULL,
  `status` tinyint(255) DEFAULT '1' COMMENT '状态（1正常0冻结）',
  `headphoto` varchar(255) DEFAULT '',
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `username` (`login_name`),
  KEY `uid_did` (`did`),
  CONSTRAINT `qx_user_ibfk_1` FOREIGN KEY (`did`) REFERENCES `qx_department` (`did`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qx_user
-- ----------------------------
INSERT INTO `qx_user` VALUES ('1', 'admin', 'ad20a56c5c52a265756c0fef3c3c6734abc82966663146cd4a44e710', 'O零壹O', '零壹', '10001', '男', 'qqqm@qq.com', '', '2016-11-23 09:24:36', '2017-02-24 17:54:46', '1', '/upload/headphoto/1_1486543051623.jpg', 'vvvvvvvvv');
INSERT INTO `qx_user` VALUES ('2', 'cs123', '9d5afcecb08de742e4e7734cecc199abaf4c867ec9bfa6041dce8817', 'DCDC', 'DCDC', '10002', '男', 'dasd', '', '2016-12-20 17:55:43', '2016-12-21 15:08:06', '0', '', 'dfff');
INSERT INTO `qx_user` VALUES ('3', 'cacac', '399e334c4bb21a960c5174d814381471d51ade929d3209e39a6f3067', 'ddd', 'ddd', '10004', '男', 'fas@qq.com', '', '2016-12-27 16:19:28', null, '0', '', 'fff');
INSERT INTO `qx_user` VALUES ('4', 'think0016', '95a73f98cbc5a4f81c872616462ffdca11404afa4174b5070aca5498', '王伟', '王伟', '10001', '男', 'asdasd@qq.com', '', '2016-12-28 15:28:26', '2016-12-28 16:50:20', '1', '', 'tt');
INSERT INTO `qx_user` VALUES ('5', 'think0017', '7596e23357513af73fbf98412f27ea88f7bb088414ed7e4757294278', '刘伟', '刘伟', '10002', '女', '5656@q.com', '', '2016-12-28 17:06:04', '2017-02-06 10:55:55', '1', '', '');
INSERT INTO `qx_user` VALUES ('6', 'think0018', 'a6f0470358a3d88c8afaf5710bd9b918a851e276ba2b56d32a074770', '慕容垂', '慕容垂', '10001', '女', 'eqwe@qq.com', '', '2016-12-28 18:02:11', '2017-01-18 10:58:46', '1', '', '');
INSERT INTO `qx_user` VALUES ('10', 'think0019', '558dd8279820aca84852acf3e15b4dbb11fd31a603afc225180ecb3f', 'Miss', '', '10001', '女', 'asdasd@qq.com', '', '2017-01-13 09:47:49', '2017-01-18 10:47:23', '0', '', 'ffffff');

-- ----------------------------
-- Table structure for qx_user_role
-- ----------------------------
DROP TABLE IF EXISTS `qx_user_role`;
CREATE TABLE `qx_user_role` (
  `urid` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`urid`),
  KEY `uid_rid1` (`user_id`),
  KEY `uid_rid2` (`role_id`),
  CONSTRAINT `qx_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `qx_user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `qx_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `qx_role` (`roleid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qx_user_role
-- ----------------------------
INSERT INTO `qx_user_role` VALUES ('11', '1', '1');
INSERT INTO `qx_user_role` VALUES ('13', '3', '2');
INSERT INTO `qx_user_role` VALUES ('15', '2', '2');
INSERT INTO `qx_user_role` VALUES ('17', '5', '2');
INSERT INTO `qx_user_role` VALUES ('19', '4', '3');
INSERT INTO `qx_user_role` VALUES ('29', '10', '3');

-- ----------------------------
-- Table structure for wx_attachment
-- ----------------------------
DROP TABLE IF EXISTS `wx_attachment`;
CREATE TABLE `wx_attachment` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `filename` varchar(255) DEFAULT NULL COMMENT '上传文件名',
  `path` varchar(255) DEFAULT NULL COMMENT '路径',
  `ext` varchar(50) DEFAULT NULL COMMENT '扩展名',
  `is_del` int(10) DEFAULT '0' COMMENT '删除标记',
  `manager_id` int(10) DEFAULT NULL COMMENT '创建id',
  `createdate` datetime DEFAULT NULL COMMENT '上传时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wx_attachment
-- ----------------------------

-- ----------------------------
-- Table structure for wx_auto_reply
-- ----------------------------
DROP TABLE IF EXISTS `wx_auto_reply`;
CREATE TABLE `wx_auto_reply` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `keyword` varchar(255) DEFAULT NULL COMMENT '关键词',
  `msg_type` char(50) DEFAULT 'text' COMMENT '消息类型',
  `content` text COMMENT '文本内容',
  `group_id` int(10) DEFAULT NULL COMMENT '图文',
  `image_id` int(10) unsigned DEFAULT NULL COMMENT '上传图片',
  `manager_id` int(10) DEFAULT NULL COMMENT '管理员ID',
  `token` varchar(50) DEFAULT NULL COMMENT 'Token',
  `image_material` int(10) DEFAULT NULL COMMENT '素材图片id',
  `voice_id` int(10) DEFAULT NULL COMMENT '语音素材id',
  `video_id` int(10) DEFAULT NULL COMMENT '视频素材id',
  PRIMARY KEY (`id`),
  KEY `wx_auto_reply_f1` (`token`),
  CONSTRAINT `wx_auto_reply_f1` FOREIGN KEY (`token`) REFERENCES `wx_public` (`token`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wx_auto_reply
-- ----------------------------

-- ----------------------------
-- Table structure for wx_custom_menu
-- ----------------------------
DROP TABLE IF EXISTS `wx_custom_menu`;
CREATE TABLE `wx_custom_menu` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `url` varchar(255) DEFAULT NULL COMMENT '关联URL',
  `keyword` varchar(100) DEFAULT NULL COMMENT '关联关键词',
  `title` varchar(50) NOT NULL COMMENT '菜单名',
  `pid` int(10) DEFAULT '0' COMMENT '一级菜单',
  `sort` tinyint(4) DEFAULT '0' COMMENT '排序号',
  `token` varchar(255) DEFAULT NULL COMMENT 'Token',
  `type` varchar(30) DEFAULT 'click' COMMENT '类型',
  PRIMARY KEY (`id`),
  KEY `wx_custom_menu_f1` (`token`),
  CONSTRAINT `wx_custom_menu_f1` FOREIGN KEY (`token`) REFERENCES `wx_public` (`token`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wx_custom_menu
-- ----------------------------

-- ----------------------------
-- Table structure for wx_keyword
-- ----------------------------
DROP TABLE IF EXISTS `wx_keyword`;
CREATE TABLE `wx_keyword` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `keyword` varchar(100) NOT NULL COMMENT '关键词',
  `token` varchar(100) DEFAULT NULL COMMENT 'Token',
  `addon` varchar(255) NOT NULL COMMENT '关键词所属模块(可选)',
  `aim_id` int(10) unsigned NOT NULL COMMENT '模块表里的ID值(可选)',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  `keyword_length` int(10) unsigned DEFAULT '0' COMMENT '关键词长度',
  `keyword_type` tinyint(2) DEFAULT '0' COMMENT '匹配类型(精确、模糊)',
  `request_count` int(10) DEFAULT '0' COMMENT '请求数',
  PRIMARY KEY (`id`),
  KEY `keyword_token` (`keyword`,`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wx_keyword
-- ----------------------------

-- ----------------------------
-- Table structure for wx_material_file
-- ----------------------------
DROP TABLE IF EXISTS `wx_material_file`;
CREATE TABLE `wx_material_file` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `mname` varchar(255) DEFAULT '' COMMENT '素材名称',
  `file_id` int(10) DEFAULT NULL COMMENT '上传文件附件id',
  `cover_url` varchar(255) DEFAULT NULL COMMENT '本地URL',
  `media_id` varchar(100) DEFAULT '0' COMMENT '微信端图文消息素材的media_id',
  `wechat_url` varchar(255) DEFAULT NULL COMMENT '微信端的文件地址',
  `manager_id` int(10) DEFAULT NULL COMMENT '管理员ID',
  `token` varchar(100) DEFAULT NULL COMMENT 'Token',
  `title` varchar(100) DEFAULT NULL COMMENT '素材名称',
  `type` int(10) DEFAULT '0' COMMENT '类型(0:音频；1:视频)',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  `introduction` text COMMENT '描述',
  `is_use` int(10) DEFAULT '1' COMMENT '可否使用',
  PRIMARY KEY (`id`),
  KEY `wx_material_file_f1` (`token`),
  CONSTRAINT `wx_material_file_f1` FOREIGN KEY (`token`) REFERENCES `wx_public` (`token`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wx_material_file
-- ----------------------------

-- ----------------------------
-- Table structure for wx_material_image
-- ----------------------------
DROP TABLE IF EXISTS `wx_material_image`;
CREATE TABLE `wx_material_image` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `mname` varchar(255) DEFAULT '' COMMENT '素材名称',
  `cover_id` int(10) DEFAULT NULL COMMENT '图片在本地的ID',
  `cover_url` varchar(255) DEFAULT NULL COMMENT '本地URL',
  `media_id` varchar(100) DEFAULT '0' COMMENT '微信端图文消息素材的media_id',
  `wechat_url` varchar(255) DEFAULT NULL COMMENT '微信端的图片地址',
  `manager_id` int(10) DEFAULT NULL COMMENT '管理员ID',
  `createdate` datetime DEFAULT NULL COMMENT '上传时间',
  `token` varchar(100) DEFAULT NULL COMMENT 'Token',
  `is_use` int(10) DEFAULT '1' COMMENT '可否使用',
  PRIMARY KEY (`id`),
  KEY `wx_material_image_f1` (`token`),
  CONSTRAINT `wx_material_image_f1` FOREIGN KEY (`token`) REFERENCES `wx_public` (`token`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wx_material_image
-- ----------------------------

-- ----------------------------
-- Table structure for wx_material_news
-- ----------------------------
DROP TABLE IF EXISTS `wx_material_news`;
CREATE TABLE `wx_material_news` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `mname` varchar(255) DEFAULT '' COMMENT '素材名称',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `author` varchar(30) DEFAULT NULL COMMENT '作者',
  `cover_id` int(10) unsigned DEFAULT NULL COMMENT '封面',
  `intro` varchar(255) DEFAULT NULL COMMENT '摘要',
  `content` longtext COMMENT '内容',
  `group_id` int(10) DEFAULT '0' COMMENT '多图文组的ID',
  `thumb_media_id` varchar(100) DEFAULT NULL COMMENT '图文消息的封面图片素材id（必须是永久mediaID）',
  `media_id` varchar(100) DEFAULT '0' COMMENT '微信端图文消息素材的media_id',
  `manager_id` int(10) DEFAULT NULL COMMENT '管理员ID',
  `token` varchar(100) DEFAULT NULL COMMENT 'Token',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  `url` varchar(255) DEFAULT NULL COMMENT '图文页url',
  `is_use` int(10) DEFAULT '1' COMMENT '可否使用',
  PRIMARY KEY (`id`),
  KEY `wx_material_news_f1` (`token`),
  CONSTRAINT `wx_material_news_f1` FOREIGN KEY (`token`) REFERENCES `wx_public` (`token`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wx_material_news
-- ----------------------------

-- ----------------------------
-- Table structure for wx_material_text
-- ----------------------------
DROP TABLE IF EXISTS `wx_material_text`;
CREATE TABLE `wx_material_text` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `mname` varchar(255) DEFAULT '' COMMENT '素材名称',
  `content` text COMMENT '文本内容',
  `token` varchar(50) DEFAULT NULL COMMENT 'Token',
  `manager_id` int(10) DEFAULT NULL COMMENT '管理员id',
  `is_use` int(10) DEFAULT '1' COMMENT '可否使用',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `wx_material_text_f1` (`token`),
  CONSTRAINT `wx_material_text_f1` FOREIGN KEY (`token`) REFERENCES `wx_public` (`token`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wx_material_text
-- ----------------------------
INSERT INTO `wx_material_text` VALUES ('1', '测试', '测试测试', 'gh_ca957753929e', '1', '1', '2017-02-24 15:40:38');

-- ----------------------------
-- Table structure for wx_public
-- ----------------------------
DROP TABLE IF EXISTS `wx_public`;
CREATE TABLE `wx_public` (
  `id` char(32) NOT NULL COMMENT '主键',
  `uid` int(10) DEFAULT NULL COMMENT '用户ID',
  `public_name` varchar(50) DEFAULT NULL COMMENT '公众号名称',
  `public_id` varchar(100) DEFAULT NULL COMMENT '公众号原始id',
  `wechat` varchar(100) DEFAULT NULL COMMENT '微信号',
  `interface_url` varchar(255) DEFAULT NULL COMMENT '接口地址',
  `headface_url` varchar(255) DEFAULT NULL COMMENT '公众号头像',
  `token` varchar(100) DEFAULT NULL COMMENT 'Token',
  `is_use` tinyint(2) DEFAULT '0' COMMENT '是否为当前公众号',
  `type` char(10) DEFAULT '0' COMMENT '公众号类型',
  `appid` varchar(255) DEFAULT NULL COMMENT 'AppID',
  `secret` varchar(255) DEFAULT NULL COMMENT 'AppSecret',
  `isencryptMessage` tinyint(4) DEFAULT '0' COMMENT '是否加密0:否；1:是',
  `encodingaeskey` varchar(255) DEFAULT NULL COMMENT 'EncodingAESKey',
  `welcome` varchar(255) DEFAULT '' COMMENT '欢迎语配置',
  `noanswer` varchar(255) DEFAULT '' COMMENT '自动回复配置',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `token` (`token`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wx_public
-- ----------------------------
INSERT INTO `wx_public` VALUES ('5c4d0adac7e1414ea59df29002dfd03e', '1', '测试号', 'gh_ca957753929e', 'gh_ca957753929e', 'http://localhost/moewxms/weixin/msg/5c4d0adac7e1414ea59df29002dfd03e', null, 'gh_ca957753929e', '0', '0', 'wx315a9e6a4d281ec4', 'd4624c36b6795d1d99dcf0547af5443d', '0', null, '', '', '2017-02-23 17:13:03');

-- ----------------------------
-- Table structure for wx_public_follow
-- ----------------------------
DROP TABLE IF EXISTS `wx_public_follow`;
CREATE TABLE `wx_public_follow` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `openid` varchar(100) NOT NULL,
  `token` varchar(100) NOT NULL,
  `syc_status` tinyint(1) DEFAULT '2' COMMENT '0 开始同步中 1 更新用户信息中 2 完成同步',
  `createdate` datetime DEFAULT NULL COMMENT '添加时间',
  `remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `openid` (`openid`,`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wx_public_follow
-- ----------------------------

-- ----------------------------
-- Table structure for wx_public_tags
-- ----------------------------
DROP TABLE IF EXISTS `wx_public_tags`;
CREATE TABLE `wx_public_tags` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `token` varchar(100) NOT NULL,
  `title` int(11) DEFAULT NULL COMMENT '标签名称',
  PRIMARY KEY (`id`),
  KEY `wx_public_tags_f1` (`token`),
  CONSTRAINT `wx_public_tags_f1` FOREIGN KEY (`token`) REFERENCES `wx_public` (`token`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wx_public_tags
-- ----------------------------
