package com.learnning.design_patterns.lsp.v2;

import java.util.Collection;
import java.util.HashMap;

/**
 * 类 名 称：Son.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月04日
 */
public class Son extends Father {
    public Collection doSomething(HashMap map){
        System.out.println("子类被执行");
        return map.values();
    }
}
