package com.learnning.design_patterns.factory_method_pattern.multiple_factory;

import com.learnning.design_patterns.factory_method_pattern.Product;

/**
 * 类 名 称：AbstractMultipleFactory.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月06日
 */
public abstract class AbstractMultipleFactory {
    public abstract Product createProduct();
}
