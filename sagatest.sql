/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : sagatest

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 25/11/2018 18:58:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for s_order
-- ----------------------------
DROP TABLE IF EXISTS `s_order`;
CREATE TABLE `s_order`  (
  `id` bigint(255) NOT NULL COMMENT '订单id',
  `user_id` bigint(255) NULL DEFAULT NULL COMMENT '用户id',
  `number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单号',
  `payment` decimal(10, 2) NULL DEFAULT NULL COMMENT '实付金额',
  `status` tinyint(10) NULL DEFAULT NULL COMMENT '状态：1. 未付款，2.已付款，3.未发货, 4已发货, 5.交易成功，6.交易关闭',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '订单创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '订单更新时间',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '付款时间',
  `delivery_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_order
-- ----------------------------
INSERT INTO `s_order` VALUES (224834820663021568, 224833220045312000, 'bb943a47-8d2e-46fd-a1c7-064ef7841177', 20.10, 0, '2018-11-20 20:20:08', '2018-11-20 20:20:08', NULL, NULL);

-- ----------------------------
-- Table structure for s_order_item
-- ----------------------------
DROP TABLE IF EXISTS `s_order_item`;
CREATE TABLE `s_order_item`  (
  `id` bigint(20) NOT NULL,
  `product_id` bigint(20) NULL DEFAULT NULL COMMENT '商品id',
  `num` int(11) NULL DEFAULT NULL COMMENT '商品数量',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品单价',
  `total_fee` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品总价',
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_product
-- ----------------------------
DROP TABLE IF EXISTS `s_product`;
CREATE TABLE `s_product`  (
  `id` bigint(255) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stock` int(255) NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_product
-- ----------------------------
INSERT INTO `s_product` VALUES (224834251646963712, '苹果', 1, 20.10, '2018-11-20 20:17:53', '2018-11-20 20:17:53');

-- ----------------------------
-- Table structure for s_transaction
-- ----------------------------
DROP TABLE IF EXISTS `s_transaction`;
CREATE TABLE `s_transaction`  (
  `id` bigint(20) NOT NULL COMMENT '交易id',
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单id',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '交易用户id',
  `amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '交易金额',
  `pay_state` tinyint(2) NULL DEFAULT NULL COMMENT '支付类型 0:余额 1:微信 2:支付宝',
  `status` tinyint(255) NULL DEFAULT NULL COMMENT '支付状态 -1:取消 0:未完成 1:已完成 -2:异常',
  `completion_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_transaction_record
-- ----------------------------
DROP TABLE IF EXISTS `s_transaction_record`;
CREATE TABLE `s_transaction_record`  (
  `id` bigint(20) NOT NULL,
  `order_id` bigint(20) NOT NULL,
  `events` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `result` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_user
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user`  (
  `id` bigint(255) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES (224833220045312000, 'walker', 20, '2018-11-20 20:13:47', '2018-11-20 20:13:47');

SET FOREIGN_KEY_CHECKS = 1;
