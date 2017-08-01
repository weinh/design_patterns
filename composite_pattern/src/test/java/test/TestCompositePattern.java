package test;

import com.learnning.design_patterns.composite_pattern.Component;
import com.learnning.design_patterns.composite_pattern.Composite;
import com.learnning.design_patterns.composite_pattern.Leaf;
import org.junit.Test;

/**
 * 类 名 称：TestCompositePattern.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年08月01日
 */
public class TestCompositePattern {
    @Test
    public void testCompositePattern() {
        Composite root = new Composite("根节点");
        root.show();
        Composite branch = new Composite("树枝节点");
        Leaf leaf = new Leaf("树叶节点");
        root.add(branch);
        branch.add(leaf);

        display(root);
    }

    private void display(Composite root) {
        for (Component c : root.getChildren()) {
            if (c instanceof Leaf) {
                c.show();
            } else {
                c.show();
                display((Composite) c);
            }
        }
    }
}
