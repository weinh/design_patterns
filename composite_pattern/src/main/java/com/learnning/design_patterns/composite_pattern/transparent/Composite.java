package com.learnning.design_patterns.composite_pattern.transparent;

import java.util.ArrayList;
import java.util.List;

/**
 * 类 名 称：Composite.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年08月01日
 */
public class Composite extends Component {

    private List<Component> list = new ArrayList<Component>();

    public Composite(String name) {
        super(name);
    }


    public void add(Component component) {
        list.add(component);
    }

    public List<Component> getChild() {
        return list;
    }
}
