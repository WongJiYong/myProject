package com.xuersheng.util;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;

@Slf4j
public class IOUtil {


    public static void close(Closeable... objs) {
        if (objs == null)
            return;
        for (Closeable obj : objs) {
            if (obj != null) {
                try {
                    //必须要全部关闭
                    obj.close();
                } catch (IOException e) {
                    log.error("关闭失败", e);
                }
            }

        }

    }
}
