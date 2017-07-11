package test;

import com.learnning.design_patterns.mediator_pattern.AbstractMediator;
import com.learnning.design_patterns.mediator_pattern.Colleague1;
import com.learnning.design_patterns.mediator_pattern.Colleague2;
import com.learnning.design_patterns.mediator_pattern.Mediator;
import org.junit.Test;

/**
 * 类 名 称：TestMediatorPattern.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月11日
 */
public class TestMediatorPattern {
    @Test
    public void testMediatorPattern() {
        AbstractMediator mediator = new Mediator();
        Colleague1 c1 = new Colleague1(mediator);
        Colleague2 c2 = new Colleague2(mediator);
        mediator.setC1(c1);
        mediator.setC2(c2);

        c1.send("你吃了吗？");
        c2.send("没有！你要请我吃饭？");
    }
}
