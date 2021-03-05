package Sword;

public class Sword49 {
    public int nthUglyNumber(int n) {
        int dp[]=new int[n];
        dp[0]=1;
        int a=0,b=0 ,c=0;
        for(int i=1;i<n;i++) {
            int num1=dp[a]*2;
            int num2=dp[b]*3;
            int num3=dp[c]*5;
            dp[i]=Math.min(Math.min(num1,num2),num3);
            if(dp[i]==num1) a++;
            if(dp[i]==num2) b++;
            if(dp[i]==num3) c++;
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        Sword49 s= new Sword49();
        System.out.println(   s.nthUglyNumber(10));

    }

}
/*
输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。

2 3 2*2 5 2*3 2*2*2 3*3 2*5 2*2*3  3*5 5*5
 */
