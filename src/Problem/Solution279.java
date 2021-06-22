package Problem;

import java.util.Arrays;

public class Solution279 {
    public int numSquares(int n) {
        int num[] = new int[100];
        int dp[]=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for (int i = 100; i >= 1; i--) {
            num[i - 1] = i * i;
        }
        int index=0;
        for (int i = 1; i <=n; i++) {
            if(i==num[index]){
                dp[i]=1;
                index++;
            }
            else{
            int low=1,high=i-1;
            while (low<=high){
                dp[i]=Math.min(dp[i],dp[low]+dp[high]);
                high--;
                low++;
            }}
        }
        for(int i=0;i<=n;i++)
            System.out.println(dp[i]);
        return dp[n];

    }

    public static void main(String[] args) {
        Solution279 s= new Solution279();
        s.numSquares(12);
    }
}
/*
给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。

完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。

输入：n = 12
输出：3
解释：12 = 4 + 4 + 4
示例 2：

输入：n = 13
输出：2
解释：13 = 4 + 9
1 <= n <= 104


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/perfect-squares
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */