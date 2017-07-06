package com.learnning.design_patterns.singleton_pattern;

/**
 * 类 名 称：LazySingleton.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月06日
 */
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
