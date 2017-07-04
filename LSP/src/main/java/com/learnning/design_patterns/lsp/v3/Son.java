package com.learnning.design_patterns.lsp.v3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 类 名 称：Son.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月04日
 */
public class Son extends Father {

    /**
     * 该方法覆盖了父类的方法，可是这种写法是错误的，
     * 子类的返回类型的范围必须比父类的小
     *
     * @param hashMap
     * @return
     */
//    public Collection doSomething(HashMap hashMap) {
//        return null;
//    }

    /**
     * 覆盖（覆写）方法，返回类型范围必须比父类的小，语法的要求
     *
     * @param hashMap
     * @return
     */
    @Override
    public ArrayList doSomething(HashMap hashMap) {
        return null;
    }

    /**
     * 重载方法 overload
     *
     * @param map
     * @return
     */
    public Collection doSomething(Map map) {
        return null;
    }
}
