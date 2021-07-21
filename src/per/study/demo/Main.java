package per.study.demo;

public class Main {

    public static void main(String[] args) {
	    System.out.println("hello world!");
	    SingletonTestDemo demo1 = SingletonTestDemo.getInstance(); //获取SingletonTestDemo单例
        SingletonTestDemo demo2 = SingletonTestDemo.getInstance();
        singleTonTest(demo1, demo2);
        SingletonTestDemoByInnerClass demo3 = SingletonTestDemoByInnerClass.getInstance();
        SingletonTestDemoByInnerClass demo4 = SingletonTestDemoByInnerClass.getInstance();
        singleTonTest(demo3, demo4);
        SingletonTestDemoByEnum demo5 = SingletonTestDemoByEnum.getInstance();
        SingletonTestDemoByEnum demo6 = SingletonTestDemoByEnum.getInstance();
        singleTonTest(demo5, demo6);
        SingletonTestDemoByDCL demo7 = SingletonTestDemoByDCL.getInstance();
        SingletonTestDemoByDCL demo8 = SingletonTestDemoByDCL.getInstance();
        singleTonTest(demo7, demo8);
        demo1.doSomething();
        demo3.doSomething();
        demo5.doSomething();
        demo7.doSomething();
    }

    public static void singleTonTest (Object obj1, Object obj2) {
        System.out.println(obj1.getClass().getName()+" hashcode = " + obj1.hashCode());
        System.out.println(obj2.getClass().getName()+" hashcode = " + obj2.hashCode());
        if (obj1.equals(obj2)) {
            System.out.println("Singleton test success!");
        } else {
            System.out.println("Singleton test failure!");
        }
    }
}
