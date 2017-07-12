package com.learnning.design_patterns.chain_responsibility_pattern;

import java.util.Random;

/**
 * 类 名 称：Request.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月12日
 */
public class Request {
    public Level getRequestLevel() {
        Random random = new Random();
        return new Level(random.nextInt() % 3);
    }
}
