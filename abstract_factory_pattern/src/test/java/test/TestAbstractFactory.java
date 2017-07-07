package test;

import com.learnning.design_patterns.abstract_factory_pattern.AbstractFactory;
import com.learnning.design_patterns.abstract_factory_pattern.AbstractProductA;
import com.learnning.design_patterns.abstract_factory_pattern.AbstractProductB;
import com.learnning.design_patterns.abstract_factory_pattern.Factory1;
import com.learnning.design_patterns.abstract_factory_pattern.Factory2;
import org.junit.Test;

/**
 * 类 名 称：TestAbstractFactory.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月07日
 */
public class TestAbstractFactory {
    @Test
    public void testAbstractFactory() {
        AbstractFactory abstractCreator1 = new Factory1();
        AbstractFactory abstractCreator2 = new Factory2();

        AbstractProductA productA1 = abstractCreator1.createProductA();
        productA1.introduce();
        AbstractProductB productB1 = abstractCreator1.createProductB();
        productB1.introduce();

        AbstractProductA productA2 = abstractCreator2.createProductA();
        productA2.introduce();
        AbstractProductB productB2 = abstractCreator2.createProductB();
        productB2.introduce();
    }
}
