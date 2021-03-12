package Sword;

import java.util.Arrays;

public class Sword60 {
    public double[] dicesProbability(int n) {
        int dp[][]=new int[15][70];
        //dp[i][j]=dp[i-1][j-cur]
        // dp[i][j]表示扔第i个筛子，j点数出现的次数
        for(int i=0;i<70;i++)
            Arrays.fill(dp[i],0);
        for(int i=1;i<=6;i++){
            dp[1][i]=1;
        }

        for(int i=2;i<=n;i++)
        {
            for(int j=i;j<=6*i;j++){
                for(int k=1;k<=6;k++){
                    if(j-k<=0) break;
                    dp[i][j]+=dp[i-1][j-k];
                }
            }
        }
        double res[]=new double[n*5+1];
        for(int i=0,j=n;j<=6*n;j++,i++){
            res[i]=dp[n][j]/Math.pow(6,n);
        }
        return res;
    }
}
