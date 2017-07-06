# 单例模式
## 定义
确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例

## 优点
* 减少内存开支，特别是一个对象需要频繁地创建、销毁时，而且创建或销毁时性能无法优化
* 减少系统的性能开销，如果创建一个实例需要较多资源（读取配置或者较多的依赖对象）的时候，可以系统启动的时候首先产生单例对象，然后驻留在系统内存中
* 避免多资源的多重占用，比如一个写文件的操作，由于只有一个实例存在，避免对同一个资源文件的同时写操作
* 可以在系统设置全局访问点，优化和共享资源的访问

## 缺点
* 没有接口，扩展困难，若要扩展需要在原有基础上修改代码
* 对测试不利，在并行开发模式中，单例没有完成无法进行测试，没有接口也不能进行mock的方式虚拟一个对象
* 和单一职责原则有冲突，它将“要单例”和业务逻辑融合在一起了

## 单例的几种实现方式
### 饿汉模式
```java
public class HungrySingleton {

    /**
     * 自行实例化
     */
    private final static HungrySingleton hungrySingletion = new HungrySingleton();

    /**
     * 只有一个实例
     */
    private HungrySingleton() {
    }

    /**
     * 向系统提供实例对象
     *
     * @return
     */
    public static HungrySingleton getInstance() {
        return hungrySingletion;
    }
}
```
### 懒汉模式
```java
public class LazySingleton {
    private static LazySingleton lazySingleton = null;

    private LazySingleton() {

    }

    /**
     * 线程不安全
     *
     * @return
     */
//    public static LazySingleton getInstance() {
//        if (lazySingleton == null) {
//            lazySingleton = new LazySingleton();
//        }
//        return lazySingleton;
//    }

    /**
     * 线程安全，方案不是最优
     *
     * @return
     */
//    public synchronized static LazySingleton getInstance() {
//        if (lazySingleton == null) {
//            lazySingleton = new LazySingleton();
//        }
//        return lazySingleton;
//    }

    /**
     * 线程安全，方案也不是最优
     *
     * @return
     */
//    public static LazySingleton getInstance() {
//        synchronized (LazySingleton.class) {
//            if (lazySingleton == null) {
//                lazySingleton = new LazySingleton();
//            }
//            return lazySingleton;
//        }
//    }

    /**
     * 双重检查，以上两种方式的改进版本，不过要是该方式正常工作需要为lazySingleton增加volatile声明<br />
     *
     * 参考http://blog.csdn.net/fh09102103/article/details/48861187
     *
     * @return
     */
//    public static LazySingleton getInstance() {
//        if (lazySingleton == null) {
//            synchronized (LazySingleton.class) {
//                if (lazySingleton == null) {
//                    lazySingleton = new LazySingleton();
//                }
//            }
//        }
//        return lazySingleton;
//    }

    /**
     * 内部类加载，推荐使用方法
     */
    static class InitSingleton {
        static LazySingleton lazySingleton = new LazySingleton();
    }

    public static LazySingleton getInstance() {
        return InitSingleton.lazySingleton;
    }
}
```