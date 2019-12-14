/*
 Navicat Premium Data Transfer

 Source Server         : 47.103.120.110
 Source Server Type    : MySQL
 Source Server Version : 50564
 Source Host           : 47.103.120.110:3306
 Source Schema         : content_center

 Target Server Type    : MySQL
 Target Server Version : 50564
 File Encoding         : 65001

 Date: 14/12/2019 14:53:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mid_user_share
-- ----------------------------
DROP TABLE IF EXISTS `mid_user_share`;
CREATE TABLE `mid_user_share` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `share_id` int(11) NOT NULL COMMENT 'share.id',
  `user_id` int(11) NOT NULL COMMENT 'user.id',
  PRIMARY KEY (`id`),
  KEY `fk_mid_user_share_share1_idx` (`share_id`),
  KEY `fk_mid_user_share_user1_idx` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户-分享中间表【描述用户购买的分享】';

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `content` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '内容',
  `show_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否显示 0:否 1:是',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for share
-- ----------------------------
DROP TABLE IF EXISTS `share`;
CREATE TABLE `share` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '发布人id',
  `title` varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '标题',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `is_original` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否原创 0:否 1:是',
  `author` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '作者',
  `cover` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '封面',
  `summary` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '概要信息',
  `price` int(11) NOT NULL DEFAULT '0' COMMENT '价格（需要的积分）',
  `download_url` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '下载地址',
  `buy_count` int(11) NOT NULL DEFAULT '0' COMMENT '下载数 ',
  `show_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否显示 0:否 1:是',
  `audit_status` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '审核状态 NOT_YET: 待审核 PASSED:审核通过 REJECTED:审核不通过',
  `reason` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '审核不通过原因',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='分享表';

-- ----------------------------
-- Records of share
-- ----------------------------
BEGIN;
INSERT INTO `share` VALUES (1, 1, 'SpringCloud Docker实战', '2019-11-03 16:26:28', '2019-11-03 16:26:28', 0, '加油', 'xxx', '', 0, '', 1, 0, '0', '');
INSERT INTO `share` VALUES (2, 1, 'SpringCloudAlibaba实战', '2019-11-03 16:27:52', '2019-11-03 16:27:52', 0, '加油', 'xxx', '', 0, '', 1, 0, '0', '');
INSERT INTO `share` VALUES (3, 1, 'Kubernetes实战', '2019-11-03 16:27:53', '2019-11-03 16:27:53', 0, '加油', 'xxx', '', 0, '', 1, 0, '0', '');
INSERT INTO `share` VALUES (4, 1, 'Docker实战', '2019-11-03 16:27:53', '2019-11-03 16:27:53', 0, '加油', 'xxx', '', 0, '', 1, 0, '0', '');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
