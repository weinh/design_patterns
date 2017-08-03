package test;

import com.learnning.design_patterns.observer_pattern.ConcreteObserver;
import com.learnning.design_patterns.observer_pattern.ConcreteSubject;
import com.learnning.design_patterns.observer_pattern.Observer;
import org.junit.Test;

/**
 * 类 名 称：TestObserverPattern.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年08月03日
 */
public class TestObserverPattern {
    @Test
    public void testObserverPattern() {
        ConcreteSubject subject = new ConcreteSubject();
        Observer observer = new ConcreteObserver();

        subject.addObserver(observer);

        subject.doSomething();
    }
}
