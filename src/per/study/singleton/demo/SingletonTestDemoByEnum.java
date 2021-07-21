package per.study.singleton.demo;


/* 使用枚举类实现单例模式, 这种方式为饿汉模式，不仅可以避免多线程问题，而且还能避免反序列化重新创建对象 */
public enum SingletonTestDemoByEnum {
    SINGLETON_TEST_DEMO_BY_ENUM;
    public void doSomething() {
        System.out.println("this is the enum singleton!");
    }

    public static SingletonTestDemoByEnum getInstance() {
        return SINGLETON_TEST_DEMO_BY_ENUM;
    }
}
