CREATE TABLE routine
(
    id           BIGINT       NOT NULL AUTO_INCREMENT COMMENT 'id',
    uuid         CHAR(36)     NOT NULL COMMENT 'uuid',
    current_date DATE         NOT NULL COMMENT '当前日期',
    supplement   VARCHAR(128) NOT NULL COMMENT '补充信息',
    created_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted      VARCHAR(1)   NOT NULL DEFAULT 0 COMMENT '已删除 yes:1,no:0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_routine_uuid (uuid)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '日安排';


CREATE TABLE trip
(
    id             BIGINT        NOT NULL AUTO_INCREMENT COMMENT 'id',
    uuid           CHAR(36)      NOT NULL COMMENT 'uuid',
    creator_uuid   CHAR(36)      NOT NULL COMMENT '创建人uuid',
    title          VARCHAR(1024) NOT NULL COMMENT '标题',
    description    VARCHAR(3072) NOT NULL DEFAULT '' COMMENT '简介',
    classification VARCHAR(32)   NOT NULL DEFAULT '' COMMENT '文章分类',
    depart_time    DATE          NOT NULL COMMENT '出发时间',
    duration       INT           NOT NULL COMMENT '出行天数',
    rank_top       VARCHAR(1)    NOT NULL DEFAULT 1 COMMENT '置顶 yes:1,no:0',
    status         VARCHAR(1)    NOT NULL DEFAULT 0 COMMENT '审核状态 passed:1,other:0',
    private        VARCHAR(1)    NOT NULL DEFAULT 0 COMMENT '是否私密行程 私密是1,公开是0',
    created_time   DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time   DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted        VARCHAR(1)    NOT NULL DEFAULT 0 COMMENT '已删除 yes:1,no:0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_trip_uuid (uuid)
) COMMENT = '旅途 ';