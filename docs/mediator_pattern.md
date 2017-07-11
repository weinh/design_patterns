# 中介者模式（调停者模式）
## 定义
用一个中介对象封装一系列的对象交互，中介者使各对象不需要显示的相互作用，从而使其耦合松散，而且可以独立地改变它们之间的交互

来看一段代码，抽象同事类，同事类1，同事类2，同事类之间没有直接的交互，他们通过中介类联系
```java
public abstract class AbstractColleague {
    protected AbstractMediator mediator;

    public AbstractColleague(AbstractMediator mediator) {
        this.mediator = mediator;
    }
}
public class Colleague1 extends AbstractColleague {
    public Colleague1(AbstractMediator mediator) {
        super(mediator);
    }

    public void send(String message) {
        super.mediator.send(message, this);
    }

    void notify(String message) {
        System.out.println("同事1收到消息：" + message);
    }
}
public class Colleague2 extends AbstractColleague {
    public Colleague2(AbstractMediator mediator) {
        super(mediator);
    }

    public void send(String message) {
        super.mediator.send(message, this);
    }

    void notify(String message) {
        System.out.println("同事2收到消息：" + message);
    }
}
```
抽象中介类，具体中介类，他们才是和同事类真正交互的地方
```java

public abstract class AbstractMediator {
    protected Colleague1 c1;
    protected Colleague2 c2;

    public Colleague1 getC1() {
        return c1;
    }

    public void setC1(Colleague1 c1) {
        this.c1 = c1;
    }

    public Colleague2 getC2() {
        return c2;
    }

    public void setC2(Colleague2 c2) {
        this.c2 = c2;
    }

    protected abstract void send(String message, AbstractColleague colleague);
}
public class Mediator extends AbstractMediator {
    @Override
    protected void send(String message, AbstractColleague colleague) {
        if (c1.equals(colleague)) {
            c2.notify(message);
        } else if (c2.equals(colleague)) {
            c1.notify(message);
        }
    }
}
```
单元测试
```
    @Test
    public void testMediatorPattern() {
        AbstractMediator mediator = new Mediator();
        Colleague1 c1 = new Colleague1(mediator);
        Colleague2 c2 = new Colleague2(mediator);
        mediator.setC1(c1);
        mediator.setC2(c2);

        c1.send("你吃了吗？");
        c2.send("没有！你要请我吃饭？");
    }
```
测试结果
```
同事2收到消息：你吃了吗？
同事1收到消息：没有！你要请我吃饭？
```
## 优点
减少类间的依赖，将网状结果变为星型结构，同事类只需要依赖中介类，无需和其他同事类有依赖，降低了耦合性
## 缺点
中介者会膨胀得很大，逻辑会越变越复杂
## 使用场景
* 机场调度中心
>飞机要降落的时候会询问调度中心是否可以降落，降落到那个跑道等等问题
* MVC框架
>controller连接了model和view，使其解耦
* 媒体网关
>类似例子中表达的意思，c1和c2通信通过中介来完成
* 中介服务
>租房买房，通过中介，很多事情可以由中介代理办掉，自己只需要看房子是否满意，然后付钱就OK了
