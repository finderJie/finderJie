package per.study.demo;

/**
 * 使用静态内部类的方式实现单例模式（懒汉模式）:
 * 使用jvm的类加载机制来保证线程安全及懒加载：
 * 当外部类SingletonTestDemoByInnerClass被加载时，内部类InnerClass并不会被加载，只有当外部调用getInstance方法使用到InnerClass类时，才
 * 会加载内部类同时创建SingletonTestDemoByInnerClass的实例。jvm在类加载的时候保证了线程安全性。
 */
public class SingletonTestDemoByInnerClass {
    private SingletonTestDemoByInnerClass instance;
    private SingletonTestDemoByInnerClass() {

    }
    private  static class InnerClass {
        public static SingletonTestDemoByInnerClass singleton = new SingletonTestDemoByInnerClass();
    }
    public static SingletonTestDemoByInnerClass getInstance() {
        return InnerClass.singleton;
    }
    public void doSomething() {
        System.out.println("this is the singleton created by inner class!");
    }
}
