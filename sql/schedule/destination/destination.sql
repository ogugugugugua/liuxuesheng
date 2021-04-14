CREATE TABLE destination_comment
(
    id             BIGINT   NOT NULL AUTO_INCREMENT COMMENT 'id',
    destination_id BIGINT   NOT NULL DEFAULT '' COMMENT '目的地id',
    comment_id     BIGINT   NOT NULL DEFAULT '' COMMENT '评论id',
    created_time   DATETIME NOT NULL DEFAULT '1971-01-01 00:00:00' COMMENT '创建时间',
    updated_time   DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '目的地及其评论列表';

CREATE TABLE destination_image
(
    id             BIGINT   NOT NULL AUTO_INCREMENT COMMENT 'id',
    destination_id BIGINT   NOT NULL DEFAULT '' COMMENT '目的地id',
    image_id       BIGINT   NOT NULL DEFAULT '' COMMENT '图片id',
    created_time   DATETIME NOT NULL DEFAULT '1971-01-01 00:00:00' COMMENT '创建时间',
    updated_time   DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '目的地及其图片列表';

CREATE TABLE destination_price
(
    id             BIGINT   NOT NULL AUTO_INCREMENT COMMENT 'id',
    destination_id BIGINT   NOT NULL DEFAULT '' COMMENT '目的地id',
    price_id       BIGINT   NOT NULL DEFAULT '' COMMENT '价格id',
    created_time   DATETIME NOT NULL DEFAULT '1971-01-01 00:00:00' COMMENT '创建时间',
    updated_time   DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '目的地及其收费项目列表';

CREATE TABLE destination_transportation
(
    id                BIGINT   NOT NULL AUTO_INCREMENT COMMENT 'id',
    destination_id    BIGINT   NOT NULL COMMENT '目的地id',
    transportation_id BIGINT   NOT NULL COMMENT '可用交通方式id',
    created_time      DATETIME NOT NULL DEFAULT '1971-01-01 00:00:00' COMMENT '创建时间',
    updated_time      DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '目的地及其可用交通方式列表';