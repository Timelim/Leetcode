package graph;

import java.math.BigInteger;
import java.util.Scanner;

public class Flyod {
    public static void main(String[] args) {
        int N, M;
        String INF = "";
        BigInteger base = new BigInteger("2");
        for (int i = 0; i <= 160; i++)//2^500=10^155;
            INF += "9";
        BigInteger MOD = new BigInteger("100000");
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            N = cin.nextInt();
            M = cin.nextInt();
            BigInteger G[][] = new BigInteger[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j)
                        G[i][j] = new BigInteger("0");
                    else {
                        G[i][j] = new BigInteger(INF);
                    }
                }
            }
            for (int i = 0; i < M; i++) {
                int x = cin.nextInt();
                int y = cin.nextInt();

                if(!G[x][y].toString().equals(INF))	continue;
                G[x][y] = G[y][x] = new BigInteger(String.valueOf(base.pow(i)));
            }
            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (G[i][j].compareTo(G[i][k].add(G[k][j])) > 0) {
                            G[i][j] = G[i][k].add(G[k][j]);
                        }
                    }
                }
            }
            for (int i = 1; i < N; i++) {
                if (!G[0][i].toString().equals(INF))
                    System.out.println(String.valueOf(G[0][i].mod(MOD)));
                else System.out.println("-1");
            }
        }
    }
}
/*
链接：https://www.nowcoder.com/questionTerminal/a29d0b5eb46b4b90bfa22aa98cf5ff17
来源：牛客网
N个城市，标号从0到N-1，M条道路，第K条道路（K从0开始）的长度为2^K，求编号为0的城市到其他城市的最短距离
输入描述:
第一行两个正整数N（2<=N<=100）M(M<=500),表示有N个城市，M条道路
接下来M行两个整数，表示相连的两个城市的编号
输出描述:
N-1行，表示0号城市到其他城市的最短路，如果无法到达，输出-1，数值太大的以MOD 100000 的结果输出。
示例1
输入
4 4
1 2
2 3
1 3
0 1
输出
8
9
11
*/
