package com.xuersheng.myProject.aop;

import com.xuersheng.myProject.ThreadBox;
import com.xuersheng.myProject.db.DataSource;
import com.xuersheng.myProject.db.DataSourcesRouter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Map;


@Aspect
@Component
@Slf4j
@Order(Ordered.LOWEST_PRECEDENCE - 100)
public class DatabaseAop {

    @Resource(name = "routerMap")
    Map<Class<? extends DataSourcesRouter>, DataSourcesRouter> routerMap;


    @Pointcut("@within(com.xuersheng.myProject.db.DataSource) || @annotation(com.xuersheng.myProject.db.DataSource)")
    public void useDataSourceInClass() {
    }


    @Around("useDataSourceInClass()")
    public Object dataSourceSwitcherInClass(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        DataSource annotation = method.getAnnotation(DataSource.class);

        if (annotation == null) {
            annotation = joinPoint.getTarget().getClass().getAnnotation(DataSource.class);
        }
        //设置数据源
        String oldKey = ThreadBox.getDatasourceKey();
        String value = annotation.value();
        String routeCode;
        if (!value.isEmpty()) {
            routeCode = value;
        } else {
            Class<? extends DataSourcesRouter> dBRouter = annotation.router();
            DataSourcesRouter dbRouter = routerMap.get(dBRouter);
            Object[] args = joinPoint.getArgs();
            routeCode = dbRouter.route(args);
        }
        try {
            ThreadBox.setDatasourceKey(routeCode);
            //执行方法
            return joinPoint.proceed();
        } finally {
            if (annotation.reset()) {
                ThreadBox.setDatasourceKey(oldKey);
            }
        }
    }


}
