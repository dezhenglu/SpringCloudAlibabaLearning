/*
 Navicat Premium Data Transfer

 Source Server         : 47.103.120.110
 Source Server Type    : MySQL
 Source Server Version : 50564
 Source Host           : 47.103.120.110:3306
 Source Schema         : user_center

 Target Server Type    : MySQL
 Target Server Version : 50564
 File Encoding         : 65001

 Date: 14/12/2019 14:54:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bonus_event_log
-- ----------------------------
DROP TABLE IF EXISTS `bonus_event_log`;
CREATE TABLE `bonus_event_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `user_id` int(11) DEFAULT NULL COMMENT 'user.id',
  `value` int(11) DEFAULT NULL COMMENT '积分操作值',
  `event` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发生的事件',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `description` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`),
  KEY `fk_bonus_event_log_user1_idx` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='积分变更记录表';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `wx_id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '微信id',
  `wx_nickname` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '微信昵称',
  `roles` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '角色',
  `avatar_url` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '头像地址',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `bonus` int(11) NOT NULL DEFAULT '300' COMMENT '积分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='分享';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'ashdasdwhas', '加油', 'admin', 'xxx', '2019-11-03 15:17:49', '2019-11-03 15:17:49', 100);
INSERT INTO `user` VALUES (2, 'ashdasdwhas', '加油他爸', 'user', 'xxx', '2019-11-03 15:18:58', '2019-11-03 15:18:58', 100);
INSERT INTO `user` VALUES (3, 'ashdasdwhas', '加油他妈妈', 'user', 'xxx', '2019-11-03 17:11:37', '2019-11-03 17:11:37', 100);
INSERT INTO `user` VALUES (4, 'ashdasdwhas', '加油他姐', 'user', 'xxx', '2019-11-03 17:11:40', '2019-11-03 17:11:40', 100);
INSERT INTO `user` VALUES (5, 'ashdasdwhas', '加油他老婆', 'user', 'xxx', '2019-11-03 17:11:40', '2019-11-03 17:11:40', 100);
INSERT INTO `user` VALUES (6, 'ashdasdwhas', '加油他儿子', 'user', 'xxx', '2019-11-03 17:11:41', '2019-11-03 17:11:41', 100);
INSERT INTO `user` VALUES (7, 'ashdasdwhas', '加油他女儿', 'user', 'xxx', '2019-11-03 17:11:42', '2019-11-03 17:11:42', 100);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
