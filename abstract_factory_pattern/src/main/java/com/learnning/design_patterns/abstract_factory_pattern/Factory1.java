package com.learnning.design_patterns.abstract_factory_pattern;

/**
 * 类 名 称：Factory1.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月07日
 */
public class Factory1 extends AbstractFactory {
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}
