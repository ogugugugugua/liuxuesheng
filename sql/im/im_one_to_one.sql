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

 Date: 13/06/2021 10:46:31
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for im_one_to_one
-- ----------------------------
DROP TABLE IF EXISTS `im_one_to_one`;
CREATE TABLE `im_one_to_one`
(
    `id`             bigint                                               NOT NULL AUTO_INCREMENT,
    `uuid`           char(36)                                             NOT NULL DEFAULT '',
    `from_user_uuid` char(36)                                             NOT NULL DEFAULT '',
    `from_user_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin    NOT NULL DEFAULT '' COMMENT '1:student,0:traveler',
    `from_user_name` varchar(255)                                         NOT NULL,
    `to_user_uuid`   char(36)                                             NOT NULL DEFAULT '',
    `to_user_type`   char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin    NOT NULL DEFAULT '' COMMENT '1:student,0:traveler',
    `to_user_name`   varchar(255)                                         NOT NULL,
    `content`        varchar(2047)                                        NOT NULL,
    `read_flag`      varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '1:read,0:unread',
    `create_time`    datetime                                             NOT NULL ON UPDATE CURRENT_TIMESTAMP,
    `deleted`        varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '0' COMMENT '1:yes,0:no',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SET
FOREIGN_KEY_CHECKS = 1;
