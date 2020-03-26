package com.xuersheng.util;

import java.util.HashMap;
import java.util.Map;

public class ThreadBox {

    private static ThreadLocal<Map<String, String>> datasourceKey = new ThreadLocal<>();

    static {
        datasourceKey.set(new HashMap<>(1));
    }

    public static void setDatasourceKey(String key) {
        datasourceKey.get().put("datasource", key);
    }

    public static String getDatasourceKey() {
        return datasourceKey.get().get("datasource");
    }

    public static void put(String key, String value) {
        datasourceKey.get().put(key, value);
    }
}
