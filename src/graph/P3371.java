package graph;

import java.util.*;

//Dijkstra模版 1W个点会爆内存
public class P3371 {
    public static class Edge implements Comparable<Edge> {
        Integer to;
        Integer cost;

        public Edge(Integer to, Integer cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost.compareTo(o.cost);
        }
    }

    static int dis[];
    static ArrayList<Edge> G[];
    static boolean visit[];

    public static void init(int n) {
        dis = new int[n + 1];
        visit = new boolean[n + 1];
        G = new ArrayList[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        Arrays.fill(visit, false);
        for (int i = 0; i <= n; i++)
            G[i] = new ArrayList<>();
    }

    public static void dijkstra(int s) {
        dis[s] = 0;
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(s, 0));
        while (!queue.isEmpty()) {
            int u = queue.poll().to;
            if (visit[u])
                continue;
            visit[u] = true;
            for (int i = 0; i < G[u].size(); i++) {
                int v = G[u].get(i).to;
                int cost = G[u].get(i).cost;
                if (dis[v] > dis[u] + cost) {
                    dis[v] = dis[u] + cost;
                    if (visit[v] == false) {
                        queue.offer(new Edge(v, dis[v]));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int n, m, s;
        Scanner scanner = new Scanner(System.in);
        //while (scanner.hasNext()) {
        n = scanner.nextInt();
        m = scanner.nextInt();
        s = scanner.nextInt();
        init(n);
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int cost = scanner.nextInt();
            G[x].add(new Edge(y, cost));
        }
        dijkstra(s);
        for (int i = 1; i <= n; i++)
            System.out.printf("%d ", dis[i]);

    }
    //}
}
/*
题目背景
本题测试数据为随机数据，在考试中可能会出现构造数据让SPFA不通过，如有需要请移步 P4779。

题目描述
如题，给出一个有向图，请输出从某一点出发到所有点的最短路径长度。

输入格式
第一行包含三个整数 n,m,s分别表示点的个数、有向边的个数、出发点的编号。

接下来 mm 行每行包含三个整数 u,v,w表示一条 u→v 的，长度为 w 的边。

输出格式
输出一行 n 个整数，第 i 个表示 s 到第 i 个点的最短路径，若不能到达则输出 2^31-1
31
−1。

输入输出样例
输入
4 6 1
1 2 2
2 3 2
2 4 1
1 3 5
3 4 3
1 4 4
输出
0 2 4 3
 */