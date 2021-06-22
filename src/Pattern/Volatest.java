package Pattern;

/**
 * @author ：dazhu
 * @date ：Created in 2020/4/14 7:55
 * @description：
 * @modified By：
 * @version: $
 */
public class Volatest {
    public static void main(String[] args) {
        Node n0 = new Node(0);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 10; j++) {
                    n0.i++;
//                    try {
//                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println("i=" + n0.i + "thread name" + Thread.currentThread().getName());
                }
            }
        }
        );


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 10; j++) {
                    n0.i++;
//                    try {
//                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println("i=" + n0.i + "thread name" + Thread.currentThread().getName());
                }
            }
        });
        t1.start();
        t2.start();
    }
}

class Node {
    //i变量是否使用volatile修饰
    public int i;

    public Node(int i) {
        this.i = i;
    }
}