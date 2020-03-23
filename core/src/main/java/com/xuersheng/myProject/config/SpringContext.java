package com.xuersheng.myProject.config;

import com.xuersheng.myProject.db.ConfigDBRouter;
import com.xuersheng.myProject.db.DataSourcesRouter;
import com.xuersheng.myProject.db.DefaultDBRouter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ImportResource(locations = "classpath:system/spring-context.xml")
public class SpringContext {

    @Bean(name = "routerMap")
    public Map<Class<? extends DataSourcesRouter>, DataSourcesRouter> routerMap() {
        Map<Class<? extends DataSourcesRouter>, DataSourcesRouter> routerMap = new HashMap<>();
        routerMap.put(DefaultDBRouter.class, new DefaultDBRouter());
        routerMap.put(ConfigDBRouter.class, new ConfigDBRouter());
        return routerMap;
    }

    /**
     *
     * @return 规则引擎取值
     */
//    @Bean(name = "getMethodServicesMap")
//    @Autowired
//    public Map<RuleGetMethodEnum, Function<NeTranRule, String>> getMethodServicesMap(
//            NeValueMapListServices neValueMapListService
//    ){
//
//        Map<RuleGetMethodEnum, Function<NeTranRule, String>>  methodServicesMap =  new HashMap<>();
//        methodServicesMap.put(RuleGetMethodEnum.MAPPING, neTranRule -> {
//            String nvmlCode = neTranRule.getNvmlCode();
//            return "";
//        });
//
//        return methodServicesMap;
//    }
}
