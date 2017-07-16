# 策略模式（政策模式）
## 定义
定义一组算法，将每个算法都封装起来，并且使它们之间可以互换。

我们来看下通用代码
```java
public interface AbstractStrategy {
    void operation();
}
public class Strategy1 implements AbstractStrategy {
    public void operation() {
        System.out.println("策略1有话要说");
    }
}
public class Strategy2 implements AbstractStrategy {
    public void operation() {
        System.out.println("策略2有话要说");
    }
}
```
定义了一组算法，然后把他们封装起来
```java
public class Context {
    private AbstractStrategy strategy;

    public Context(AbstractStrategy strategy) {
        this.strategy = strategy;
    }

    public void operation() {
        this.strategy.operation();
    }
}
```
单元测试
```
    @Test
    public void testStrategy() {
        AbstractStrategy strategy1 = new Strategy1();
        Context context = new Context(strategy1);
        context.operation();

        AbstractStrategy strategy2 = new Strategy2();
        context = new Context(strategy2);
        context.operation();
    }
```
测试结果
```
策略1有话要说
策略2有话要说
```
策略模式使用了面向对象的继承和多态的机制

从源码上看，策略模式和代理模式还是有差别的，代理模式实现了同一个接口，而策略模式没有

## 优点
* 算法可以自由切换
* 避免使用多重条件判断
* 扩展性好，符合开闭原则
## 缺点
* 策略类的数量增多
* 所有策略类都需要对外暴露，违背了迪米特法则，可以结合工厂方法模式，代理模式，享元模式弥补
## 扩展——策略枚举
结合枚举类型，实现策略模式，代码如下
```java
public enum StrategyEnum {
    ADD("+") {
        public int exec(int a, int b) {
            return a + b;
        }
    },

    SUB("-") {
        public int exec(int a, int b) {
            return a - b;
        }
    };

    private String operation;

    StrategyEnum(String operation) {
        this.operation = operation;
    }

    public abstract int exec(int a, int b);
}
```
单元测试
```
    @Test
    public void testStrategyEnum() {
        System.out.println(StrategyEnum.ADD.exec(1, 2));
        System.out.println(StrategyEnum.SUB.exec(10, 1));
    }
```
测试结果
```
3
9
```
实现了一个类似计算器的功能，如果通过输入1,+,2，模拟操作那就更形象了

根据不同的输入使用不同的算法计算，而且具备良好的扩展性


