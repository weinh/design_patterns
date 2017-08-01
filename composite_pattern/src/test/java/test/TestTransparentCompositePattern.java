package test;

import com.learnning.design_patterns.composite_pattern.transparent.Component;
import com.learnning.design_patterns.composite_pattern.transparent.Composite;
import com.learnning.design_patterns.composite_pattern.transparent.Leaf;
import org.junit.Test;

/**
 * 类 名 称：TestCompositePattern.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年08月01日
 */
public class TestTransparentCompositePattern {
    @Test
    public void testTransparentCompositePattern() {
        Component root = new Composite("根节点");
        root.show();
        Component branch = new Composite("树枝节点");
        Component leaf = new Leaf("树叶节点");
        root.add(branch);
        branch.add(leaf);

        displayTransparent(root);
    }

    private void displayTransparent(Component root) {
        for (Component component : root.getChild()) {
            if (component instanceof Leaf) {
                component.show();
            } else {
                component.show();
                displayTransparent(component);
            }
        }
    }
}
