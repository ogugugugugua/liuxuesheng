CREATE TABLE restaurant
(
    id                 BIGINT          NOT NULL AUTO_INCREMENT COMMENT 'id',
    uuid               CHAR(36)        NOT NULL COMMENT '行程/餐馆uuid',
    schedule_type_uuid CHAR(36)        NOT NULL DEFAULT '3' COMMENT '行程类型uuid',
    stars              INT             NOT NULL COMMENT '星级',
    local_name         VARCHAR(32)     NOT NULL COMMENT '外文名称',
    cn_name            VARCHAR(32)     NOT NULL DEFAULT '' COMMENT '中文名称',
    city               VARCHAR(32)     NOT NULL COMMENT '所在城市',
    country_uuid       CHAR(36)        NOT NULL DEFAULT '' COMMENT '所在国家uuid',
    location           VARCHAR(1024)   NOT NULL COMMENT '具体地址',
    rating             DECIMAL(32, 10) NOT NULL DEFAULT 5 COMMENT '用户评分',
    url                VARCHAR(1024)   NOT NULL DEFAULT '' COMMENT '链接网址',
    created_time       DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time       DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted            VARCHAR(1)      NOT NULL DEFAULT 0 COMMENT '已删除 yes:1,no:0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_uuid (uuid),
    UNIQUE KEY uniq_name_city (local_name, city)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '餐饮 ';


CREATE TABLE menu
(
    id              BIGINT         NOT NULL AUTO_INCREMENT COMMENT 'id',
    uuid            CHAR(36)       NOT NULL COMMENT 'uuid',
    restaurant_uuid CHAR(36)       NOT NULL COMMENT '餐厅uuid',
    name            VARCHAR(32)    NOT NULL COMMENT '菜名',
    description     VARCHAR(1024)  NOT NULL DEFAULT '' COMMENT '描述',
    price           DECIMAL(32, 8) NOT NULL DEFAULT -1 COMMENT '价格',
    created_time    DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time    DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted         VARCHAR(1)     NOT NULL DEFAULT 0 COMMENT '已删除 yes:1,no:0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_menu_uuid (uuid),
    UNIQUE KEY uniq_restaurant_name_price (restaurant_uuid, name, price)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '菜单';



