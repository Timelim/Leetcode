package Pattern;

//饿汉式：在类加载时就完成了初始化，所以类加载比较慢，但获取对象的速度快。
//懒汉式：在类加载时不初始化，等到第一次被使用时才初始化。

//双重校验锁
public class Singleton {
    private volatile static Singleton singleton;

    private Singleton() {
    }

    public static Singleton test() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    /*
    private static volatile Singleton singleton = null;中的volatile也必不可少，volatile关键字可以防止jvm指令重排优化，
    因为 singleton = new Singleton() 这句话可以分为三步：
     1. 为 singleton 分配内存空间；
     2. 初始化 singleton；
     3. 将 singleton 指向分配的内存空间。
    但是由于JVM具有指令重排的特性，执行顺序有可能变成 1-3-2。
    指令重排在单线程下不会出现问题，但是在多线程下会导致一个线程获得一个未初始化的实例。
    例如：线程T1执行了1和3，此时T2调用 getInstance() 后发现 singleton 不为空，因此返回 singleton，
    但是此时的 singleton 还没有被初始化。
    使用 volatile 会禁止JVM指令重排，从而保证在多线程下也能正常执行。
     */
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null)
                    singleton = new Singleton();
            }
        }
        return singleton;
    }

}

//懒汉式 线程不安全
/*
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
*/

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
//饿汉就是类一旦加载，就把单例初始化完成，保证getInstance的时候，单例是已经存在的了。
/*
public class Singleton {
    private static Singleton singleton=new Singleton();
    private Singleton() {}
    public static synchronized Singleton getSingleton() {
        return singleton;
    }
}
 */