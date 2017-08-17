package test;

import com.learnning.design_patterns.memento_pattern.Caretaker;
import com.learnning.design_patterns.memento_pattern.MultiCaretaker;
import com.learnning.design_patterns.memento_pattern.Originator;
import org.junit.Test;

/**
 * 类 名 称：TestMementoPattern.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年08月17日
 */
public class TestMementoPattern {
    @Test
    public void testMementoPattern() {
        Originator originator = new Originator();
        originator.setStatus("原始状态");
        System.out.println("起始状态：" + originator.getStatus());

        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(originator.createMemento());

        originator.setStatus("变更后的状态");
        System.out.println("变更后的状态：" + originator.getStatus());

        originator.setMemento(caretaker.getMemento());
        System.out.println("恢复原始状态：" + originator.getStatus());
    }

    @Test
    public void testCloneMementoPattern() {
        com.learnning.design_patterns.memento_pattern.clone.Originator originator = new com.learnning.design_patterns.memento_pattern.clone.Originator();
        originator.setStatus("原始状态");
        System.out.println("原始状态：" + originator.getStatus());

        com.learnning.design_patterns.memento_pattern.clone.Caretaker caretaker = new com.learnning.design_patterns.memento_pattern.clone.Caretaker();
        caretaker.setOriginator(originator.createMemento());

        originator.setStatus("改变状态");
        System.out.println("变更后的状态：" + originator.getStatus());

        originator.restoreMemento(caretaker.getOriginator());
        System.out.println("恢复原始状态：" + originator.getStatus());
    }

    @Test
    public void testMultiStatusMementoPattern() {
        com.learnning.design_patterns.memento_pattern.multi_status.Originator originator = new com.learnning.design_patterns.memento_pattern.multi_status.Originator();
        originator.setStatus1("原始状态1");
        originator.setStatus2("原始状态2");
        originator.setStatus3("原始状态3");
        System.out.println("原始状态：" + originator);

        com.learnning.design_patterns.memento_pattern.multi_status.Caretaker caretaker = new com.learnning.design_patterns.memento_pattern.multi_status.Caretaker();
        caretaker.setMemento(originator.CreateMements());

        originator.setStatus1("变更状态1");
        originator.setStatus2("变更状态2");
        originator.setStatus3("变更状态3");
        System.out.println("变更状态：" + originator);

        originator.restoreMemento(caretaker.getMemento());
        System.out.println("恢复状态：" + originator);
    }

    @Test
    public void testMultiMementoPattern() {
        Originator originator = new Originator();
        originator.setStatus("原始状态");
        System.out.println("起始状态：" + originator.getStatus());

        MultiCaretaker caretaker = new MultiCaretaker();
        caretaker.setMemento("001", originator.createMemento());

        originator.setStatus("状态2");
        System.out.println("变更状态：" + originator.getStatus());
        caretaker.setMemento("002", originator.createMemento());

        originator.setMemento(caretaker.getMemento("001"));
        System.out.println("恢复到001状态——起始状态：" + originator.getStatus());

        originator.setMemento(caretaker.getMemento("002"));
        System.out.println("恢复到002状态——变更状态：" + originator.getStatus());
    }

    @Test
    public void testSafeMementoPattern() {
        com.learnning.design_patterns.memento_pattern.safe.Originator originator = new com.learnning.design_patterns.memento_pattern.safe.Originator();
        originator.setStatus("原始状态");
        System.out.println("起始状态：" + originator.getStatus());

        com.learnning.design_patterns.memento_pattern.safe.Caretaker caretaker = new com.learnning.design_patterns.memento_pattern.safe.Caretaker();
        caretaker.setMemento(originator.createMemento());

        originator.setStatus("变更状态");
        System.out.println("变更状态：" + originator.getStatus());

        originator.restoreMemento(caretaker.getMemento());
        System.out.println("恢复状态：" + originator.getStatus());
    }
}
