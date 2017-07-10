package test;

import com.learnning.design_patterns.prototype_pattern.PrototypeClass;
import com.learnning.design_patterns.prototype_pattern.copy.CopyAny;
import com.learnning.design_patterns.prototype_pattern.copy.DeepCopy;
import org.junit.Test;

/**
 * 类 名 称：TestPrototypePattern.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月10日
 */
public class TestPrototypePattern {
    @Test
    public void testPrototype() throws CloneNotSupportedException {
        PrototypeClass prototypeClass = new PrototypeClass("美猴王");
        prototypeClass.show();

        PrototypeClass cloneClass = prototypeClass.clone();
        cloneClass.show();
    }

    @Test
    public void testConstructor() throws CloneNotSupportedException {
        PrototypeClass prototypeClass = new PrototypeClass("美猴王");
        PrototypeClass cloneClass = prototypeClass.clone();
    }

    @Test
    public void testCopy() throws CloneNotSupportedException {
        CopyAny copyAny = new CopyAny();
        copyAny.setList("二郎神");

        CopyAny copyAny1 = copyAny.clone();
        copyAny1.setList("哪吒");

        copyAny.show();
    }

    @Test
    public void testDeepCopy() throws CloneNotSupportedException {
        DeepCopy deepCopy = new DeepCopy();
        deepCopy.setList("二郎神");

        DeepCopy deepCopy1 = deepCopy.clone();
        deepCopy1.setList("哪吒");

        deepCopy.show();
        deepCopy1.show();
    }
}
