package com.xuersheng.myProject.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;

@Slf4j
public class TestUtil {

    public static <T> T randomObject(Class<T> clazz, String... fields) {
        try {
            assert fields != null;
            PropertyDescriptor[] propertyDescriptors;
            if (fields.length < 1) {
                propertyDescriptors = BeanUtils.getPropertyDescriptors(clazz);
            } else {
                PropertyDescriptor[] t = new PropertyDescriptor[fields.length];
                for (int i = 0; i < fields.length; i++) {
                    t[i] = BeanUtils.getPropertyDescriptor(clazz, fields[i]);
                }
                propertyDescriptors = t;
            }
            T obj = BeanUtils.instantiateClass(clazz);
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                Class<?> type = propertyDescriptor.getPropertyType();
                Object o = randomValue(type);
                if (o != null) {
                    Method writeMethod = propertyDescriptor.getWriteMethod();
                    writeMethod.invoke(obj, o);
                }
            }
            return obj;
        } catch (Exception e) {
            log.error("randomObject error", e);
        }
        throw new RuntimeException("randomObject error");
    }

    public static Object randomValue(Class<?> type) {
        if (String.class.isAssignableFrom(type)) {
            return UUID.randomUUID().toString();
        } else if (Long.class.isAssignableFrom(type)) {
            return new Random().nextLong();
        } else if (Integer.class.isAssignableFrom(type)) {
            return new Random().nextInt();
        } else if (Boolean.class.isAssignableFrom(type)) {
            return new Random().nextBoolean();
        } else if (Date.class.isAssignableFrom(type)) {
            return new Date();
        } else if (List.class.isAssignableFrom(type)) {
            return Collections.emptyList();
        } else if (Set.class.isAssignableFrom(type)) {
            return Collections.emptySet();
        } else if ((Map.class.isAssignableFrom(type))) {
            return Collections.emptyMap();
        }
        return null;
    }

    /**
     * 比较两个对象内的属性是否相等。
     * 如果不提供fields 则比较两个对象都有的简单属性
     *
     * @param obj1   obj1
     * @param obj2   obj2
     * @param fields 比较字段
     * @return 是否相等
     */
    public static boolean equalsObjs(Object obj1, Object obj2, String... fields) {
        String[] targetFields = fields;
        if (fields.length < 1) {
            List<String> sourceDescList = new ArrayList<>();
            List<String> targetDescList = new ArrayList<>();
            PropertyDescriptor[] source = BeanUtils.getPropertyDescriptors(obj1.getClass());
            PropertyDescriptor[] target = BeanUtils.getPropertyDescriptors(obj2.getClass());
            for (PropertyDescriptor sourceDesc : source) {
                sourceDescList.add(sourceDesc.getName());
            }
            for (PropertyDescriptor targetDesc : target) {
                targetDescList.add(targetDesc.getName());
            }
            sourceDescList.retainAll(targetDescList);
            sourceDescList.remove("class");
            targetFields = sourceDescList.toArray(new String[0]);
        }
        for (String field : targetFields) {
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

    public static String obj2UrlParams(Object mapObject, String... fields) {
        if (mapObject == null){
            return "";
        }
        StringBuilder sb = object2UrlString("", mapObject, fields);
        sb.replace(0, 1, "?");
        return sb.toString();
    }

    private static StringBuilder object2UrlString(String prefix, Object mapObject, String... fields) {
        String[] targetFields = fields;
        List<String> pFields = new ArrayList<>();
        if (fields.length < 1) {
            PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(mapObject.getClass());
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                if (!"class".equals(propertyDescriptor.getName())) {
                    pFields.add(propertyDescriptor.getName());
                }
            }
            targetFields = pFields.toArray(new String[0]);
        }
        StringBuilder sb = new StringBuilder();
        for (String field : targetFields) {
            PropertyDescriptor descriptor = BeanUtils.getPropertyDescriptor(mapObject.getClass(), field);
            if (descriptor == null) {
                continue;
            }
            boolean simpleProperty = BeanUtils.isSimpleProperty(descriptor.getPropertyType());
            Method readMethod = descriptor.getReadMethod();
            try {
                Object value = readMethod.invoke(mapObject);
                if (value == null) {
                    continue;
                }
                if (simpleProperty) {
                    sb.append("&");
                    if (StringUtils.hasText(prefix)) {
                        sb.append(prefix).append(".");
                    }
                    sb.append(field).append("=").append(value.toString());
                } else {
                    sb.append(object2UrlString(field, value, fields));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sb;
    }
}
