package Pattern;
//饿汉式：在类加载时就完成了初始化，所以类加载比较慢，但获取对象的速度快。
//懒汉式：在类加载时不初始化，等到第一次被使用时才初始化。


//懒汉式 线程不安全
public class Singleton {
    private static Singleton singleton;
    private Singleton() {}
    public static Singleton getSingleton() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
//懒汉式 线程安全
/*
public class Singleton {
    private static Singleton singleton;
    private Singleton() {}
    public static synchronized Singleton getSingleton() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
 */


//饿汉式 线程安全
/*
public class Singleton {
    private static Singleton singleton=new Singleton();
    private Singleton() {}
    public static synchronized Singleton getSingleton() {
        return singleton;
    }
}
 */