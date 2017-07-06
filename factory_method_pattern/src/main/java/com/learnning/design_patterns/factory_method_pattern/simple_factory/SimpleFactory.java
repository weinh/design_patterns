package com.learnning.design_patterns.factory_method_pattern.simple_factory;

import com.learnning.design_patterns.factory_method_pattern.Product;

/**
 * 类 名 称：SimpleFactory.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月06日
 */
public class SimpleFactory {
    public static <T extends Product> T createProduct(Class clazz) {
        Product product = null;
        try {
            product = (T) Class.forName(clazz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("创建产品出错");
        }
        return (T) product;
    }
}
