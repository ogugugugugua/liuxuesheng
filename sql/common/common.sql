CREATE TABLE comment
(
    id              BIGINT        NOT NULL AUTO_INCREMENT COMMENT 'id',
    creator_id      BIGINT        NOT NULL COMMENT '创建人id',
    creator_role_id VARCHAR(32)   NOT NULL DEFAULT '' COMMENT '创建人角色id',
    content         VARCHAR(1024) NOT NULL DEFAULT '' COMMENT '评论内容',
    preference      VARCHAR(1)    NOT NULL DEFAULT 1 COMMENT '用户对所评论对象的偏好 yes:1,no:0',
    approved        INT           NOT NULL DEFAULT 1 COMMENT '评论被点赞数',
    created_time    DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time    DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted      VARCHAR(1)   NOT NULL DEFAULT 0 COMMENT '已删除 已删除为1,未删除为0',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '评论 ';

CREATE TABLE image
(
    id           BIGINT       NOT NULL AUTO_INCREMENT COMMENT 'id',
    name         VARCHAR(32)  NOT NULL DEFAULT '' COMMENT '图片名称',
    url          VARCHAR(128) NOT NULL DEFAULT '' COMMENT 'url连接',
    head_image   VARCHAR(1)   NOT NULL DEFAULT 0 COMMENT '头图 yes:1,no:0',
    created_by   VARCHAR(32)  NOT NULL DEFAULT '' COMMENT '创建人',
    created_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted      VARCHAR(1)   NOT NULL DEFAULT 0 COMMENT '已删除 yes:1,no:0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_url (url)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '图片 ';

CREATE TABLE price
(
    id             BIGINT         NOT NULL AUTO_INCREMENT COMMENT 'id',
    name           VARCHAR(32)    NOT NULL DEFAULT '' COMMENT '价格对应项目名称',
    original_price DECIMAL(32, 8) NOT NULL DEFAULT 0 COMMENT '原价',
    discount_price DECIMAL(32, 8) NOT NULL DEFAULT 0 COMMENT '折扣价',
    created_by     VARCHAR(32)    NOT NULL DEFAULT '' COMMENT '创建人',
    created_time   DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time   DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted        VARCHAR(1)     NOT NULL DEFAULT 0 COMMENT '已删除 yes:1,no:0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_vehicle_type_number (name, original_price, discount_price)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '价格 ';

CREATE TABLE transportation
(
    id                BIGINT         NOT NULL AUTO_INCREMENT COMMENT 'id',
    default_price     DECIMAL(32, 8) NOT NULL DEFAULT '' COMMENT '默认价格',
    vehicle_type_id   VARCHAR(32)    NOT NULL DEFAULT '' COMMENT '交通工具类型id',
    vehicle_number    VARCHAR(32)    NOT NULL DEFAULT '' COMMENT '交通工具编号',
    boarding_location VARCHAR(32)    NOT NULL DEFAULT '' COMMENT '乘坐地点',
    created_by        VARCHAR(32)    NOT NULL DEFAULT '' COMMENT '创建人',
    created_time      DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time      DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted           VARCHAR(1)     NOT NULL DEFAULT 0 COMMENT '已删除 已删除为1,未删除为0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_vehicle_type_number (vehicle_type_id, vehicle_number)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '可用交通方式 ';

CREATE TABLE vehicle_type
(
    id           BIGINT      NOT NULL AUTO_INCREMENT COMMENT 'id',
    type         VARCHAR(32) NOT NULL DEFAULT '' COMMENT '类型',
    cn_name      VARCHAR(32) NOT NULL DEFAULT '' COMMENT '中文名',
    created_by   VARCHAR(32) NOT NULL DEFAULT '' COMMENT '创建人',
    deleted      VARCHAR(1)  NOT NULL DEFAULT 0 COMMENT '已删除 已删除为1,未删除为0',
    created_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_type (type)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '交通方式类型 ';

CREATE TABLE role
(
    id           BIGINT      NOT NULL AUTO_INCREMENT COMMENT 'id',
    type         VARCHAR(32) NOT NULL DEFAULT '' COMMENT '角色类型 超级管理员,管理员,运营,留学生,游客',
    created_by   VARCHAR(32) NOT NULL DEFAULT '' COMMENT '创建人',
    created_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted      VARCHAR(1)   NOT NULL DEFAULT 0 COMMENT '已删除 已删除为1,未删除为0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_type(type)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='角色';

