package dp;

public class Solution309 {
    //时间超出限制 o(n3)
    public int maxProfit1(int[] prices) {
        int res = 0;
        if (prices.length <= 1)
            return 0;
        if (prices.length == 2) {
            return Math.max(prices[1] - prices[0], 0);
        }
        int dp[] = new int[prices.length];
        dp[0] = 0;
        dp[1] = Math.max(prices[1] - prices[0], 0);
        dp[2] = Math.max(Math.max(prices[2] - prices[1], prices[2] - prices[0]), 0);
        for (int i = 3; i < prices.length; i++) {
            int tmp = 0;
            for (int j = 0; j + 2 < i; j++) {
                if (j == 0) {
                    int min = prices[i] - min(prices, j, i - 1);
                    if (min > tmp)
                        tmp = min;
                } else {
                    int min2 = dp[j] + prices[i] - min(prices, j + 2, i - 1);
                    if (min2 > tmp)
                        tmp = min2;
                }

//                if(i==prices.length-1){
//                    System.out.println(j);
//                    System.out.println("dp j:"+dp[j]);
//                    System.out.println("price:"+(prices[i]-prices[j+1]));
//                }
            }
            dp[i] = tmp;
        }
        for (int i = 0; i < prices.length; i++) {
            //System.out.println(dp[i]);
            if (dp[i] > res)
                res = dp[i];
        }
        return res;
    }

    public int min(int[] num, int low, int high) {
        int res = num[low];
        for (int i = low; i <= high; i++) {
            if (num[i] < res)
                res = num[i];
        }
        return res;
    }
    public int maxProfit(int[] prices) {
        int res=0;
        if(prices.length<=1)
            return 0;
        int dp[][]=new int[prices.length][3];
        //dp[i][0] 不持股且没卖出
        //dp[i][1] 持股
        //dp[i][2]持股且当天卖出
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        dp[0][2]=0;
        for(int i=1;i<prices.length;i++){
            dp[i][0]=Math.max(dp[i-1][2],dp[i-1][0]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            dp[i][2]=dp[i-1][1]+prices[i];
        }
        return Math.max(dp[prices.length-1][0],dp[prices.length-1][2]);
    }

    public static void main(String[] args) {
        Solution309 t = new Solution309();
        System.out.println(t.maxProfit(new int[]{6,1,3,2,4,7,3,6,2,6}));
    }
}
/*
309. 最佳买卖股票时机含冷冻期
给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
示例:

输入: [1,2,3,0,2]
输出: 3
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
[6,1,3,2,4,7]
6
[6,1,3,2,4,7,3,6,2,6]
10
[1,2,4,7]
6
 */