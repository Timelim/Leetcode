package Pattern;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StaticNum {
    static int x = 0;

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //  lock.lock();
                x += 1;
                try {
                    TimeUnit.MILLISECONDS.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("1:" + x);
                //  lock.unlock();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //lock.lock();
                x += 1;

                System.out.println("2:" + x);
                // lock.unlock();
            }
        });
        t.start();
        t2.start();
        System.out.println("main:" + x);
    }
}
