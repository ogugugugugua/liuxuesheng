CREATE TABLE comment
(
    id                 BIGINT        NOT NULL AUTO_INCREMENT COMMENT 'id',
    uuid               CHAR(36)      NOT NULL COMMENT 'uuid',
    schedule_uuid      CHAR(36)      NOT NULL COMMENT '关联行程uuid',
    schedule_type_uuid CHAR(36)      NOT NULL COMMENT '关联行程类型uuid',
    creator_uuid       CHAR(36)      NOT NULL COMMENT '创建人uuid',
    parent_uuid        CHAR(36)      NOT NULL DEFAULT 0 COMMENT '上级评论uuid 0表示顶级评论',
    content            VARCHAR(1024) NOT NULL DEFAULT '' COMMENT '评论内容',
    preference         VARCHAR(1)    NOT NULL DEFAULT 1 COMMENT '用户对所评论对象的偏好 yes:1,no:0',
    approved           INT           NOT NULL DEFAULT 1 COMMENT '评论被点赞数',
    created_time       DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time       DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    state              VARCHAR(1)    NOT NULL DEFAULT 1 COMMENT '状态 可见:1,不可见:0',
    deleted            VARCHAR(1)    NOT NULL DEFAULT 0 COMMENT '已删除 yes:1,no:0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_comment_uuid (uuid)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '评论 ';

CREATE TABLE image
(
    id                 BIGINT        NOT NULL AUTO_INCREMENT COMMENT 'id',
    uuid               CHAR(36)      NOT NULL COMMENT 'uuid',
    schedule_uuid      CHAR(36)      NOT NULL COMMENT '关联行程uuid',
    schedule_type_uuid CHAR(36)      NOT NULL COMMENT '关联行程类型uuid',
    name               VARCHAR(32)   NOT NULL DEFAULT '' COMMENT '图片名称',
    url                VARCHAR(1024) NOT NULL COMMENT 'url连接',
    head_image         VARCHAR(1)    NOT NULL DEFAULT 0 COMMENT '头图 yes:1,no:0',
    creator_uuid       CHAR(36)      NOT NULL COMMENT '创建人uuid',
    created_time       DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time       DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted            VARCHAR(1)    NOT NULL DEFAULT 0 COMMENT '已删除 yes:1,no:0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_image_uuid (uuid)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '图片 ';

CREATE TABLE price
(
    id                 BIGINT         NOT NULL AUTO_INCREMENT COMMENT 'id',
    uuid               CHAR(36)       NOT NULL COMMENT 'uuid',
    schedule_uuid      CHAR(36)       NOT NULL COMMENT '关联行程uuid',
    schedule_type_uuid CHAR(36)       NOT NULL COMMENT '关联行程类型uuid',
    name               VARCHAR(32)    NOT NULL COMMENT '价格对应项目名称',
    original_price     DECIMAL(32, 8) NOT NULL COMMENT '原价',
    discount_price     DECIMAL(32, 8) NOT NULL COMMENT '折扣价',
    creator_uuid       CHAR(36)       NOT NULL COMMENT '创建人uuid',
    created_time       DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time       DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted            VARCHAR(1)     NOT NULL DEFAULT 0 COMMENT '已删除 yes:1,no:0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_price_uuid (uuid),
    UNIQUE KEY uniq_vehicle_type_number (name, original_price, discount_price)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '价格 ';

CREATE TABLE transportation
(
    id                       BIGINT         NOT NULL AUTO_INCREMENT COMMENT 'id',
    uuid                     CHAR(36)       NOT NULL COMMENT 'uuid',
    schedule_uuid            CHAR(36)       NOT NULL COMMENT '关联行程uuid',
    schedule_type_uuid       CHAR(36)       NOT NULL COMMENT '关联行程类型uuid',
    transportation_type_uuid CHAR(36)       NOT NULL COMMENT '交通工具类型uuid',
    default_price            DECIMAL(32, 8) NOT NULL DEFAULT -1 COMMENT '默认价格',
    vehicle_number           VARCHAR(32)    NOT NULL COMMENT '交通工具编号',
    boarding_location        VARCHAR(32)    NOT NULL DEFAULT '' COMMENT '乘坐地点',
    creator_uuid             CHAR(36)       NOT NULL COMMENT '创建人uuid',
    created_time             DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time             DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted                  VARCHAR(1)     NOT NULL DEFAULT 0 COMMENT '已删除 已删除为1,未删除为0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_transportation_uuid (uuid)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '可用交通方式 ';

CREATE TABLE transportation_type
(
    id           BIGINT      NOT NULL AUTO_INCREMENT COMMENT 'id',
    uuid         CHAR(36)    NOT NULL COMMENT 'uuid',
    type         VARCHAR(32) NOT NULL COMMENT '类型',
    cn_name      VARCHAR(32) NOT NULL DEFAULT '' COMMENT '中文名',
    creator_uuid CHAR(36)    NOT NULL COMMENT '创建人uuid',
    deleted      VARCHAR(1)  NOT NULL DEFAULT 0 COMMENT '已删除 已删除为1,未删除为0',
    created_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_type (type),
    UNIQUE KEY uniq_transportation_type_uuid (uuid)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '交通方式类型 ';

CREATE TABLE role
(
    id           BIGINT      NOT NULL AUTO_INCREMENT COMMENT 'id',
    uuid         CHAR(36)    NOT NULL COMMENT 'uuid',
    type         VARCHAR(32) NOT NULL COMMENT '角色类型 超级管理员,管理员,运营,留学生,游客 etc',
    created_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted      VARCHAR(1)  NOT NULL DEFAULT 0 COMMENT '已删除 已删除为1,未删除为0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_type (type),
    UNIQUE KEY uniq_role_uuid (uuid)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='角色';

