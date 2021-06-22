package UnionSet;

import java.util.Arrays;
import java.util.Scanner;

public class P3367 {
    public static class Union {
        int[] id;
        int[]rank;
        public Union(int N) {
            id = new int[N];
            for (int i = 0; i < N; i++)
                id[i] = i;
            rank=new int[N];
            Arrays.fill(rank,0);
        }
        public int findRoot(int p) {
            while (id[p] != p)
                p = id[p];
            return p;
        }
        public void union(int p, int q) {
            int proot = findRoot(p);
            int qroot = findRoot(q);
            if(rank[proot]>qroot){
                id[qroot] = proot;
            }
            else {
                id[proot]=qroot;
                if(rank[proot]==rank[qroot])
                    rank[qroot]+=1;
            }

        }
    }
    public static void main(String[] args) {
        int N, M;
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            N = cin.nextInt();
            M = cin.nextInt();
            int Z, X, Y;
            Union u = new Union(N + 1);
            for (int i = 0; i < M; i++) {
                Z = cin.nextInt();
                X = cin.nextInt();
                Y = cin.nextInt();
                if (Z == 1) {
                    u.union(X, Y);
                } else if (Z == 2) {
                    System.out.println(u.findRoot(X) == u.findRoot(Y) ? 'Y' : 'N');
                }
            }
        }
    }
}
