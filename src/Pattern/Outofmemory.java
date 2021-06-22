package Pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Outofmemory {
    public static void main(String[] args) {
        //testStatckOverFlowError();
        //testOutOfMemoryError();
        Object o=new Object();

        String s1="      123";
        System.out.println(s1.trim());
        String s2=new String("123");
        System.out.println(s1==s2);
    }

    private static void testOutOfMemoryError() {
        List<int[]> list = new ArrayList<int[]>();
        while (true) {
            int[] i = new int[666666666];    //666 没毛病....嘻嘻
            list.add(i);
        }
    }

    private static void testStatckOverFlowError() {
        testStatckOverFlowError();    //
    }

}
