package com.xuersheng.myProject.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * 配置库路由器
 */
public class ConfigDBRouter implements DataSourcesRouter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 配置库 只关心C网还是g网
     *
     * @param objs 参数
     * @return 数据源路由码
     */
    @Override
    public String route(Object[] objs) {
        for (Object obj : objs) {
            PropertyDescriptor propertyDescriptor = BeanUtils.getPropertyDescriptor(obj.getClass(), NETWORK_TYPE);
            if (propertyDescriptor != null){
                Method readMethod = propertyDescriptor.getReadMethod();
                try {
                    Object o = readMethod.invoke(obj);
                    return o + "_CONFIG";
                } catch (Exception e) {
                    logger.error("计算数据源路由码异常:", e);
                }
                //只执行一次
                break;
            }
        }
        logger.error("未找到路由码");
        throw new RuntimeException("未找到路由码");
    }
}
