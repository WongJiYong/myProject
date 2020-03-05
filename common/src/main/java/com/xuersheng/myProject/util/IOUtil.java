package com.xuersheng.myProject.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;

public class IOUtil {

    private static Logger logger = LoggerFactory.getLogger(IOUtil.class);

    public static void close(Closeable... objs) {
        if (objs == null)
            return;
        for (Closeable obj : objs) {
            if (obj != null) {
                try {
                    //必须要全部关闭
                    obj.close();
                } catch (IOException e) {
                    logger.error("关闭失败", e);
                }
            }

        }

    }
}
