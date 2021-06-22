package UnionSet;

import java.util.Arrays;
import java.util.Scanner;

public class KY116 {
    public static class Union {
        int id[];

        public Union(int N) {
            id = new int[N];
            for (int i = 0; i < N; i++)
                id[i] = i;
        }

        public int findRoot(int p) {
            while (p != id[p]) {
                p = id[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int proot = findRoot(p);
            int qroot = findRoot(q);
            id[proot] = qroot;
        }
    }

    public static void main(String[] args) {
        int N, M;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            N = scanner.nextInt();
            if(N==0)
                return;
            M = scanner.nextInt();

            int d[]=new int[N+1];
            Arrays.fill(d,0);
            int x,y;
            Union u=new Union(N+1);
            for (int i = 0; i < M; i++) {
                x=scanner.nextInt();
                y=scanner.nextInt();
                d[x]++;
                d[y]++;
                if(u.findRoot(x)!=u.findRoot(y)){
                    u.union(x,y);
                }
            }
            int tmp=0;
            for(int i=1;i<N;i++){
                if(d[i]%2==1){
                    tmp++;
                    break;
                }
            }
            if(tmp>0){
                System.out.println(0);
                continue;
            }
            int t=1;
            for(int i=1;i<=N;i++){
                if(d[i]!=0) {
                    t = i;
                    break;
                }
            }
            boolean flag=false;
            int f=u.findRoot(t);
            for(int i=2;i<=N;i++){
                if(u.findRoot(i)!=f&&u.findRoot(i)!=i){
                    flag=true;
                    break;
                }
            }
            if(flag)
            {
                System.out.println(0);
                continue;
            }
            if(N!=0)
                System.out.println(1);
        }
    }
}
/*
确定无向图欧拉回路的充要条件：除孤立节点外，其它节点满足 1.连通 2.度为偶数
题目描述
    欧拉回路是指不令笔离开纸面，可画过图中每条边仅一次，且可以回到起点的一条回路。现给定一个图，问是否存在欧拉回路？
输入描述:
    测试输入包含若干测试用例。每个测试用例的第1行给出两个正整数，分别是节点数N ( 1 < N < 1000 )和边数M；随后的M行对应M条边，
    每行给出一对正整数，分别是该条边直接连通的两个节点的编号（节点从1到N编号）。当N为0时输入结束。
输出描述:
    每个测试用例的输出占一行，若欧拉回路存在则输出1，否则输出0。
示例1
输入
3 3
1 2
1 3
2 3
3 2
1 2
2 3
0
输出
1
0
 */
