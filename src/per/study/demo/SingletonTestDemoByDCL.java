package per.study.demo;

/* 懒汉模式：使用双重校验锁实现线程安全的单例模式 */
public class SingletonTestDemoByDCL {
    /* 此处使用volatile关键字保证该变量对所有的线程可见
    * volatile关键字的作用：
    * 1.volatile修饰的变量不会在每个线程的工作内存中生成独立副本，它对所有的线程可见，因此任何线程对volatile的原子性操作都能保证线程安全。
    * 如：独立的赋值、或读取操作。每次访问volatile变量时都会进行一次值得刷新。
    * 2.volatile使用内存屏障的机制禁止了jvm的指令的重排序优化，防止某些情况下得依赖关系造成的空指针异常：
    * 线程不安全的根本原因就是INSTANCE = new Singleton5()不是原子操作。而是分为三步完成
    * 1、分配内存给这个对象
    * 2、初始化这个对象
    * 3、把INSTANCE变量指向初始化的对象
    * 正常情况下按照1 -> 2 -> 3的顺序执行，但是2和3可能会发生重排序，执行顺序变成1 -> 3 -> 2。如果是1 -> 3 -> 2的顺序执行。
    * 线程A执行完3，此时对象尚未初始化，但是INSTANCE变量已经不为null，线程B执行到synchronized关键字外部的if判断时，就直接返回了。
    * 此时线程B拿到的是一个尚未初始化完成的对象，可能会造成安全隐患。所以这种实现方式是线程不安全的。
    * 要向解决这个问题,就需要给单例变量加上volatile关键字修饰。
    * 3.volatile 变量 可用于线程间的标识判断，但不能对其进行依赖自身的操作。
    * 4.访问volatile变量不会造成线程阻塞，因此效率相对较高。
    *  */
    private static volatile SingletonTestDemoByDCL instance;
    /* 构造方法私有化，防止外部对该类进行实例化 */
    private SingletonTestDemoByDCL () {

    }
    /* 使用双重校验锁获得的单例模式为懒加载并且线程安全的，但存在反序列化会重新创建对象的缺陷 */
    public static SingletonTestDemoByDCL getInstance() {
        /* 第一重判断是否已创建实例，若已被某个线程创建实例，则其他线程就无须再获取锁，有效防止了其他线程因为获取不到锁而阻塞 */
        if (null == instance) {
            synchronized (SingletonTestDemoByDCL.class) {
                /* 第二重判断防止多个线程同时突破第一重非空，导致创建出多个实例 */
                if (null == instance) {
                    instance = new SingletonTestDemoByDCL();//创建实例
                }
            }
        }
        return instance;
    }
    /* 单例提供的方法 */
    public void doSomething() {
        System.out.println("this is the singleton created by DCL!");
    }
}
