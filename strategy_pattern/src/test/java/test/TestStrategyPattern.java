package test;

import com.learnning.design_patterns.strategy_pattern.AbstractStrategy;
import com.learnning.design_patterns.strategy_pattern.Context;
import com.learnning.design_patterns.strategy_pattern.Strategy1;
import com.learnning.design_patterns.strategy_pattern.Strategy2;
import com.learnning.design_patterns.strategy_pattern.StrategyEnum;
import org.junit.Test;

/**
 * 类 名 称：TestStrategyPattern.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月16日
 */
public class TestStrategyPattern {
    @Test
    public void testStrategy() {
        AbstractStrategy strategy1 = new Strategy1();
        Context context = new Context(strategy1);
        context.operation();

        AbstractStrategy strategy2 = new Strategy2();
        context = new Context(strategy2);
        context.operation();
    }

    @Test
    public void testStrategyEnum() {
        System.out.println(StrategyEnum.ADD.exec(1, 2));
        System.out.println(StrategyEnum.SUB.exec(10, 1));
    }
}
