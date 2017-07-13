package test;

import com.learnning.design_patterns.decorator_pattern.AbstractComponent;
import com.learnning.design_patterns.decorator_pattern.Component;
import com.learnning.design_patterns.decorator_pattern.Decorator1;
import com.learnning.design_patterns.decorator_pattern.Decorator2;
import org.junit.Test;

/**
 * 类 名 称：TestDecoratorPattern.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月13日
 */
public class TestDecoratorPattern {
    @Test
    public void testDecoratorPattern(){
        AbstractComponent component = new Component();
        component = new Decorator1(component);
        component = new Decorator2(component);
        component.operation();
    }
}
