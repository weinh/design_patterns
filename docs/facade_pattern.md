# 门面模式
## 定义
要求一个子系统的外部与其内部的通信都必须通过一个统一的对象进行，门面模式提供一个高层次的接口，使得子系统更易于使用。

我们来看下通用代码
```java
public class ClassA {
    public void doSomething() {
        System.out.println("A的业务");
    }
}
public class ClassB {
    public void doSomething() {
        System.out.println("B的业务");
    }
}
public class ClassC {
    public void doSomething() {
        System.out.println("C的业务");
    }
}
```
首先定义一个子系统，子系统可大可小，其实就是类的集合
```java
public class Facade {
    private ClassA a = new ClassA();
    private ClassB b = new ClassB();
    private ClassC c = new ClassC();

    public void doSomethingA() {
        a.doSomething();
    }

    public void doSomethingB() {
        b.doSomething();
    }

    public void doSomethingC() {
        c.doSomething();
    }
}
```
将子系统通过门面类封装起来供外部调用

单元测试
```
    @Test
    public void testFacadePattern() {
        Facade facade = new Facade();
        facade.doSomethingA();
        facade.doSomethingB();
        facade.doSomethingC();
    }
```
测试结果
```
A的业务
B的业务
C的业务
```
## 优点
* 减少系统的相互依赖，外部调用者不需要关系子系统的复杂逻辑，更方便的使用
* 提高灵活性，不管子系统内部如何变换，都不影响调用者
* 提高安全性，如果门面模式没有提供访问入口，你休想访问子系统
## 缺点
门面模式，不符合开闭原则，如果门面一旦定义好投入使用，以后需要变更只能修改该门面
## 扩展
* 一个子系统可以有多个门面

1、一般一个子系统一个门面就够了，可是当门面很庞大难以维护的时候就需要拆分成多个门面了，按照功能拆分是很好的选择

2、比如有两套外部系统，一套是可信的，可以开放所有方法，另一套是受限的只能访问某个方法，那么就需要新增门面了，代码如下
```java
public class FacadeA {
    private Facade facade = new Facade();

    public void doSomethingB() {
        facade.doSomethingB();
    }
}
```
这里为什么不是封装ClassB新建门面呢，主要是因为面向对象编程尽量不要写重复代码，避免修改的时候需要改多处
* 门面模式不参与业务逻辑

比如doSomethingB需要先调用doSomethingA再调用doSomethingB，很多人修改是
```
    public void doSomethingB() {
        a.doSomething();
        b.doSomething();
    }
```
我可以很明确的告诉你，这种做法是不可取的，因为门面模式参与了业务逻辑，依赖颠倒了，正常的操作应该如下：
```
public class ComplexClass {
    private ClassA a = new ClassA();
    private ClassB b = new ClassB();

    public void doSomething() {
        a.doSomething();
        b.doSomething();
    }
}
public class FacadeB {
    private ClassA a = new ClassA();
    private ComplexClass complexClass = new ComplexClass();
    private ClassC c = new ClassC();

    public void doSomethingA() {
        a.doSomething();
    }

    public void doSomethingB() {
        complexClass.doSomething();
    }

    public void doSomethingC() {
        c.doSomething();
    }
}
```
首先将业务逻辑封装起来，然后门面模式调用封装类的方法