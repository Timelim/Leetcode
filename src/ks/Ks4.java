package ks;

import java.util.Scanner;

public class Ks4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int []dp = new int[10001];
        dp[1]=Integer.MAX_VALUE-100;
        dp[2]=Integer.MAX_VALUE-100;
        dp[3]=1;
        dp[4]=Integer.MAX_VALUE-100;
        dp[5]=1;
        dp[6]=2;
        dp[7]=1;
        for(int i=8;i<=10000;i++){
            int tmp=Math.min(dp[i-3]+1,dp[i-5]+1);
            dp[i]=Math.min(tmp, dp[i-7]+1);
        }
        while (scanner.hasNext()){
            int x=scanner.nextInt();
            int res=dp[x];
            if(res>10000)
                System.out.println(-1);
            else System.out.println(dp[x]);
        }
    }

}
/*
题目描述
有重量分别为3，5，7公斤的三种货物，和一个载重量为X公斤的箱子（不考虑体积等其它因素，只计算重量）
需要向箱子内装满X公斤的货物，要求使用的货物个数尽可能少（三种货物数量无限）

输入描述:
输入箱子载重量X(1 <= X <= 10000)，一个整数。
输出描述:
如果无法装满，输出 -1。
如果可以装满，输出使用货物的总个数。
示例1
输入
4
输出
-1
说明
无法装满
示例2
输入
8
输出
2
说明
使用1个5公斤，1个3公斤货物
 */