-- ---------------------------------------------------------------
-- 服务器版本:                    8.0.28 - MySQL Community Server --
-- 服务器系统:                    Linux                           --
-- ---------------------------------------------------------------

-- 创建数据库
DROP DATABASE IF EXISTS `fusion`;
CREATE DATABASE IF NOT EXISTS `fusion`;

-- 使用数据库
USE `fusion`;

-- 部门表
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`
(
    `id`             BIGINT      NOT NULL AUTO_INCREMENT COMMENT '部门id',
    `parent_id`      BIGINT      NOT NULL DEFAULT 0 COMMENT '父部门id',
    `name`           VARCHAR(32) NOT NULL COMMENT '部门名称',
    `leader_user_id` BIGINT      NULL     DEFAULT NULL COMMENT '负责人id',
    `mobile`         VARCHAR(11) NULL     DEFAULT NULL COMMENT '联系电话',
    `email`          VARCHAR(64) NULL     DEFAULT NULL COMMENT '邮箱',
    `sort`           INT         NOT NULL DEFAULT 0 COMMENT '显示排序',
    `status`         TINYINT     NOT NULL DEFAULT 1 COMMENT '部门状态(0-禁用 1-启用)',
    `create_by`      VARCHAR(64) NULL     DEFAULT '' COMMENT '创建用户',
    `create_time`    DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`      VARCHAR(64) NULL     DEFAULT '' COMMENT '更新用户',
    `update_time`    DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`        BIT(1)      NOT NULL DEFAULT b'0' COMMENT '逻辑删除(0-正常 1-删除)',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 10000
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT = '部门表';

-- 岗位表
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post`
(
    `id`          BIGINT       NOT NULL AUTO_INCREMENT COMMENT '岗位id',
    `name`        VARCHAR(64)  NOT NULL COMMENT '岗位名称',
    `code`        VARCHAR(128) NOT NULL COMMENT '岗位编码',
    `sort`        INT          NOT NULL DEFAULT 0 COMMENT '显示排序',
    `status`      TINYINT      NOT NULL DEFAULT 1 COMMENT '岗位状态(0-禁用 1-启用)',
    `remark`      VARCHAR(512) NULL     DEFAULT NULL COMMENT '备注',
    `create_by`   VARCHAR(64)  NULL     DEFAULT '' COMMENT '创建用户',
    `create_time` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`   VARCHAR(64)  NULL     DEFAULT '' COMMENT '更新用户',
    `update_time` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`     BIT(1)       NOT NULL DEFAULT b'0' COMMENT '逻辑删除(0-正常 1-删除)',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 10000
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT = '岗位表';

-- 用户表
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `id`              BIGINT       NOT NULL AUTO_INCREMENT COMMENT '岗位id',
    `username`        VARCHAR(32)  NOT NULL COMMENT '用户账号',
    `password`        VARCHAR(128) NOT NULL DEFAULT '' COMMENT '用户密码',
    `nickname`        VARCHAR(32)  NOT NULL COMMENT '用户昵称',
    `dept_id`         BIGINT       NULL     DEFAULT NULL COMMENT '部门id',
    `post_ids`        VARCHAR(255) NULL     DEFAULT NULL COMMENT '岗位编号数组',
    `email`           VARCHAR(64)  NULL     DEFAULT '' COMMENT '用户邮箱',
    `mobile`          VARCHAR(11)  NULL     DEFAULT '' COMMENT '手机号码',
    `gender`          TINYINT      NULL     DEFAULT 0 COMMENT '用户性别',
    `avatar`          VARCHAR(512) NULL     DEFAULT '' COMMENT '头像地址',
    `last_login_ip`   VARCHAR(64)  NULL     DEFAULT '' COMMENT '最后登录IP',
    `last_login_time` DATETIME     NULL     DEFAULT NULL COMMENT '最后登录时间',
    `status`          TINYINT      NOT NULL DEFAULT 1 COMMENT '账号状态(0-禁用 1-启用)',
    `remark`          VARCHAR(512) NULL     DEFAULT NULL COMMENT '备注',
    `create_by`       VARCHAR(64)  NULL     DEFAULT '' COMMENT '创建用户',
    `create_time`     DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`       VARCHAR(64)  NULL     DEFAULT '' COMMENT '更新用户',
    `update_time`     DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`         BIT(1)       NOT NULL DEFAULT b'0' COMMENT '逻辑删除(0-正常 1-删除)',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 10000
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT = '用户表';

-- 用户岗位表
DROP TABLE IF EXISTS `sys_user_post`;
CREATE TABLE `sys_user_post`
(
    `id`          BIGINT      NOT NULL AUTO_INCREMENT COMMENT 'id',
    `user_id`     BIGINT      NOT NULL COMMENT '用户id',
    `post_id`     BIGINT      NOT NULL COMMENT '岗位id',
    `create_by`   VARCHAR(64) NULL     DEFAULT '' COMMENT '创建用户',
    `create_time` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`   VARCHAR(64) NULL     DEFAULT '' COMMENT '更新用户',
    `update_time` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`     BIT(1)      NOT NULL DEFAULT b'0' COMMENT '逻辑删除(0-正常 1-删除)',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 10000
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT = '用户岗位表';

-- 角色表
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`
(
    `id`                  BIGINT       NOT NULL AUTO_INCREMENT COMMENT '角色id',
    `name`                VARCHAR(64)  NOT NULL COMMENT '角色名称',
    `code`                VARCHAR(128) NOT NULL COMMENT '角色编码',
    `data_scope`          TINYINT      NOT NULL DEFAULT 1 COMMENT '数据权限(1-全部数据权限 2-自定义数据权限 3-本部门数据权限 4-本部门及以下数据权限)',
    `data_scope_dept_ids` VARCHAR(512) NOT NULL DEFAULT '' COMMENT '数据范围(指定部门数组)',
    `type`                TINYINT      NOT NULL COMMENT '角色类型',
    `sort`                INT          NOT NULL DEFAULT 0 COMMENT '显示排序',
    `status`              TINYINT      NOT NULL DEFAULT 1 COMMENT '角色状态(0-禁用 1-启用)',
    `remark`              VARCHAR(512) NULL     DEFAULT NULL COMMENT '备注',
    `create_by`           VARCHAR(64)  NULL     DEFAULT '' COMMENT '创建用户',
    `create_time`         DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`           VARCHAR(64)  NULL     DEFAULT '' COMMENT '更新用户',
    `update_time`         DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`             BIT(1)       NOT NULL DEFAULT b'0' COMMENT '逻辑删除(0-正常 1-删除)',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 10000
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT = '角色表';

-- 用户角色表
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`
(
    `id`          BIGINT      NOT NULL AUTO_INCREMENT COMMENT 'id',
    `user_id`     BIGINT      NOT NULL COMMENT '用户id',
    `role_id`     BIGINT      NOT NULL COMMENT '角色id',
    `create_by`   VARCHAR(64) NULL     DEFAULT '' COMMENT '创建用户',
    `create_time` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`   VARCHAR(64) NULL     DEFAULT '' COMMENT '更新用户',
    `update_time` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`     BIT(1)      NOT NULL DEFAULT b'0' COMMENT '逻辑删除(0-正常 1-删除)',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 10000
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT = '用户角色表';

-- 菜单表
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`
(
    `id`             BIGINT       NOT NULL AUTO_INCREMENT COMMENT '菜单id',
    `parent_id`      BIGINT       NOT NULL DEFAULT 0 COMMENT '父菜单id',
    `name`           VARCHAR(64)  NOT NULL COMMENT '菜单名称',
    `permission`     VARCHAR(128) NOT NULL DEFAULT '' COMMENT '权限标识',
    `type`           TINYINT      NOT NULL COMMENT '菜单类型',
    `path`           VARCHAR(255) NULL     DEFAULT '' COMMENT '路由路径',
    `icon`           VARCHAR(64)  NULL     DEFAULT '' COMMENT '菜单图标',
    `component`      VARCHAR(255) NULL     DEFAULT NULL COMMENT '组件路径',
    `component_name` VARCHAR(255) NULL     DEFAULT NULL COMMENT '组件名称',
    `visible`        BIT(1)       NOT NULL DEFAULT b'1' COMMENT '是否可见(0-否 1-是)',
    `keepalive`      BIT(1)       NOT NULL DEFAULT b'1' COMMENT '是否缓存(0-否 1-是)',
    `always_show`    BIT(1)       NOT NULL DEFAULT b'1' COMMENT '是否总是显示(0-否 1-是)',
    `sort`           INT          NOT NULL DEFAULT 0 COMMENT '显示排序',
    `status`         TINYINT      NOT NULL DEFAULT 1 COMMENT '菜单状态(0-禁用 1-启用)',
    `create_by`      VARCHAR(64)  NULL     DEFAULT '' COMMENT '创建用户',
    `create_time`    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`      VARCHAR(64)  NULL     DEFAULT '' COMMENT '更新用户',
    `update_time`    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`        BIT(1)       NOT NULL DEFAULT b'0' COMMENT '逻辑删除(0-正常 1-删除)',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 10000
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT = '菜单表';

-- 角色菜单表
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`
(
    `id`          BIGINT      NOT NULL AUTO_INCREMENT COMMENT 'id',
    `role_id`     BIGINT      NOT NULL COMMENT '角色id',
    `menu_id`     BIGINT      NOT NULL COMMENT '菜单id',
    `create_by`   VARCHAR(64) NULL     DEFAULT '' COMMENT '创建用户',
    `create_time` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`   VARCHAR(64) NULL     DEFAULT '' COMMENT '更新用户',
    `update_time` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`     BIT(1)      NOT NULL DEFAULT b'0' COMMENT '逻辑删除(0-正常 1-删除)',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 10000
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT = '角色菜单表';