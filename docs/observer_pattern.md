# 观察者模式（发布订阅模式）
## 定义
定义对象间一种一对多的依赖关系，使得每当一个对象改变状态，则所有依赖于它的对象都会得到通知并被自动更新。

我们来看下通用代码

```java
public interface Observer {

    void update();
}
public class ConcreteObserver implements Observer {
    public void update() {
        System.out.println("观察到被观察者有动作，");
    }
}
```
定义一个观察者接口，不通过的观察者有不同的任务需要执行
```java
public abstract class Subject {
    private Vector<Observer> obsVertor = new Vector<Observer>();

    public void addObserver(Observer observer) {
        obsVertor.add(observer);
    }

    public void removeObserver(Observer observer) {
        obsVertor.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : obsVertor) {
            observer.update();
        }
    }
}
public class ConcreteSubject extends Subject {
    public void doSomething() {
        System.out.println("被观察者有动作了");
        super.notifyObservers();
    }
}
```
定义被观察者，被观察者有一个抽象父类，负责管理观察者，并通知观察者

单元测试
```
    @Test
    public void testObserverPattern() {
        ConcreteSubject subject = new ConcreteSubject();
        Observer observer = new ConcreteObserver();

        subject.addObserver(observer);

        subject.doSomething();
    }
```
测试结果
```
被观察者有动作了
观察到被观察者有动作，
```
## 优点
* 观察者和被观察者之间的抽象耦合
* 建立一套触发机制
## 缺点
当观察者执行效率有问题时，将影响其他观察者，消息的通知是顺序执行的
## 扩展
* java世界中的观察者模式
>提供了java.util.Observable和java.util.Observer，继承Observable成为被观察者，JDK以及帮我维护好了观察者了

* 订阅发布模型
>可以了解下MQ机制，其实就是观察者模式的升级版