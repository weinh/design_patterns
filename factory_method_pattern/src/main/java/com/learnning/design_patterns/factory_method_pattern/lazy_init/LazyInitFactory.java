package com.learnning.design_patterns.factory_method_pattern.lazy_init;

import com.learnning.design_patterns.factory_method_pattern.Product;
import com.learnning.design_patterns.factory_method_pattern.ProductA;
import com.learnning.design_patterns.factory_method_pattern.ProductB;

import java.util.HashMap;
import java.util.Map;

/**
 * 类 名 称：LazyInitFactory.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月06日
 */
public class LazyInitFactory {
    private final static Map<String, Product> products = new HashMap<String, Product>();

    public synchronized static Product createProduct(String type) {
        Product product = null;
        if (products.containsKey(type)) {
            product = products.get(type);
        } else {
            if ("productA".equals(type)) {
                product = new ProductA();
            } else {
                product = new ProductB();
            }
            products.put(type, product);
        }
        return product;
    }
}
