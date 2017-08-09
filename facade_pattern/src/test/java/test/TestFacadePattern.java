package test;

import com.learnning.design_patterns.facade_pattern.Facade;
import org.junit.Test;

/**
 * 类 名 称：TestFacadePattern.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年08月09日
 */
public class TestFacadePattern {
    @Test
    public void testFacadePattern() {
        Facade facade = new Facade();
        facade.doSomethingA();
        facade.doSomethingB();
        facade.doSomethingC();
    }
}
