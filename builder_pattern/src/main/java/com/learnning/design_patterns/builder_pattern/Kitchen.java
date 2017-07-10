package com.learnning.design_patterns.builder_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 类 名 称：Kitchen.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月08日
 */
public class Kitchen {
    private Chef1 chef1 = new Chef1();
    private Chef2 chef2 = new Chef2();

    public TomatoAndEggSoup createTomatoAndEggSoup() {
        List<String> steps = new ArrayList<String>();
        steps.add("Water");
        steps.add("Tomatoes");
        steps.add("Eggs");
        chef1.setSteps(steps);
        return (TomatoAndEggSoup) chef1.cooking();
    }

    public TomatoScrambledEggs createTomatoScrambledEggs() {
        List<String> steps = new ArrayList<String>();
        steps.add("Oil");
        steps.add("Eggs");
        steps.add("Tomatoes");
        chef2.setSteps(steps);
        return (TomatoScrambledEggs) chef2.cooking();
    }
}
