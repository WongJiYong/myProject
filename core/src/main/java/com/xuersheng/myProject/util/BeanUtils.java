package com.xuersheng.myProject.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class BeanUtils extends org.springframework.beans.BeanUtils {

    /**
     * @param source the source bean
     * @param target the target bean
     */
    public static <T> List<T> copyList(Collection source, Class<T> target) {
        if (source == null || source.isEmpty()) {
            return Collections.emptyList();
        }
        List<T> targets = new ArrayList<>(source.size());
        try {
            for (Object o : source) {
                T t = target.newInstance();
                targets.add(t);
                copyProperties(o, t);
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return targets;
    }

    public static <T> List<T> copyListDeeply(Collection source, Class<T> target) {
        if (source == null || source.isEmpty()) {
            return Collections.emptyList();
        }
        List<T> targets = new ArrayList<>(source.size());
        try {
            for (Object o : source) {
                if (o == null) {
                    continue;
                }
                T t = target.newInstance();
                targets.add(t);
                copyPropertiesDeeply(o, t);
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return targets;
    }

    public static void copyPropertiesDeeply(Object source, Object target) throws BeansException {

        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");


        PropertyDescriptor[] targetPds = getPropertyDescriptors(target.getClass());

        for (PropertyDescriptor targetPd : targetPds) {
            Method writeMethod = targetPd.getWriteMethod();
            if (writeMethod == null) {
                continue;
            }
            PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
            if (sourcePd == null) {
                continue;
            }
            Method readMethod = sourcePd.getReadMethod();
            if (readMethod == null) {
                continue;
            }
            Class<?> returnType = readMethod.getReturnType();
            boolean matched = ClassUtils.isAssignable(writeMethod.getParameterTypes()[0], returnType);

            try {
                Object value = readMethod.invoke(source);
                //
                if (matched && Collection.class.isAssignableFrom(returnType)) {
                    Collection sourceList = (Collection) value;
                    Field targetField = target.getClass().getDeclaredField(targetPd.getName());
                    Field sourceField = source.getClass().getDeclaredField(sourcePd.getName());
                    Type targetType = targetField.getGenericType();
                    Type sourceType = sourceField.getGenericType();
                    Class<?> targetClass = (Class<?>) ((ParameterizedType) targetType).getActualTypeArguments()[0];
                    Class<?> sourceClass = (Class<?>) ((ParameterizedType) sourceType).getActualTypeArguments()[0];
                    if (!targetClass.isAssignableFrom(sourceClass) && !isSimpleValueType(targetClass)) {
                        value = copyListDeeply(sourceList, targetClass);
                    }
                } else if (!matched) {
                    if (isSimpleProperty(returnType)) {
                        continue;
                    }
                    //当作对象处理
                    Object o = null;
                    if (value != null) {
                        o = instantiateClass(targetPd.getPropertyType());
                        copyPropertiesDeeply(value, o);
                    }
                    value = o;
                }
                if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                    readMethod.setAccessible(true);
                }
                if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                    writeMethod.setAccessible(true);
                }
                writeMethod.invoke(target, value);
            } catch (Throwable ex) {
                throw new FatalBeanException(
                        "Could not copy property '" + targetPd.getName() + "' from source to target", ex);
            }
        }
    }

}
