package wy;

import java.util.Arrays;
import java.util.Scanner;

public class WY13 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n, k;
        while (cin.hasNext()) {
            n = cin.nextInt();
            k = cin.nextInt();
            int num[] = new int[n + 1];
            int les[] = new int[10];
            int co[] = new int[10];
            int index = 0;
            boolean vis[] = new boolean[n + 1];
            Arrays.fill(vis, false);
            for (int i = 1; i <= n; i++) {
                num[i] = cin.nextInt();
                if (num[i] == 0) {
                    co[index++] = i;
                } else vis[num[i]] = true;
            }
            index = 0;
            for (int i = 1; i <= n; i++) {
                if (vis[i] == false) {
                    les[index++] = i;
                }
            }
            visit = new boolean[index];
            Arrays.fill(visit, false);
            dfs(num, k, les, co, 0, index);
            System.out.println(res);
        }
    }

    static int res = 0;
    static boolean visit[];

    public static int calc(int[] num) {
        int tmp = 0;
        for (int i = 1; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] < num[j]) {
                    tmp += 1;
                }
            }
        }
        return tmp;
    }

    public static void dfs(int[] num, int k, int les[], int co[], int index, int size) {
        if (index == size) {
            if (calc(num) == k)
                res += 1;
            return;
        }
        for (int i = 0; i < size; i++) {
            if(visit[i]==false){
                visit[i]=true;
                num[co[index]] = les[i];
            dfs(num, k, les, co, index + 1, size);
            num[co[index]]=0;
            visit[i]=false;
            }
        }
    }

}


