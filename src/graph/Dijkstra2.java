package graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//邻接矩阵
public class Dijkstra2 {
    static int n, m, INF = 0x3f3f3f3f;
    static int[][] graph;
    static boolean visit[];
    static int dis[];

    public static void init(int n, int m) {
        graph = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++)
            Arrays.fill(graph[i], INF);
        visit = new boolean[n + 1];
        Arrays.fill(visit, false);
        dis = new int[n + 1];
        Arrays.fill(dis, INF);
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        m = cin.nextInt();
        init(n, m);
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        for (int i = 0; i < m; i++) {
            int x = cin.nextInt();
            int y = cin.nextInt();
            int c = cin.nextInt();
            graph[x][y] = Math.min(graph[x][y], c);
        }
        queue.offer(new int[]{1, 0});
        dis[1] = 0;
        while (!queue.isEmpty()) {
            int tmp[] = queue.poll();
            int u = tmp[0];
            int cost = tmp[1];
            if (visit[u] == true)
                continue;
            visit[u] = true;
            for (int i = 1; i <= n; i++) {
                if (dis[i] > graph[u][i] + cost) {
                    dis[i] = graph[u][i] + cost;
                    if (visit[i] == false) {
                        queue.offer(new int[]{i, dis[i]});
                    }
                }
            }
        }
        if (dis[n] == INF)
            System.out.println(-1);
        else System.out.println(dis[n]);
    }
}
/*
给定一个 n 个点 m 条边的有向图，图中可能存在重边和自环，所有边权均为正值。
请你求出 1 号点到 n 号点的最短距离，如果无法从 1 号点走到 n 号点，则输出 −1。
输入格式
第一行包含整数 n 和 m。
接下来 m 行每行包含三个整数 x,y,z，表示存在一条从点 x 到点 y 的有向边，边长为 z。
输出格式
输出一个整数，表示 1 号点到 n 号点的最短距离。
如果路径不存在，则输出 −1。
数据范围
1≤n≤500,
1≤m≤105,
图中涉及边长均不超过10000。
输入样例：
3 3
1 2 2
2 3 1
1 3 4
输出样例：
3

5 10
1 2 2
5 3 3
4 1 8
2 4 3
4 5 7
5 2 3
3 4 1
1 2 9
3 2 3
1 2 8
 */