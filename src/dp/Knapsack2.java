package dp;

//完全背包问题

import java.util.Scanner;

public class Knapsack2 {
    public static void main(String[] args) {
        int N, V;
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            N = cin.nextInt();
            V = cin.nextInt();
            int value[] = new int[N + 1];
            int weight[] = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                weight[i] = cin.nextInt();
                value[i] = cin.nextInt();
            }
            int dp[][] = new int[N + 1][V + 1];
            for (int i = 0; i <= V; i++)
                dp[0][i] = 0;
            //物品种类
            for (int i = 1; i <= N; i++) {
                //weight
                for (int j = 1; j <= V; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= weight[i])
                        dp[i][j] = Math.max(dp[i][j], dp[i][j - weight[i]] + value[i]);
                }
            }
            System.out.println(dp[N][V]);
        }
    }
}
/*
有 N 种物品和一个容量是 V 的背包，每种物品都有无限件可用。
第 i 种物品的体积是 vi，价值是 wi。
求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
输出最大价值。
输入格式
第一行两个整数，N，V，用空格隔开，分别表示物品种数和背包容积。
接下来有 N 行，每行两个整数 vi,wi，用空格隔开，分别表示第 i 种物品的体积和价值。
输出格式
输出一个整数，表示最大价值。
数据范围
0<N,V≤1000
0<vi,wi≤1000
输入样例
4 5
1 2
2 4
3 4
4 5
输出样例：
10
 */