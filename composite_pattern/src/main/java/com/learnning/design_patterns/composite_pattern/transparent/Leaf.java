package com.learnning.design_patterns.composite_pattern.transparent;

import java.util.List;

/**
 * 类 名 称：Leaf.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年08月01日
 */
public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Deprecated
    public void add(Component component) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public List<Component> getChild() {
        throw new UnsupportedOperationException();
    }
}
