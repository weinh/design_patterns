package com.learnning.design_patterns.factory_method_pattern.multiple_factory;

import com.learnning.design_patterns.factory_method_pattern.Product;
import com.learnning.design_patterns.factory_method_pattern.ProductA;

/**
 * 类 名 称：FactoryA.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月06日
 */
public class FactoryA extends AbstractMultipleFactory {
    public Product createProduct() {
        return new ProductA();
    }
}
