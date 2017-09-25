package com.learnning.design_patterns.flyweight_pattern;

/**
 * 类 名 称：ConcreteFlyweight.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年09月25日
 */
public class ConcreteFlyweight extends Flyweight {

    protected ConcreteFlyweight(String extrinsic) {
        super(extrinsic);
    }

    public void operate() {
        System.out.println("我是" + extrinsic + "的" + getIntrinsic());
    }
}
