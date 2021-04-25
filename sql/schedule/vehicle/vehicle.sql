CREATE TABLE vehicle
(
    id                       BIGINT      NOT NULL AUTO_INCREMENT COMMENT 'id',
    uuid                     CHAR(36) NOT NULL COMMENT '行程/交通uuid',
    schedule_type_uuid       CHAR(36) NOT NULL DEFAULT '4' COMMENT '行程类型uuid',
    transportation_type_uuid CHAR(36)    NOT NULL COMMENT '交通工具类型uuid',
    local_name               VARCHAR(32) NOT NULL COMMENT '外文名称',
    cn_name                  VARCHAR(32) NOT NULL DEFAULT '' COMMENT '中文名称',
    vehicle_serial           VARCHAR(32) NOT NULL DEFAULT '' COMMENT '交通工具编号',
    departure_time           DATETIME    NOT NULL COMMENT '出发时间',
    duration                 TIME        NOT NULL COMMENT '交通耗时',
    arrival_time             DATETIME    NOT NULL COMMENT '到达时间',
    departure_location       VARCHAR(32) NOT NULL DEFAULT '' COMMENT '出发地点',
    arrival_location         VARCHAR(32) NOT NULL DEFAULT '' COMMENT '到达地点',
    grade                    VARCHAR(32) NOT NULL DEFAULT '' COMMENT '舱位等级',
    created_time             DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time             DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted                  VARCHAR(1)  NOT NULL DEFAULT 0 COMMENT '已删除 yes:1,no:0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_uuid (uuid)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '交通 ';