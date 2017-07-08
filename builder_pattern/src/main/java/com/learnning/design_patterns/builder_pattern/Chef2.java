package com.learnning.design_patterns.builder_pattern;

import java.util.List;

/**
 * Created by weinh on 2017/7/8.
 */
public class Chef2 extends AbstractChef {
    private TomatoScrambledEggs tomatoScrambledEggs = new TomatoScrambledEggs();

    public void setSteps(List<String> steps) {
        tomatoScrambledEggs.setSteps(steps);
    }

    public AbstractFood cooking() {
        return tomatoScrambledEggs;
    }
}
