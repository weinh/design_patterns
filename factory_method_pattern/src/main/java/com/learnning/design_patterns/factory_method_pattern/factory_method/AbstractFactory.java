package com.learnning.design_patterns.factory_method_pattern.factory_method;

import com.learnning.design_patterns.factory_method_pattern.Product;

/**
 * 类 名 称：AbstractFactory.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月06日
 */
public abstract class AbstractFactory {
    public abstract <T extends Product> T createProduct(Class clazz);
}
