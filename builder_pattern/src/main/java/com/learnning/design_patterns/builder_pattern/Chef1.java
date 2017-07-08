package com.learnning.design_patterns.builder_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 类 名 称：Chef1.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月07日
 */
public class Chef1 extends AbstractChef {
    private TomatoAndEggSoup tomatoAndEggSoup = new TomatoAndEggSoup();

    public void setSteps(List<String> steps) {
        tomatoAndEggSoup.setSteps(steps);
    }

    public AbstractFood cooking() {
        return tomatoAndEggSoup;
    }
}
