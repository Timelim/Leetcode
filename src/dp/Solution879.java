package dp;

public class Solution879 {
    //dp[i][j][k] 物品==工作  体积==人数
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int res = 0;
        int mod = (int) 1e9 + 7;
        int m = group.length;
        int dp[][][] = new int[m + 1][n + 1][minProfit + 1];
        dp[0][0][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    if (j >= group[i - 1]) {
                        dp[i][j][k] = (dp[i - 1][j][k] + dp[i - 1][j - group[i - 1]][Math.max(k - profit[i - 1], 0)]) % mod;
                    } else dp[i][j][k] = dp[i - 1][j][k];
                }
                res =(res+ dp[m][j][minProfit])%mod;
            }
        }
        return res % mod;
    }
}
/*
集团里有 n 名员工，他们可以完成各种各样的工作创造利润。
第 i 种工作会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。
工作的任何至少产生 minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n 。
有多少种计划可以选择？因为答案很大，所以 返回结果模 10^9 + 7 的值。
示例 1：
输入：n = 5, minProfit = 3, group = [2,2], profit = [2,3]
输出：2
解释：至少产生 3 的利润，该集团可以完成工作 0 和工作 1 ，或仅完成工作 1 。
总的来说，有两种计划。
示例 2：
输入：n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8]
输出：7
解释：至少产生 5 的利润，只要完成其中一种工作就行，所以该集团可以完成任何工作。
有 7 种可能的计划：(0)，(1)，(2)，(0,1)，(0,2)，(1,2)，以及 (0,1,2) 。
 
提示：

1 <= n <= 100
0 <= minProfit <= 100
1 <= group.length <= 100
1 <= group[i] <= 100
profit.length == group.length
0 <= profit[i] <= 100

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/profitable-schemes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */