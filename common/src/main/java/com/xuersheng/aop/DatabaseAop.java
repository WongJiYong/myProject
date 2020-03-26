package com.xuersheng.aop;

import com.xuersheng.util.ThreadBox;
import com.xuersheng.annotation.DataSource;
import com.xuersheng.db.DataSourcesRouter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Aspect
@Slf4j
@Order(Ordered.LOWEST_PRECEDENCE - 100)
@Component
public class DatabaseAop {

    private final ApplicationContext context;

    @Autowired
    public DatabaseAop(ApplicationContext context) {
        this.context = context;
    }


    @Pointcut("@within(com.xuersheng.annotation.DataSource) || @annotation(com.xuersheng.annotation.DataSource)")
    public void useDataSource() {
    }


    @Around("useDataSource()")
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
            DataSourcesRouter dbRouter = context.getBean(dBRouter);
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
