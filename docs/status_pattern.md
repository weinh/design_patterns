# 状态模式
## 定义
当一个对象内在状态改变时允许其改变行为，这个对象看起来像改变了其类

我们来看下通用代码
```java
public abstract class Status {
    Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void handleStatus1();

    public abstract void handleStatus2();
}
public class ConcreteStatus1 extends Status {
    public void handleStatus1() {
        System.out.println("我时状态1");
    }

    public void handleStatus2() {
        System.out.println("即将切换到状态2");
        super.context.setCurrentStatus(Context.STATUS2);
        super.context.handleStatus2();
    }
}
public class ConCreteStatus2 extends Status {
    public void handleStatus1() {
        System.out.println("即将切换到状态1");
        super.context.setCurrentStatus(Context.STATUS1);
        super.context.handleStatus1();
    }

    public void handleStatus2() {
        System.out.println("我是状态2");
    }
}
```
首先定义一个状态接口或者抽象类，两个具体状态对象，状态接口或者抽象类，包含了本状态操作和过渡到其他状态的操作，状态切换的操作委托环境类执行
```java
public class Context {
    public static Status STATUS1 = new ConcreteStatus1();
    public static Status STATUS2 = new ConCreteStatus2();

    private Status currentStatus;

    public void setCurrentStatus(Status currentStatus) {
        this.currentStatus = currentStatus;
        this.currentStatus.setContext(this);
    }

    public void handleStatus1() {
        currentStatus.handleStatus1();
    }

    public void handleStatus2() {
        currentStatus.handleStatus2();
    }
}
```
环境对象，定义所有状态未常量，包含状态接口所有方法，方便委托执行，还有就是会指定当前是什么状态

单元测试
```
    @Test
    public void testStatusPattern() {
        Context context = new Context();
        context.setCurrentStatus(new ConcreteStatus1());
        context.handleStatus1();
        context.handleStatus2();
    }
```
测试结果
```
我时状态1
即将切换到状态2
我是状态2
```
状态模式有两个不成文的规定
1. 把状态声明为静态常量，有几个状态对象就声明几个静态常量
2. 环境角色具备状态抽象角色定义的所有行为，具体执行使用委托方式
## 优点
* 结构清晰
>避免过多的switch-case或if-else语句的使用，避免程序的复杂性，提高系统的可维护性
* 遵循设计原则
>很好的遵循了单一职责和开闭原则，维护一个状态，只要新增或修改对应子类就可以了
* 封装性好
>这是状态模式的基本要求，状态变更放在类的内部，外面不需要知道具体细节
## 缺点
唯一的一个缺点就是，状态很多的情况下，子类会很多，导致类膨胀，一般建议状态不要超过5个
## 使用场景
* 行为随着状态变换而改变的场景
* 条件，分支判断语句的替代者