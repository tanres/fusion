package com.tanres.fusion.framework.mybatis.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.tanres.fusion.framework.mybatis.core.handler.DefaultMetaObjectHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Mybatis Plus 配置类
 */
@AutoConfiguration
@MapperScan("com.tanres.fusion")
public class MybatisAutoConfiguration {
    /**
     * 添加分页插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL)); // 如果配置多个插件, 切记分页最后添加
        return interceptor;
    }


    /**
     * 自动填充
     */
    @Bean
    public MetaObjectHandler metaObjectHandler() {
        return new DefaultMetaObjectHandler();
    }
}
