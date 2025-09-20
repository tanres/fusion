package com.tanres.fusion.framework.mybatis.core.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

/**
 * 通用参数自动填充处理
 * 如果没有显式对通用参数进行赋值，这里就会通用参数进行填充、赋值
 */
public class DefaultMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createBy", String.class, "admin");
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());

        this.strictInsertFill(metaObject, "updateBy", String.class, "admin");
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "updateBy", String.class, "admin");
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }
}
