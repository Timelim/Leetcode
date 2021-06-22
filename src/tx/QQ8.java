package tx;

import java.util.Scanner;

public class QQ8 {
    public static void main(String[] args) {
        int a, b, A, B;
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            a = cin.nextInt();
            b = cin.nextInt();
            A = cin.nextInt();
            B = cin.nextInt();
            if (a != 1 && b != 1)
                if (A / a != B / b || A % a != B % b) {
                    System.out.println(-1);
                    continue;
                }

            System.out.println(A / a / 2 + A % a / 2 + A % a % 2);
        }
    }
}
/*
小Q从牛博士那里获得了一个数字转换机，这台数字转换机必须同时输入两个正数a和b，并且这台数字转换机有一个红色的按钮和一个蓝色的按钮：
当按下了红色按钮，两个数字同时加1。
当按下了蓝色按钮，两个数字同时乘2。
小Q现在手中有四个整数a，b，A，B，他希望将输入的两个整数a和b变成A，B（a对应A，b对应B）。
因为牛博士允许小Q使用数字转换机的时间有限，所以小Q希望按动按钮的次数越少越好。请你帮帮小Q吧。
输入描述:
输入包括一行，一行中有四个正整数a，b，A，B，（1≤a，b，A，B≤10^9）。
输出描述:
如果小Q可以完成转换，输出最少需要按动按钮的次数，否则输出-1。
示例1
输入
复制
100 1000 202 2002
1 100 2 101
输出
2
 */
