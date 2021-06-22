package Pattern;

public class P1 {
    //饱汉
    static class Singleton1 {
        private static Singleton1 singleton1 = new Singleton1();

        private Singleton1() {
        }

        public static synchronized Singleton1 getInstance() {
            return singleton1;
        }
    }

    //饿汉
    static class Singleton2 {
        private static Singleton2 singleton2;

        private Singleton2() {
        }

        public static synchronized Singleton2 getInstance() {
            if (singleton2 == null)
                singleton2 = new Singleton2();
            return singleton2;
        }
    }

    //双重校验
    static class Singleton3 {
        private static volatile Singleton3 singleton3;

        private Singleton3() {
        }

        public static Singleton3 getInstance() {
            if (singleton3 == null) {
                synchronized (Singleton3.class) {
                    if (singleton3 == null) {
                        singleton3 = new Singleton3();
                    }
                }
            }
            return singleton3;
        }
    }
}
