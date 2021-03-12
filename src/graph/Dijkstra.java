package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    int to, cost;

    Edge(int to_, int cost_) {
        to = to_;
        cost = cost_;
    }

    @Override
    public int compareTo(Edge o) {
        // TODO Auto-generated method stub
        return this.cost - o.cost;
    }
}

public class Dijkstra {

    static int maxn = 1000 + 10;
    static int[] l;
    static int dis[];

    static ArrayList<ArrayList<Edge>> e;

    public static void dijkstra(int s) {
        int vis[] = new int[maxn];
        dis = new int[maxn];
        for (int i = 0; i < maxn; i++) dis[i] = 2147483647;
        Queue<Edge> que = new PriorityQueue<>();
        que.add(new Edge(s, 0));
        dis[s] = 0;
        while (que.isEmpty() == false) {
            Edge now = que.poll();
            int u = now.to;
            if (dis[u] < now.cost) continue;
            if (vis[u] == 1) continue;
            vis[u] = 1;
            for (int i = 0; i < e.get(u).size(); i++) {
                int next = e.get(u).get(i).to;
                int cost = e.get(u).get(i).cost;
                if (vis[next] == 0 && dis[next] > dis[u] + cost) {
                    dis[next] = dis[u] + cost;
                    que.add(new Edge(next, dis[next]));
                }
            }
        }
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        e = new ArrayList<ArrayList<Edge>>();
        for (int i = 0; i < maxn; i++) {
            ArrayList<Edge> temp = new ArrayList<Edge>();
            e.add(temp);
        }
        int n = scan.nextInt();
        int m = scan.nextInt();
        int s = scan.nextInt();
        l = new int[maxn];
        for (int i = 0; i < m; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int cost = scan.nextInt();
            e.get(from).add(new Edge(to, cost));
        }
        dijkstra(s);
        int first = 0;
        for (int i = 1; i <= n; i++) {
            if (first > 0)
                System.out.print(" ");
            ;
            System.out.print(dis[i]);
            ;
            first = 1;
        }
        System.out.println();
    }
}
/*
如题，给出一个有向图，请输出从某一点出发到所有点的最短路径长度。

输入格式
第一行包含三个整数 n,m,sn,m,s，分别表示点的个数、有向边的个数、出发点的编号。

接下来 mm 行每行包含三个整数 u,v,wu,v,w，表示一条 u \to vu→v 的，长度为 ww 的边。

输出格式
输出一行 nn 个整数，第 ii 个表示 ss 到第 ii 个点的最短路径，若不能到达则输出 2^{31}-12
31
 −1。
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