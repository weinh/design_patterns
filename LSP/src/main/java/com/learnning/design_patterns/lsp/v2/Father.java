package com.learnning.design_patterns.lsp.v2;

import java.util.Collection;
import java.util.Map;

/**
 * 类 名 称：Father.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月04日
 */
public class Father {
    public Collection doSomething(Map map){
        System.out.println("父类被执行");
        return map.values();
    }
}
