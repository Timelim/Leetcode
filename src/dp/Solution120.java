package dp;

import java.util.List;

public class Solution120 {
    //    public int minimumTotal(List<List<Integer>> triangle) {
//        int n = triangle.size();
//        if (n == 0) return 0;
//        int dp[][]=new int[n][n];
//        dp[0][0]= triangle.get(0).get(0);
//        for(int i=1;i<n;i++){
//            for(int j=1;j<i;j++){
//                dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j])+triangle.get(i).get(j);
//            }
//            dp[i][0]=dp[i-1][0]+triangle.get(i).get(0);
//            dp[i][i]=dp[i-1][i-1]+triangle.get(i).get(i);
//        }
//        int res = dp[n-1][0];
//        for(int i=0;i<n;i++){
//            if(dp[n-1][i]<res)
//                res = dp[n-1][i];
//        }
//        return res;
//    }
//空间优化
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0) return 0;
        int dp[] = new int[n];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; j--) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);
            }
            dp[0] = dp[0] + triangle.get(i).get(0);

        }
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            if (dp[i] < res)
                res = dp[i];
        }
        return res;
    }
}
/*
局部最优解是否是全局最优解
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。

相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/triangle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */