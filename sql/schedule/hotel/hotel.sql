CREATE TABLE hotel
(
    id                 BIGINT          NOT NULL AUTO_INCREMENT COMMENT 'id',
    uuid               CHAR(36)        NOT NULL COMMENT '行程/酒店uuid',
    schedule_type_uuid CHAR(36)        NOT NULL DEFAULT '2' COMMENT '行程类型uuid',
    stars              INT             NOT NULL COMMENT '星级',
    local_name         VARCHAR(32)     NOT NULL COMMENT '外文名称',
    cn_name            VARCHAR(64)     NOT NULL DEFAULT '' COMMENT '中文名称',
    city               VARCHAR(32)     NOT NULL COMMENT '所在城市',
    country_uuid       CHAR(36)        NOT NULL DEFAULT '' COMMENT '所在国家',
    location           VARCHAR(1024)   NOT NULL DEFAULT '' COMMENT '具体地址',
    rating             DECIMAL(32, 10) NOT NULL DEFAULT 5 COMMENT '用户评分',
    url                VARCHAR(1024)   NOT NULL DEFAULT '' COMMENT '链接网址',
    check_in_time      TIME            NOT NULL COMMENT '最早入住时间',
    check_out_time     TIME            NOT NULL COMMENT '最晚离开时间',
    created_time       DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time       DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted            VARCHAR(1)      NOT NULL DEFAULT 0 COMMENT '已删除 yes:1,no:0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_uuid (uuid)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '住宿 ';

CREATE TABLE hoteluuid_roomuuid
(
    id           BIGINT     NOT NULL AUTO_INCREMENT COMMENT 'id',
    uuid         CHAR(36)   NOT NULL COMMENT 'uuid',
    hotel_uuid   CHAR(36)   NOT NULL COMMENT '酒店uuid',
    room_uuid    CHAR(36)   NOT NULL COMMENT '酒店房间uuid',
    created_time DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted      VARCHAR(1) NOT NULL DEFAULT 0 COMMENT '已删除 yes:1,no:0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_uuid (uuid)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '酒店uuid_房间uuid ';


CREATE TABLE room
(
    id             BIGINT         NOT NULL AUTO_INCREMENT COMMENT 'id',
    uuid           CHAR(36)       NOT NULL COMMENT 'uuid',
    type           VARCHAR(32)    NOT NULL COMMENT '房间类型',
    number_person  INT            NOT NULL COMMENT '可入住人数',
    default_price  DECIMAL(32, 8) NOT NULL COMMENT '默认价格',
    discount_price DECIMAL(32, 8) NOT NULL COMMENT '折扣价格',
    vip_grade      VARCHAR(64)    NOT NULL COMMENT '折扣价对应会员等级',
    created_time   DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time   DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted        VARCHAR(1)     NOT NULL DEFAULT 0 COMMENT '已删除 yes:1,no:0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_uuid (uuid)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '酒店房间';

# abandoned
CREATE TABLE roomuuid_beduuid
(
    id           BIGINT     NOT NULL AUTO_INCREMENT COMMENT 'id',
    uuid         CHAR(36)   NOT NULL COMMENT 'uuid',
    room_uuid    CHAR(36)   NOT NULL COMMENT '酒店房间uuid',
    bed_uuid     CHAR(36)   NOT NULL COMMENT '床uuid',
    created_time DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted      VARCHAR(1) NOT NULL DEFAULT 0 COMMENT '已删除 yes:1,no:0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_uuid (uuid)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '酒店房间uuid_床uuid ';


CREATE TABLE bed
(
    id            BIGINT      NOT NULL AUTO_INCREMENT COMMENT '床型id',
    uuid          CHAR(36)    NOT NULL COMMENT 'uuid',
    room_uuid     CHAR(36)    NOT NULL COMMENT '房间uuid',
    type          VARCHAR(32) NOT NULL DEFAULT '' COMMENT '类型 双人床,单人床,沙发床,榻榻米',
    number_person INT         NOT NULL DEFAULT 1 COMMENT '该床型可容纳人数',
    quantity      INT         NOT NULL DEFAULT 1 COMMENT '房间里该床型数量',
    created_time  DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time  DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted       VARCHAR(1)  NOT NULL DEFAULT 0 COMMENT '已删除 yes:1,no:0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_uuid (uuid),
    UNIQUE KEY uniq_room_type_num_quan (room_uuid, type, number_person, quantity)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '酒店房间床规格';

# abandoned
CREATE TABLE roomuuid_equipmentuuid
(
    id             BIGINT     NOT NULL AUTO_INCREMENT COMMENT 'id',
    uuid           CHAR(36)   NOT NULL COMMENT 'uuid',
    room_uuid      CHAR(36)   NOT NULL COMMENT '房间uuid',
    equipment_uuid CHAR(36)   NOT NULL COMMENT '设施uuid',
    created_time   DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time   DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted        VARCHAR(1) NOT NULL DEFAULT 0 COMMENT '已删除 yes:1,no:0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_uuid (uuid)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '酒店房间uuid_设施uuid ';


CREATE TABLE equipment
(
    id             BIGINT      NOT NULL AUTO_INCREMENT COMMENT '设施id',
    uuid           CHAR(36)    NOT NULL COMMENT 'uuid',
    room_uuid      CHAR(36)    NOT NULL COMMENT '房间uuid',
    equipment_name VARCHAR(32) NOT NULL COMMENT '设施名字',
    parameter      VARCHAR(32) NOT NULL DEFAULT '' COMMENT '参数',
    quantity       INT         NOT NULL DEFAULT 1 COMMENT '房间里该设施数量',
    created_time   DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time   DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted        VARCHAR(1)  NOT NULL DEFAULT 0 COMMENT '已删除 yes:1,no:0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_uuid (uuid),
    UNIQUE KEY uniq_room_name_param_quantity (room_uuid, equipment_name, parameter, quantity)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '酒店房间设施 酒店房间设施';