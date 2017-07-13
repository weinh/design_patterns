# 装饰模式
## 定义
动态地给一个对象添加一些额外的职责，就新增功能来说，装饰模式相比生成子类更为灵活

我们来看下通用代码
```java
public interface AbstractComponent {
    void operation();
}
public class Component implements AbstractComponent {
    public void operation() {
        System.out.println("我是一只老虎");
    }
}
```
将需要装饰的对象抽象出来，然后具体实现进行装饰
```java
public abstract class Decorator implements AbstractComponent {
    private AbstractComponent component;

    public Decorator(AbstractComponent component) {
        this.component = component;
    }

    public void operation() {
        component.operation();
    }
}
public class Decorator1 extends Decorator {
    public Decorator1(AbstractComponent component) {
        super(component);
    }

    private void decoratorMethod(){
        System.out.println("我纸做的");
    }

    @Override
    public void operation() {
        decoratorMethod();
        super.operation();
    }
}
public class Decorator2 extends Decorator {
    public Decorator2(AbstractComponent component) {
        super(component);
    }

    private void decoratorMethod(){
        System.out.println("我是个玩具");
    }

    @Override
    public void operation() {
        super.operation();
        decoratorMethod();
    }
}
```
Decorator是装饰的抽象，这种写法如果仔细一看就知道使用了[代理模式](https://weinh.github.io/design_patterns/docs/proxy_pattern)，它的具体实现尽情了装饰原始组件

单元测试
```
    @Test
    public void testDecoratorPattern(){
        AbstractComponent component = new Component();
        component = new Decorator1(component);
        component = new Decorator2(component);
        component.operation();
    }
```
测试结果
```
我纸做的
我是一只老虎
我是个玩具
```
一只老虎，被装饰成了纸制的玩具

## 优点
* 装饰类和被装饰类可以独立扩展，而不会相互耦合
* 装饰模式是继承关系的一个替代方案
* 装饰模式可以动态的扩展一个实现类的功能

## 缺点
多层的装饰会变得复杂，像剥洋葱一样，一层一层的剥掉才知道里面是啥问题