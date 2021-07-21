package per.study.singleton.demo;

/**
 *实现单例模式的三要素：
 * 1.构造方法私有化。
 * 2.提供一个静态变量来保存这个类的唯一实例。
 * 3.对外提供一个获取该实例的public方法。
 * 实现单例模式的两种策略：
 * 1.饿汉模式：及在类加载时，就将该类实例化并保存在内存中。
 * 2.懒汉模式：即在实际使用该类实例时，才进行实例化。
 */
/* 饿汉模式：实现方式1， */
public class SingletonTestDemo {
    private static SingletonTestDemo instance = new SingletonTestDemo(); //在类加载时就创造实例
    /* 构造方法私有化，保证对象在外部无法生成 */
    private SingletonTestDemo() {

    }
    /* 提供获取对象实例的接口 */
    public static SingletonTestDemo getInstance() {
        return instance;
    }
    /* 提供实例方法 */
    public void doSomething() {
        System.out.println("this is my first singleton!");
    }
}
