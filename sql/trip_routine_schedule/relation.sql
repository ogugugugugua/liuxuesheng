CREATE TABLE tripuuid_routineuuid_routineserial
(
    id             BIGINT     NOT NULL AUTO_INCREMENT COMMENT 'id',
    uuid           CHAR(36)   NOT NULL COMMENT 'uuid',
    trip_uuid      CHAR(36)   NOT NULL COMMENT '某个旅途uuid',
    routine_uuid   CHAR(36)   NOT NULL COMMENT '旅途中某一天uuid',
    routine_serial INT        NOT NULL COMMENT '该天是第几天 用于排序',
    created_time   DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time   DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted        VARCHAR(1) NOT NULL DEFAULT 0 COMMENT '已删除 已删除 已删除为1,未删除为0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_uuid (uuid),
#     用于防止某个旅途的某一天被重复排序
    UNIQUE KEY uniq_trip_routineSerial (trip_uuid, routine_serial)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '某旅途id_该旅途某日安排id_该日在旅途第几天 ';


CREATE TABLE routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial
(
    id                 BIGINT     NOT NULL AUTO_INCREMENT COMMENT 'id',
    uuid               CHAR(36)   NOT NULL COMMENT 'uuid',
    routine_uuid       CHAR(36)   NOT NULL COMMENT '某一天uuid',
    schedule_uuid      CHAR(36)   NOT NULL COMMENT '当天某行程uuid',
    schedule_type_uuid CHAR(36)   NOT NULL COMMENT '该行程类型uuid',
    schedule_serial    INT        NOT NULL COMMENT '该行程序号 用于排序',
    created_time       DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time       DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted            VARCHAR(1) NOT NULL DEFAULT 0 COMMENT '已删除 已删除为1,未删除为0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_uuid (uuid),
#     用于防止某一天的某个行程被反复排序
    UNIQUE KEY uniq_routine_serial (routine_uuid, schedule_serial)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '某日安排id_该日某行程id_该行程类型id_该行程在该日中排序序号 ';


CREATE TABLE traveler_trip
(
    id            BIGINT     NOT NULL AUTO_INCREMENT COMMENT 'id',
    uuid          CHAR(36)   NOT NULL COMMENT 'uuid',
    trip_uuid     CHAR(36)   NOT NULL COMMENT '旅程uuid',
    traveler_uuid CHAR(36)   NOT NULL COMMENT '旅客uuid',
    student_uuid  CHAR(36)   NOT NULL COMMENT '留学生uuid',
    created_time  DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time  DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted       VARCHAR(1) NOT NULL DEFAULT 0 COMMENT '已删除 yes:1,no:0',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_uuid (uuid)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT = '旅客_旅程 一个旅客可以有多次不同旅程，一个旅程可以有多位不同旅客';