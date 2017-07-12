package test;

import com.learnning.design_patterns.command_pattern.AbstractCommand;
import com.learnning.design_patterns.command_pattern.Command1;
import com.learnning.design_patterns.command_pattern.Invoker;
import org.junit.Test;

/**
 * 类 名 称：TestCommandPattern.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月12日
 */
public class TestCommandPattern {
    @Test
    public void testCommandPattern(){
        Invoker invoker = new Invoker();
        AbstractCommand command = new Command1();
        invoker.setCommand(command);
        invoker.action();
    }
}
