/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 13/06/2021 10:41:00
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for im_group_member
-- ----------------------------
DROP TABLE IF EXISTS `im_group_member`;
CREATE TABLE `im_group_member`
(
    `id`          bigint                                            NOT NULL AUTO_INCREMENT,
    `uuid`        char(36)                                          NOT NULL,
    `group_uuid`  char(36)                                          NOT NULL,
    `user_uuid`   char(36)                                          NOT NULL,
    `user_name`   varchar(255)                                      NOT NULL,
    `user_type`   char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '1:student,0:traveler',
    `create_time` datetime                                          NOT NULL ON UPDATE CURRENT_TIMESTAMP,
    `deleted`     char(1)                                           NOT NULL DEFAULT '0' COMMENT '1:yes,0:no',
    PRIMARY KEY (`id`),
    KEY           `group_uuid` (`group_uuid`),
    KEY           `user_name` (`user_name`),
    KEY           `user_uuid` (`user_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SET
FOREIGN_KEY_CHECKS = 1;
