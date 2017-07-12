# 命令模式
## 定义
将一个请求封装成一个对象，从而让你使用不同的请求把客户端参数化，对请求排队或记录请求日志，可以提供命令的撤销和恢复功能

我们看下通用代码
```java
public abstract class AbstractReceive {
    protected abstract void doSomething();
}
public class Receive1 extends AbstractReceive {
    protected void doSomething() {
        System.out.println("执行者1——执行ing");
    }
}
public class Receive2 extends AbstractReceive {
    protected void doSomething() {
        System.out.println("执行者2——执行ing");
    }
}
```
接收者：命令执行的真是对象，可以有多个
```java
public abstract class AbstractCommand {
    protected AbstractReceive receive1 = new Receive1();
    protected AbstractReceive receive2 = new Receive2();

    protected abstract void execute();
}
public class Command1 extends AbstractCommand {
    protected void execute() {
        super.receive1.doSomething();
        super.receive2.doSomething();
    }
}
```
命令对象：最关键的是execute()方法，该对象主要是将多个操作封装成命令对象，供调用者使用
```java
public class Invoker {
    private AbstractCommand command;

    public void setCommand(AbstractCommand command) {
        this.command = command;
    }

    public void action() {
        this.command.execute();
    }
}
```
调用者接收外在的命令然后执行对应命令的execute()方法

单元测试
```
    @Test
    public void testCommandPattern(){
        Invoker invoker = new Invoker();
        AbstractCommand command = new Command1();
        invoker.setCommand(command);
        invoker.action();
    }
```
测试结果
```
执行者1——执行ing
执行者2——执行ing
```
## 优点
* 类间解耦
>调用者和接收者没有依赖关系，调用者只需要调用命令对象的execute()方法
* 可扩展性
>AbstractCommand的子类可以非常容易的扩展
* 命令模式结合其他模式会更优秀
>和责任链模式结合，实现命令族解析任务，和模板方法模式结合，可以减少AbstractCommand子类的膨胀问题

## 缺点
多个命令，命令子类也将很多，变得很庞大
## 反悔问题
比如，客户提出了一个需求，可是客户有不想要这个需求了，那么就涉及到反悔问题，有两个方法：
1. 结合备忘录模式还原最后状态，该方法适合接收者为状态的变更情况，而不适合做事件处理
2. 可以通过新的命令，实现事件回滚