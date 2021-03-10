package bd;

import java.util.*;

public class ZJ10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, M, P;
        while (scanner.hasNext()) {
            N = scanner.nextInt();
            M = scanner.nextInt();
            P = scanner.nextInt();
            int idea[][] = new int[P][5];
            for (int i = 0; i < P; i++) {
                idea[i][0] = scanner.nextInt();
                idea[i][1] = scanner.nextInt();
                idea[i][2] = scanner.nextInt();
                idea[i][3] = scanner.nextInt();
                idea[i][4] = i;
            }
            Arrays.sort(idea, ((o1, o2) -> {
                if (o1[2] != o2[2])
                    return o2[2] - o1[2];
                else {
                    if (o1[3] != o2[3]) {
                        return o2[3] - o1[3];
                    } else {
                        return o2[2] - o1[2];
                    }
                }
            }));
//            for (int i = 0; i < P; i++) {
//                System.out.printf("%d %d %d %d\n", idea[i][0], idea[i][1], idea[i][2], idea[i][3]);
//            }
            int les = P;
            int time = 0;
            int res[] = new int[P];
            HashMap<Integer, Integer> thread = new HashMap<>();
//            for (int i = 0; i < Math.min(M, P); i++) {
//                if (idea[i][1] == 0)
//                    thread.put(i, 0);
//            }
            while (les != 0) {
//                System.out.println("time:" + time);
//                for (int i = 0; i < P; i++) {
//                    System.out.printf("%d %d %d %d\n", idea[i][0], idea[i][1], idea[i][2], idea[i][3]);
//                }
//                System.out.println("------------------");
                for (int i = 0; i < P; i++) {
                    if (idea[i][3] != 0 && idea[i][1] <= time && !thread.containsKey(i) && thread.size() < M) {
//                        System.out.println("time:"+time);
//                        System.out.println("i:"+i);
                        thread.put(i, 0);
                    }
                }
                time++;
                Map.Entry<Integer, Integer> item;
                Iterator<Map.Entry<Integer, Integer>> it = thread.entrySet().iterator();
                while (it.hasNext()) {
                    item = it.next();
                    int key = item.getKey();
                    idea[key][3] -= 1;
                    if (idea[key][3] == 0) {
                        res[idea[key][4]] = time;
                        //  System.out.printf("key:%d time:%d\n", key, time);
                        it.remove();
                        les--;
                    }
                }

            }
            for (int i = 0; i < P; i++)
                System.out.println(res[i]);
        }
    }
}
/*
产品经理(PM)有很多好的idea，而这些idea需要程序员实现。现在有N个PM，在某个时间会想出一个 idea，每个 idea 有提出时间、所需时间和优先等级。
对于一个PM来说，最想实现的idea首先考虑优先等级高的，相同的情况下优先所需时间最小的，还相同的情况下选择最早想出的，没有 PM 会在同一时刻提出两个 idea。
同时有M个程序员，
每个程序员空闲的时候就会查看每个PM尚未执行并且最想完成的一个idea,然后从中挑选出所需时间最小的一个idea独立实现，
如果所需时间相同则选择PM序号最小的。直到完成了idea才会重复上述操作。如果有多个同时处于空闲状态的程序员，那么他们会依次进行查看idea的操作。
求每个idea实现的时间。
输入第一行三个数N、M、P，分别表示有N个PM，M个程序员，P个idea。随后有P行，每行有4个数字，分别是PM序号、提出时间、优先等级和所需时间。
输出P行，分别表示每个idea实现的时间点。
输入描述:
输入第一行三个数N、M、P，分别表示有N个PM，M个程序员，P个idea。随后有P行，每行有4个数字，分别是
PM序号、提出时间、优先等级和所需时间。
全部数据范围 [1, 3000]。
输出描述:
输出P行，分别表示每个idea实现的时间点。
输入
2 2 5
1 1 1 2
1 2 1 1
1 3 2 2
2 1 1 2
2 3 5 5
---------
a b c d e
t=3 a d

输出
3
4
5
3
9
 */