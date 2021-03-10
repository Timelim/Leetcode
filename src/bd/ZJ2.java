package bd;

import java.util.Scanner;

public class ZJ2 {
    public static void main(String[] args) {
        int t;
        long n, k, d1, d2;
        Scanner cin = new Scanner(System.in);
        t = cin.nextInt();
        while (t > 0) {
            t--;
            n = cin.nextLong();
            k = cin.nextLong();
            d1 = cin.nextLong();
            d2 = cin.nextLong();
            long les = n - k;
            if (les == 0 && (d1 != 0 || d2 != 0))
                System.out.println("no");
            else if(n%3!=0){
                System.out.println("no");
            }
            else if (d1 > n / 3 || d2 > n / 3) {
                System.out.println("no");
            } else {
                //一共有n分,剩余分数n-k
                //1>2 2>3

                if ((les - d1 - d2 - d1) >= 0 && (les - d1 - d2 - d1) % 3 == 0) {
                    //System.out.println(1);
                    System.out.println("yes");
                }
                //1>2 2<3
                else if (d1 > d2 && les - d1 - d1 + d2 >= 0 && (les - d1 - d1 + d2) % 3 == 0) {
                    //System.out.println(2);
                    System.out.println("yes");
                } else if (d2 > d1 && les - d2 - d2 + d1 >= 0 && (les - d2 - d2 + d1) % 3 == 0) {
                    //System.out.println(3);
                    System.out.println("yes");
                } else if ((les - d1 - d2) >= 0 && (les - d1 - d2) % 3 == 0) {
                    //System.out.println(4);
                    System.out.println("yes");

                }//1<2 2<3
                else if (les - d2 - d1 - d2 > 0 && (les - d2 - d1 - d2) % 3 == 0) {
                    //System.out.println(5);
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }

            }
        }
    }
}
/*

有三只球队，每只球队编号分别为球队1，球队2，球队3，这三只球队一共需要进行 n 场比赛。现在已经踢完了k场比赛，
每场比赛不能打平，踢赢一场比赛得一分，输了不得分不减分。已知球队1和球队2的比分相差d1分，球队2和球队3的比分相差d2分，
每场比赛可以任意选择两只队伍进行。求如果打完最后的 (n-k) 场比赛，有没有可能三只球队的分数打平。  
输入描述:
第一行包含一个数字 t (1 <= t <= 10)
接下来的t行每行包括四个数字 n, k, d1, d2(1 <= n <= 10^12; 0 <= k <= n, 0 <= d1, d2 <= k)
输出描述:
每行的比分数据，最终三只球队若能够打平，则输出“yes”，否则输出“no”
示例1
输入
复制
2
3 3 0 0
3 3 3 3
输出
复制
yes
no

5
3 0 0 0
3 3 0 0
6 4 1 0
6 3 3 0
3 3 3 2

yes
yes
yes
no
no

4
999999999980 258442058745 258442058715 258442058715
999999999980 258442058745 258442058715 258442058716
999999999980 258442058745 258442058715 258442058717
999999999980 258442058745 258442058715 258442058718
no
no
no
no
1
999999999980 258442058745 258442058715 258442058716
les=741557941235
说明
case1: 球队1和球队2 差0分，球队2 和球队3也差0分，所以可能的赛得分是三只球队各得1分
case2: 球队1和球队2差3分，球队2和球队3差3分，所以可能的得分是 球队1得0分，球队2得3分, 球队3得0分，比赛已经全部结束因此最终不能打平。
 */