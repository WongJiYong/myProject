package com.xuersheng.myProject.db;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据源路由器
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {

    /**
     *  直接使用路由码
     *  如果配置路由码直接使用
     */
    String value() default "";

    /**
     *  默认实现 DefaultDBRouter
     * @return 数据库路由器
     */
    Class<? extends DataSourcesRouter> router() default DefaultDBRouter.class;


    /**
     * 方法执行完毕 数据源是否切换回来
     * true：重置。false：不重置
     * @return 是否重置
     */
    boolean reset() default true;
}
