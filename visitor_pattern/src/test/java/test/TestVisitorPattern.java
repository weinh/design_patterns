package test;

import com.learnning.design_patterns.visitor_pattern.Element;
import com.learnning.design_patterns.visitor_pattern.Element1;
import com.learnning.design_patterns.visitor_pattern.IElement;
import com.learnning.design_patterns.visitor_pattern.IVisitor;
import com.learnning.design_patterns.visitor_pattern.Visitor;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 类 名 称：TestVisitorPattern.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年08月23日
 */
public class TestVisitorPattern {
    @Test
    public void testVisitorPattern() {
        List<IElement> list = new ArrayList<IElement>();
        IElement elementA = new Element("a");
        IElement elementB = new Element1("b");
        IElement elementC = new Element("c");
        IElement elementD = new Element1("d");
        list.add(elementA);
        list.add(elementB);
        list.add(elementC);
        list.add(elementD);
        for (IElement element : list) {
            element.accept(new Visitor());
        }
    }
}
