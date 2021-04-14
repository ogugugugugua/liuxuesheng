use test;
CREATE TABLE IF NOT EXISTS student
(
    id              BIGINT      NOT NULL AUTO_INCREMENT COMMENT '留学生id',
    account_name    VARCHAR(32) NOT NULL DEFAULT '' COMMENT '账户名',
    pwd             VARCHAR(32) NOT NULL DEFAULT '' COMMENT '密码',
    gender          VARCHAR(1)  NOT NULL DEFAULT '' COMMENT '性别 男为1,女为0',
    real_name       VARCHAR(32) NOT NULL DEFAULT '' COMMENT '真实姓名',
    country         VARCHAR(32) NOT NULL DEFAULT '' COMMENT '所在国家',
    city            VARCHAR(32) NOT NULL DEFAULT '' COMMENT '所在城市',
    local_phone     VARCHAR(32) NOT NULL DEFAULT '' COMMENT '所在地电话',
    cn_phone        VARCHAR(32) NOT NULL DEFAULT '' COMMENT '国内电话',
    mail            VARCHAR(32) NOT NULL DEFAULT '' COMMENT '邮箱',
    id_card_number  VARCHAR(32) NOT NULL DEFAULT '' COMMENT '身份证',
    passport_number VARCHAR(32) NOT NULL DEFAULT '' COMMENT '护照',
    avatar_url      VARCHAR(32) NOT NULL DEFAULT '' COMMENT '头像地址',
    status          VARCHAR(32) NOT NULL DEFAULT '' COMMENT '状态',
    grade           VARCHAR(32) NOT NULL DEFAULT 0 COMMENT '用户层级 普通用户0,vip1,超级vip2',
    last_login      DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上次登录时间',
    created_time    DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time     DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted         VARCHAR(1)  NOT NULL DEFAULT 0 COMMENT '已注销 已注销为1,未注销为0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_account_name (account_name)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='留学生信息表';

CREATE TABLE traveler
(
    id            BIGINT      NOT NULL AUTO_INCREMENT COMMENT '旅客id',
    account_name  VARCHAR(32) NOT NULL DEFAULT '' COMMENT '账户名',
    pwd           VARCHAR(32) NOT NULL DEFAULT '' COMMENT '密码',
    gender        VARCHAR(1)  NOT NULL DEFAULT '' COMMENT '性别 男为1,女为0',
    real_name     VARCHAR(32) NOT NULL DEFAULT '' COMMENT '真实姓名',
    country       VARCHAR(32) NOT NULL DEFAULT '' COMMENT '所在国家',
    city          VARCHAR(32) NOT NULL DEFAULT '' COMMENT '所在城市',
    local_phone   VARCHAR(32) NOT NULL DEFAULT '' COMMENT '所在地电话',
    cn_phone      VARCHAR(32) NOT NULL DEFAULT '' COMMENT '国内电话',
    mail          VARCHAR(32) NOT NULL DEFAULT '' COMMENT '邮箱',
    mail_verified VARCHAR(1)  NOT NULL DEFAULT 0 COMMENT '邮箱已验证 已验证为1,未验证为0',
    avatar_url    VARCHAR(32) NOT NULL DEFAULT '' COMMENT '头像地址',
    status        VARCHAR(32) NOT NULL DEFAULT '' COMMENT '状态',
    grade         VARCHAR(32) NOT NULL DEFAULT 0 COMMENT '用户层级 普通用户0,vip1,超级vip2',
    last_login    DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上次登录时间',
    created_time  DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time  DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted       VARCHAR(1)  NOT NULL DEFAULT 0 COMMENT '已注销 已注销为1,未注销为0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_account_name (account_name)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '旅客 ';

use test;
CREATE TABLE vehicle_type
(
    id           BIGINT      NOT NULL AUTO_INCREMENT COMMENT 'id',
    type         VARCHAR(32) NOT NULL DEFAULT '' COMMENT '类型',
    cn_name      VARCHAR(32) NOT NULL DEFAULT '' COMMENT '中文名',
    created_by   VARCHAR(32) NOT NULL DEFAULT '' COMMENT '创建人',
    created_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted      VARCHAR(1)  NOT NULL DEFAULT 0 COMMENT '已删除 已删除为1,未删除为0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_type (type)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='交通方式类型表';


CREATE TABLE transportation
(
    id                BIGINT         NOT NULL AUTO_INCREMENT COMMENT 'id',
    default_price     DECIMAL(32, 8) NOT NULL DEFAULT 0 COMMENT '默认价格',
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
  COLLATE = utf8mb4_bin COMMENT ='可用交通方式';


CREATE TABLE price
(
    id             BIGINT         NOT NULL AUTO_INCREMENT COMMENT 'id',
    name           VARCHAR(32)    NOT NULL DEFAULT '' COMMENT '价格对应项目名称',
    original_price DECIMAL(32, 8) NOT NULL DEFAULT 0 COMMENT '原价',
    discount_price DECIMAL(32, 8) NOT NULL DEFAULT 0 COMMENT '折扣价',
    created_by     VARCHAR(32)    NOT NULL DEFAULT '' COMMENT '创建人',
    created_time   DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time   DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_vehicle_type_number (name, original_price, discount_price)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='价格表，包含对应项目，原价，折扣价';

