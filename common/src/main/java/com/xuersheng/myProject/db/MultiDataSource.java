package com.xuersheng.myProject.db;

import com.xuersheng.myProject.ThreadBox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 多数据源配置
 */
public class MultiDataSource extends AbstractRoutingDataSource {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected Object determineCurrentLookupKey() {
        String datasourceKey = ThreadBox.getDatasourceKey();
        logger.info("数据源:{}", datasourceKey);
        return datasourceKey;
    }

}
