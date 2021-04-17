CREATE TABLE destination
(
    id                  BIGINT          NOT NULL AUTO_INCREMENT COMMENT 'id',
    uuid                CHAR(36)        NOT NULL COMMENT '行程/目的地uuid',
    schedule_type_uuid  CHAR(36)        NOT NULL DEFAULT '1' COMMENT '行程类型uuid',
    local_name          VARCHAR(32)     NOT NULL COMMENT '外文名称',
    cn_name             VARCHAR(64)     NOT NULL DEFAULT '' COMMENT '中文名称',
    city                VARCHAR(32)     NOT NULL COMMENT '所在城市',
    country_uuid        CHAR(36)        NOT NULL DEFAULT '' COMMENT '所在国家',
    location            VARCHAR(32)     NOT NULL COMMENT '具体地址',
    rating              DECIMAL(32, 10) NOT NULL DEFAULT 5 COMMENT '用户评分',
    duration            VARCHAR(32)     NOT NULL DEFAULT '' COMMENT '预计活动时间',
    url                 VARCHAR(1024)   NOT NULL DEFAULT '' COMMENT '链接网址',
    description         VARCHAR(3072)   NOT NULL COMMENT '目的地描述',
    special_requirement VARCHAR(1024)   NOT NULL DEFAULT '' COMMENT '特殊要求',
    created_time        DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time        DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted             VARCHAR(1)      NOT NULL DEFAULT 0 COMMENT '已删除 yes:1,no:0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_destination_uuid (uuid)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '目的地 ';



# CREATE TABLE destination_comment
# (
#     id             BIGINT   NOT NULL AUTO_INCREMENT COMMENT 'id',
#     destination_id BIGINT   NOT NULL DEFAULT '' COMMENT '目的地id',
#     comment_id     BIGINT   NOT NULL DEFAULT '' COMMENT '评论id',
#     created_time   DATETIME NOT NULL DEFAULT '1971-01-01 00:00:00' COMMENT '创建时间',
#     updated_time   DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
#     PRIMARY KEY (id)
# ) ENGINE = InnoDB
#   AUTO_INCREMENT = 1
#   DEFAULT CHARSET = utf8mb4
#   COLLATE = utf8mb4_bin COMMENT = '目的地及其评论列表';
#
# CREATE TABLE destination_image
# (
#     id             BIGINT   NOT NULL AUTO_INCREMENT COMMENT 'id',
#     destination_id BIGINT   NOT NULL DEFAULT '' COMMENT '目的地id',
#     image_id       BIGINT   NOT NULL DEFAULT '' COMMENT '图片id',
#     created_time   DATETIME NOT NULL DEFAULT '1971-01-01 00:00:00' COMMENT '创建时间',
#     updated_time   DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
#     PRIMARY KEY (id)
# ) ENGINE = InnoDB
#   AUTO_INCREMENT = 1
#   DEFAULT CHARSET = utf8mb4
#   COLLATE = utf8mb4_bin COMMENT = '目的地及其图片列表';
#
# CREATE TABLE destination_price
# (
#     id             BIGINT   NOT NULL AUTO_INCREMENT COMMENT 'id',
#     destination_id BIGINT   NOT NULL DEFAULT '' COMMENT '目的地id',
#     price_id       BIGINT   NOT NULL DEFAULT '' COMMENT '价格id',
#     created_time   DATETIME NOT NULL DEFAULT '1971-01-01 00:00:00' COMMENT '创建时间',
#     updated_time   DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
#     PRIMARY KEY (id)
# ) ENGINE = InnoDB
#   AUTO_INCREMENT = 1
#   DEFAULT CHARSET = utf8mb4
#   COLLATE = utf8mb4_bin COMMENT = '目的地及其收费项目列表';
#
# CREATE TABLE destination_transportation
# (
#     id                BIGINT   NOT NULL AUTO_INCREMENT COMMENT 'id',
#     destination_id    BIGINT   NOT NULL COMMENT '目的地id',
#     transportation_id BIGINT   NOT NULL COMMENT '可用交通方式id',
#     created_time      DATETIME NOT NULL DEFAULT '1971-01-01 00:00:00' COMMENT '创建时间',
#     updated_time      DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
#     PRIMARY KEY (id)
# ) ENGINE = InnoDB
#   AUTO_INCREMENT = 1
#   DEFAULT CHARSET = utf8mb4
#   COLLATE = utf8mb4_bin COMMENT = '目的地及其可用交通方式列表';