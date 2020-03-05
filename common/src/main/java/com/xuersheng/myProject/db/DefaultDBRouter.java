package com.xuersheng.myProject.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * 默认数据库路由器
 * 首先根据包名初步筛选
 */
public class DefaultDBRouter implements DataSourcesRouter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String route(Object[] objs) {
        for (Object obj : objs) {
            //计算分区编码
            PropertyDescriptor propertyDescriptor = BeanUtils.getPropertyDescriptor(obj.getClass(), PARTITION_CODE);
            if (propertyDescriptor != null) {
                Method readMethod = propertyDescriptor.getReadMethod();
                try {
                    return readMethod.invoke(obj).toString();
                } catch (Exception e) {
                    logger.error("计算路由码错误", e);
                }
                break;
            }

        }
        logger.error("未找到路由码");
        throw new RuntimeException("未找到路由码");
    }
}
