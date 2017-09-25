package com.learnning.design_patterns.flyweight_pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * 类 名 称：FlyweightFactory.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年09月25日
 */
public class FlyweightFactory {
    public static Map<String, Flyweight> pool = new HashMap<String, Flyweight>();

    public static Flyweight getFlyweight(String extrinsic) {
        Flyweight flyweight;
        if (pool.containsKey(extrinsic)) {
            flyweight = pool.get(extrinsic);
        } else {
            flyweight = new ConcreteFlyweight(extrinsic);
            pool.put(extrinsic, flyweight);
        }
        return flyweight;
    }
}
