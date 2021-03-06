package dp;

import java.util.Scanner;

public class Bag1 {
    //背包问题
    // task视为物品，task需要的服务器数视为 需要的背包容量 weight，处理的文件数视为物品的价值value
    // 问题转化为，求在固定容量大小的背包内 装物品所得的价值最大。
    //dp[i][j]，i代表前i件物品，j代表容量，dp[i][j]值为前i件物品在j容量下所得的最大价值
    // dp[i][j]=Math.max(dp[i-1][j-weight[i]]+value[i],dp[i-1][j])
    public static void main(String[] args) {
        int weight[]=new int[]{0,20,30,50,30,50,30,40,10};
        int value[]=new int[]{0,300,500,620,370,400,450,380,150};
        int x;
        Scanner scanner=new Scanner(System.in);
        x=scanner.nextInt();
        if(x<10)
            System.out.println(0);
        int dp[][]=new int[9][x+1];
        for(int i=0;i<=x;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<weight.length;i++){
            for(int j=0;j<=x;j++){
                if(j>=weight[i]) {

                    dp[i][j] = Math.max(dp[i - 1][j - weight[i]] + value[i], dp[i - 1][j]);
                }
                    else dp[i][j]=dp[i-1][j];
            }
        }
        System.out.println(dp[8][x]);
    }
}
/*
背包问题
dp[i][j]=dp[i-1][j-weight[i-1]]+value(i-1);
 */
/*
群并行处理文件
在进行大数据任务计算的时候，通常将一个较大的单个服务器无法处理的文件，拆分成多个小文件，
然后将一个个的小文件分发到多个服务器上进行处理。不同的任务，
可拆解出的单独处理的文件以及完成这个任务所需要的服务器数量均不相同，且任务是一个整体，
如果需要的服务器个数不能满足，则任务无法执行。假设我们一个由多台机器组成的集群，
此时来了如下任务需要完成(可拆分处理的小文件个数/需要的服务器个数）：
task1:300/20
task2:500/30
task3:620/50
task4:370/30
task5:400/50
task6:450/30
task7:380/40
task8:150/10
请问集群中共x台机器，通过最优调度，此集群最多一次性可以同时处理多少个小文件？
输入描述： 集群中的机器台数x
输出描述： 集群能够并行处理的最大小文件数
示例1： 输入 10 输出 150

 */