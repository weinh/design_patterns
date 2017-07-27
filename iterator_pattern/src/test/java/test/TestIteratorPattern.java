package test;

import com.learnning.design_patterns.iterator_pattern.Aggregate;
import com.learnning.design_patterns.iterator_pattern.ConCreteAggregate;
import com.learnning.design_patterns.iterator_pattern.Iterator;
import org.junit.Test;

/**
 * 类 名 称：TestIteratorPattern.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月27日
 */
public class TestIteratorPattern {
    @Test
    public void testIteratorPattern() {
        Aggregate aggregate = new ConCreteAggregate();
        aggregate.add("1");
        aggregate.add("2");
        aggregate.add("3");
        Iterator iterator = aggregate.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
