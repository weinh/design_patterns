# 享元模式
## 定义
使用共享对象可有效的支持大量的细粒度的对象

下面来看下通用代码
```java
public abstract class Flyweight {
    private String intrinsic;
    protected final String extrinsic;

    protected Flyweight(String extrinsic) {
        this.extrinsic = extrinsic;
    }

    public abstract void operate();

    public String getIntrinsic() {
        return intrinsic;
    }

    public void setIntrinsic(String intrinsic) {
        this.intrinsic = intrinsic;
    }
}
public class ConcreteFlyweight extends Flyweight {

    protected ConcreteFlyweight(String extrinsic) {
        super(extrinsic);
    }

    public void operate() {
        System.out.println("我是" + extrinsic + "的" + getIntrinsic());
    }
}
```
享元模式，定义内部状态和外部状态
* 内部状态
>是对象可共享出来的信息，存储在享元对象内部并且不会随环境改变而改变，它们可以作为一个对象的动态附加信息，不必直接存在具体某个对象中，属于可以共享的部分
* 外部状态
>是对象的以依赖的一个标记，是随环境变化而变化的，不可以共享的状态

## 优点
一种简单的模式，可以大大减少应用程序创建的对象，降低程序内存的占用，增强程序性能
## 缺点
但同时提高了系统的复杂性，需要分离出内部状态和外部状态
## 使用场景
* 系统中存在大量的相似对象
* 细粒度的对象都具备较接近的外部状态，而且内部状态与环境无关
* 需要缓冲池的场景
## 扩展
### 线程安全
### 性能平衡
外部状态尽量使用java的基本类型，如果外部状态是自定义对象的话，需要重写equals和hashcode方法，自己写得性能差好多，执行会比较吗