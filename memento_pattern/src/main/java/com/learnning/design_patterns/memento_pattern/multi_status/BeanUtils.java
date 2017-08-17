package com.learnning.design_patterns.memento_pattern.multi_status;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 类 名 称：BeanUtils.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年08月17日
 */
public class BeanUtils {
    public static Map<String, Object> backupProp(Object obj) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor prop[] = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : prop) {
                String fieldName = propertyDescriptor.getName();
                Method method = propertyDescriptor.getReadMethod();
                Object object = method.invoke(obj);
                if (!"class".equals(fieldName)) {
                    map.put(fieldName, object);
                }
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void restoreProp(Object obj, Map<String, Object> statusMap) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor prop[] = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : prop) {
                String fieldName = propertyDescriptor.getName();
                if (statusMap.containsKey(fieldName)) {
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(obj, new Object[]{statusMap.get(fieldName)});
                }
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
