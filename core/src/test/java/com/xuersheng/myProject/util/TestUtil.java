package com.xuersheng.myProject.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

@Slf4j
public class TestUtil {

    public static <T> T randomObject(Class<T> clazz, String... fields) {
        try {
            T obj = BeanUtils.instantiateClass(clazz);
            for (String f : fields) {
                PropertyDescriptor propertyDescriptor = BeanUtils.getPropertyDescriptor(clazz, f);
                Assert.notNull(propertyDescriptor, "fields:" + f);
                Class<?> type = propertyDescriptor.getPropertyType();
                Object o = randomValue(type);
                Method writeMethod = propertyDescriptor.getWriteMethod();
                writeMethod.invoke(obj, o);
            }
            return obj;
        } catch (Exception e) {
            log.error("randomObject error", e);
        }
        throw new RuntimeException("randomObject error");
    }

    public static Object randomValue(Class<?> type) {
        if (type.equals(String.class)) {
            return UUID.randomUUID().toString();
        } else if (type.equals(Long.class)) {
            return new Random().nextLong();
        } else if (type.equals(Integer.class)) {
            return new Random().nextInt();
        } else if (type.equals(Boolean.class)) {
            return new Random().nextBoolean();
        }
        throw new RuntimeException("unknown type");
    }

    public static boolean equalsObjs(Object obj1, Object obj2, String... fields) {
        for (String field : fields) {
            PropertyDescriptor propertyDescriptor1 = BeanUtils.getPropertyDescriptor(obj1.getClass(), field);
            PropertyDescriptor propertyDescriptor2 = BeanUtils.getPropertyDescriptor(obj2.getClass(), field);
            assert propertyDescriptor1 != null;
            assert propertyDescriptor2 != null;
            Method readMethod1 = propertyDescriptor1.getReadMethod();
            Method readMethod2 = propertyDescriptor2.getReadMethod();
            try {
                Object r1 = readMethod1.invoke(obj1, (Object[]) null);
                Object r2 = readMethod2.invoke(obj2, (Object[]) null);
                log.info("{}:[{}=={}]", Objects.equals(r1, r2), r1, r2);
                if (!Objects.equals(r1, r2)) {
                    return false;
                }
            } catch (Exception e) {
                log.error("equalsObjs error", e);
            }
        }
        return true;
    }
}
