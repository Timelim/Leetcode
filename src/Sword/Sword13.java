package Sword;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Sword13 {
/* dfs
    public int movingCount(int m, int n, int k) {

        for(int i=0;i<100;i++)
            Arrays.fill(visit[i],false);
        dfs(m,n,0,0, k);
        int res=0;
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++)
                if(visit[i][j]==true)
                    res+=1;
        }
        return res;
    }

    boolean[][] visit = new boolean[100][100];

    public void dfs(int m, int n, int i, int j, int k) {
        if (i >= m || i < 0 || j >= n || j < 0||visit[i][j]==true) {
            return;
        }
        int tmp1 = i, tmp2 = j;
        int sum = 0;
        while (tmp1 > 0) {
            sum += (tmp1 % 10);
            tmp1 /= 10;
        }

        while (tmp2 > 0) {
            sum += (tmp2 % 10);
            tmp2 /= 10;
        }
        if (sum > k)
            return;

        visit[i][j] = true;
        dfs(m, n, i + 1, j, k);
        dfs(m, n, i - 1, j, k);
        dfs(m, n, i, j + 1, k);
        dfs(m, n, i, j - 1, k);
    }
*/

    /**
     * BFS
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    int m;int n;
    boolean[][] visit=new boolean[100][100];
    public int movingCount(int m, int n, int k) {
        Queue <int []> queue =new LinkedList<>();

        for(int i=0;i<m;i++)
            Arrays.fill(visit[i], false);
        queue.add(new int[]{0, 0});
        visit[0][0]=true;
        int res=0;
        this.m=m;this.n=n;
        while (!queue.isEmpty()){
            int []tmp = queue.poll();
            res+=1;
            if(judge(tmp[0]+1,tmp[1],k)){
                queue.offer(new int[]{tmp[0]+1,tmp[1]});
            }if(judge(tmp[0]-1,tmp[1],k)){
                queue.offer(new int[]{tmp[0]-1,tmp[1]});
            }
            if(judge(tmp[0],tmp[1]+1,k)){
                queue.offer(new int[]{tmp[0],tmp[1]+1});
            }
            if(judge(tmp[0],tmp[1]-1,k)){
                queue.offer(new int[]{tmp[0],tmp[1]-1});
            }
        }
        return res;
    }
    public boolean judge(int i,int j,int k){
        if (i >= m || i < 0 || j >= n || j < 0||visit[i][j]==true) {
            return false;
        }
        int tmp1 = i, tmp2 = j;
        int sum = 0;
        while (tmp1 > 0) {
            sum += (tmp1 % 10);
            tmp1 /= 10;
        }

        while (tmp2 > 0) {
            sum += (tmp2 % 10);
            tmp2 /= 10;
        }
        if (sum > k)
            return false;
        visit[i][j]=true;
        return true;
    }
    public static void main(String[] args) {
        Sword13 sword13 = new Sword13();
        int a = 10;

        System.out.println(sword13.movingCount(2, 3, 1));
    }
}
/*
剑指 Offer 13. 机器人的运动范围
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
示例 1：

输入：m = 2, n = 3, k = 1
输出：3
示例 2：

输入：m = 3, n = 1, k = 0
输出：1
提示：

1 <= n,m <= 100
0 <= k <= 20

 */
