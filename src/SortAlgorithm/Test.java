package SortAlgorithm;

import java.lang.reflect.Array;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        int a[][] = {{10, 34}, {104, 314}, {310, 534}, {310, 234}, {1210, 234}, {150, 374}, {108, 394}};
//        Arrays.sort(a);
        //Arrays.sort(a, (e1, e2) -> e1[0] - e2[0]);
        //  Arrays.sort(a, (o1, o2) -> (o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]));

        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(12);
        list2.add(435);
        list2.add(214);
        list2.add(345);
        Collections.sort(list2, (e1, e2) -> e2 - e1);
//        Collections.sort(list2,new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                    return o1<o2 ? 1 : -1 ;
//                }
//        });
        System.out.println(list2);
        list2.remove(0);
        System.out.println(list2);
        list2.remove(0);
        System.out.println(list2);
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                } else return o2[0] - o1[0];
            }
        });
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%d,%d\n", a[i][0], a[i][1]);
        }
        System.out.println(a);
    }

}
