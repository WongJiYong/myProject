package com.xuersheng.myProject;

public class ThreadBox {

    private static ThreadLocal<String> datasourceKey = new ThreadLocal<>();

    private static ThreadLocal<StringBuilder> logger = ThreadLocal.withInitial(StringBuilder::new);


    public static void setDatasourceKey(String datasourceKey) {
        ThreadBox.datasourceKey.set(datasourceKey);
    }

    public static String getDatasourceKey() {
        return datasourceKey.get();
    }

    public static StringBuilder logger(String msg) {
        return logger.get().append(msg);
    }

    public static StringBuilder loggerln(String msg) {
        return logger.get().append(msg).append("\r\n");
    }

}
