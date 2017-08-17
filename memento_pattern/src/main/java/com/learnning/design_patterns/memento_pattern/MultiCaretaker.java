package com.learnning.design_patterns.memento_pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * 类 名 称：MultiCaretaker.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年08月17日
 */
public class MultiCaretaker {
    private Map<String, Memento> map = new HashMap<String, Memento>();

    public void setMemento(String idx, Memento memento) {
        map.put(idx, memento);
    }

    public Memento getMemento(String idx) {
        return map.get(idx);
    }
}
