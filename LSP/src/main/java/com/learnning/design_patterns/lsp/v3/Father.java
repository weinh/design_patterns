package com.learnning.design_patterns.lsp.v3;

import java.util.HashMap;
import java.util.List;

/**
 * 类 名 称：Father.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月04日
 */
public class Father {
    public List doSomething(HashMap map){
        System.out.println("父类被执行");
        return null;
    }
}
