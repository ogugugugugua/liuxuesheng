use test;
CREATE TABLE IF NOT EXISTS student
(
    id              BIGINT       NOT NULL AUTO_INCREMENT COMMENT '留学生id',
    uuid            CHAR(36)     NOT NULL COMMENT 'uuid',
    account_name    VARCHAR(128) NOT NULL COMMENT '账户名',
    pwd             VARCHAR(256) NOT NULL COMMENT '密码',
    gender          VARCHAR(1)   NOT NULL DEFAULT '' COMMENT '性别 男为1,女为0',
    real_name       VARCHAR(32)  NOT NULL DEFAULT '' COMMENT '真实姓名',
    country         VARCHAR(32)  NOT NULL DEFAULT '' COMMENT '所在国家',
    city            VARCHAR(32)  NOT NULL DEFAULT '' COMMENT '所在城市',
    phone_code      VARCHAR(32)  NOT NULL DEFAULT '' COMMENT '电话前缀',
    local_phone     VARCHAR(32)  NOT NULL DEFAULT '' COMMENT '所在地电话',
    cn_phone        VARCHAR(32)  NOT NULL DEFAULT '' COMMENT '国内电话',
    mail            VARCHAR(32)  NOT NULL DEFAULT '' COMMENT '邮箱',
    id_card_number  VARCHAR(32)  NOT NULL DEFAULT '' COMMENT '身份证',
    passport_number VARCHAR(32)  NOT NULL DEFAULT '' COMMENT '护照',
    avatar_url      VARCHAR(32)  NOT NULL DEFAULT '' COMMENT '头像地址',
    status          VARCHAR(32)  NOT NULL DEFAULT '' COMMENT '状态',
    grade           VARCHAR(32)  NOT NULL DEFAULT '0' COMMENT '用户层级 普通用户0,vip1,超级vip2',
    last_login      DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上次登录时间',
    created_time    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time     DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted         VARCHAR(1)   NOT NULL DEFAULT 0 COMMENT '已注销 已注销为1,未注销为0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_account_name (account_name)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='留学生信息表';

CREATE TABLE traveler
(
    id            BIGINT       NOT NULL AUTO_INCREMENT COMMENT '旅客id',
    uuid          CHAR(36)     NOT NULL COMMENT 'uuid',
    account_name  VARCHAR(128) NOT NULL DEFAULT '' COMMENT '账户名',
    pwd           VARCHAR(256) NOT NULL COMMENT '密码',
    gender        VARCHAR(1)   NOT NULL DEFAULT '' COMMENT '性别 男为1,女为0',
    real_name     VARCHAR(32)  NOT NULL DEFAULT '' COMMENT '真实姓名',
    country       VARCHAR(32)  NOT NULL DEFAULT '' COMMENT '所在国家',
    city          VARCHAR(32)  NOT NULL DEFAULT '' COMMENT '所在城市',
    phone_code    VARCHAR(32)  NOT NULL COMMENT '电话前缀',
    local_phone   VARCHAR(32)  NOT NULL DEFAULT '' COMMENT '所在地电话',
    cn_phone      VARCHAR(32)  NOT NULL DEFAULT '' COMMENT '国内电话',
    mail          VARCHAR(32)  NOT NULL DEFAULT '' COMMENT '邮箱',
    mail_verified VARCHAR(1)   NOT NULL DEFAULT 0 COMMENT '邮箱已验证 已验证为1,未验证为0',
    avatar_url    VARCHAR(32)  NOT NULL DEFAULT '' COMMENT '头像地址',
    status        VARCHAR(32)  NOT NULL DEFAULT '' COMMENT '状态',
    grade         VARCHAR(32)  NOT NULL DEFAULT 0 COMMENT '用户层级 普通用户0,vip1,超级vip2',
    last_login    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上次登录时间',
    created_time  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted       VARCHAR(1)   NOT NULL DEFAULT 0 COMMENT '已注销 已注销为1,未注销为0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_account_name (account_name)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '旅客 ';



CREATE TABLE country_code
(
    id         BIGINT      NOT NULL AUTO_INCREMENT COMMENT 'id',
    uuid       CHAR(36)    NOT NULL COMMENT 'uuid',
    cn         VARCHAR(64) NOT NULL COMMENT '中文名',
    en         VARCHAR(64) NOT NULL COMMENT '英文名',
    phone_code VARCHAR(32) NOT NULL COMMENT '电话前缀',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_uuid (uuid),
    UNIQUE KEY uniq_cn (cn),
    UNIQUE KEY uniq_en (en)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '国家 ';



CREATE TABLE student_oauths
(
    id           BIGINT      NOT NULL AUTO_INCREMENT COMMENT 'id',
    uuid         CHAR(36)    NOT NULL COMMENT '留学生uuid',
    oauth_type   VARCHAR(32) NOT NULL DEFAULT '' COMMENT '第三方登录类型 weibo,qq,wechat',
    oauth_id     VARCHAR(64) NOT NULL DEFAULT '' COMMENT '第三方标识符',
    union_id     VARCHAR(64) NOT NULL DEFAULT '' COMMENT '统一标识符 qq/微信同一主体下unionid相同',
    credential   VARCHAR(64) NOT NULL DEFAULT '' COMMENT '密码凭证 access_token',
    created_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_uuid (uuid)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '留学生第三方登录信息表 ';


CREATE TABLE traveler_oauths
(
    id           BIGINT      NOT NULL AUTO_INCREMENT COMMENT 'id',
    uuid         CHAR(36)    NOT NULL COMMENT '旅客uuid',
    oauth_type   VARCHAR(32) NOT NULL DEFAULT '' COMMENT '第三方登录类型 weibo,qq,wechat',
    oauth_id     VARCHAR(64) NOT NULL DEFAULT '' COMMENT '第三方标识符',
    union_id     VARCHAR(64) NOT NULL DEFAULT '' COMMENT '统一标识符 qq/微信同一主体下unionid相同',
    credential   VARCHAR(64) NOT NULL DEFAULT '' COMMENT '密码凭证 access_token',
    created_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_uuid (uuid)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '旅客第三方登录信息表 ';


CREATE TABLE hr_role
(
    id           BIGINT     NOT NULL AUTO_INCREMENT COMMENT 'id',
    uuid         CHAR(36)   NOT NULL COMMENT 'uuid',
    hr_uuid      CHAR(36)   NOT NULL COMMENT '用户uuid',
    role_uuid    CHAR(36)   NOT NULL COMMENT '角色uuid',
    created_time DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted      VARCHAR(1) NOT NULL DEFAULT 0 COMMENT '已删除 yes:1,no:0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_uuid (uuid)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = ' 用户-角色关联表 ';

CREATE TABLE role
(
    id           BIGINT      NOT NULL AUTO_INCREMENT COMMENT 'id',
    uuid         CHAR(36)    NOT NULL COMMENT 'uuid',
    name         VARCHAR(32) NOT NULL COMMENT '角色类型 ROLE_super,admin,traveler,student,test',
    nameZh       VARCHAR(32) NOT NULL COMMENT '角色类型中文名 超级管理员,管理员,运营,留学生,游客',
    description  VARCHAR(64) NOT NULL COMMENT '角色描述',
    count        INT         NOT NULL DEFAULT 0 COMMENT '用户数量',
    sort         INT         NOT NULL DEFAULT 0 COMMENT '排序',
    status       VARCHAR(1)  NOT NULL DEFAULT 1 COMMENT '启用状态，0->禁用；1->启用',
    created_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted      VARCHAR(1)  NOT NULL DEFAULT 0 COMMENT '已删除 yes:1,no:0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_uuid (uuid)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '角色 ';

CREATE TABLE resource_role
(
    id            BIGINT     NOT NULL AUTO_INCREMENT COMMENT 'id',
    uuid          CHAR(36)   NOT NULL COMMENT 'uuid',
    resource_uuid CHAR(36)   NOT NULL COMMENT '资源uuid',
    role_uuid     CHAR(36)   NOT NULL COMMENT '角色uuid',
    created_time  DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time  DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted       VARCHAR(1) NOT NULL DEFAULT 0 COMMENT '已删除 yes:1,no:0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_uuid (uuid)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '资源_角色关联表 ';

CREATE TABLE resource
(
    id            BIGINT       NOT NULL AUTO_INCREMENT COMMENT 'id',
    uuid          CHAR(36)     NOT NULL COMMENT 'uuid',
    category_uuid CHAR(36)     NOT NULL COMMENT '资源分类ID',
    url           VARCHAR(64)  NOT NULL DEFAULT '' COMMENT 'URL',
    name          VARCHAR(64)  NOT NULL DEFAULT '' COMMENT '资源名字',
    description   VARCHAR(64)  NOT NULL DEFAULT '' COMMENT '资源描述',
    path          VARCHAR(64)  NOT NULL DEFAULT '' COMMENT '路径',
    component     VARCHAR(64)  NOT NULL DEFAULT '' COMMENT '组件',
    iconCls       VARCHAR(200) NOT NULL DEFAULT '' COMMENT '图标',
    keepAlive     VARCHAR(1)   NOT NULL DEFAULT 1 COMMENT '保活',
    requireAuth   VARCHAR(1)   NOT NULL DEFAULT 1 COMMENT '需要认证',
    parentId      CHAR(36)     NOT NULL DEFAULT '' COMMENT '父id',
    created_time  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted       VARCHAR(1)   NOT NULL DEFAULT 0 COMMENT '已删除 yes:1,no:0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_uuid (uuid)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '后台资源表,用于控制后台用户可以访问的接口，使用了Ant路径的匹配规则，可以使用通配符定义一系列接口的权限';

CREATE TABLE resource_category
(
    id           BIGINT       NOT NULL AUTO_INCREMENT COMMENT 'id',
    uuid         CHAR(36)     NOT NULL COMMENT 'uuid',
    name         VARCHAR(200) NOT NULL COMMENT '分类名称',
    sort         INT          NOT NULL COMMENT '排序',
    created_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    deleted      VARCHAR(1)   NOT NULL DEFAULT 0 COMMENT '已删除 yes:1,no:0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_uuid (uuid)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '资源分类表，在细粒度进行权限控制时，可能资源会比较多，所以设计了个资源分类的概念，便于给角色分配资源';


CREATE TABLE sidebar
(
    id           BIGINT       NOT NULL AUTO_INCREMENT COMMENT 'id',
    uuid         CHAR(36)     NOT NULL COMMENT 'uuid',
    parent_uuid  CHAR(36)     NOT NULL COMMENT '父级uuid',
    title        VARCHAR(64)  NOT NULL COMMENT '菜单名称',
    level        INT          NOT NULL COMMENT '菜单级数',
    sort         INT          NOT NULL COMMENT '菜单排序',
    name         VARCHAR(64)  NOT NULL COMMENT '前端名字',
    icon         VARCHAR(200) NOT NULL COMMENT '前端图标',
    hidden       VARCHAR(1)   NOT NULL DEFAULT 0 COMMENT '前端隐藏 隐藏1,不隐藏0',
    created_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted      VARCHAR(1)   NOT NULL DEFAULT 0 COMMENT '已删除 yes:1,no:0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_uuid (uuid)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '前端菜单表,用于控制用户可以访问的菜单';

CREATE TABLE sidebar_role
(
    id           BIGINT     NOT NULL AUTO_INCREMENT COMMENT 'id',
    uuid         CHAR(36)   NOT NULL COMMENT 'uuid',
    sidebar_uuid CHAR(36)   NOT NULL COMMENT '菜单uuid',
    role_uuid    CHAR(36)   NOT NULL COMMENT '角色uuid',
    created_time DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted      VARCHAR(1) NOT NULL DEFAULT 0 COMMENT '已删除 yes:1,no:0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_uuid (uuid)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '前端菜单_角色关联表';