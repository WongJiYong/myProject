package com.xuersheng.db;

/**
 * 数据源路由器
 * 必须是线程安全的
 */

public interface DataSourcesRouter {

    /**
     * @param obj 参数
     * @return 数据源路由码
     */
    String route(Object[] obj);

}
