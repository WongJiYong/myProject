package com.xuersheng.myProject.db;

/**
 * 数据源路由器
 * 必须是线程安全的
 */

public interface DataSourcesRouter {

    /**
     * 固网/C网
     */
    String NETWORK_TYPE = "networkType";
    /**
     * 在途/历史
     */
    String DB_TYPE = "dbType";
    /**
     * 分区编码
     */
    String PARTITION_CODE = "partitionCode";

    /**
     * @param obj 参数
     * @return 数据源路由码
     */
    String route(Object[] obj);

}
