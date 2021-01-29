package dp;

public class Solution135 {
    public int candy(int[] ratings) {
        int N = ratings.length;
        if (N <= 1) return N;
        int dp[] = new int[N];
        if (ratings[0] > ratings[1]) {
            dp[0] = 2;
        } else dp[0] = 1;

        for (int i = 1; i < N - 1; i++) {
            if(ratings[i]>ratings[i-1])
                dp[i]=dp[i-1]+1;
            else if(ratings[i]>ratings[i+1])
                dp[i]=2;
            else dp[i]=1;
        }
        for (int i = 1; i < N - 1; i++) {
            if(ratings[i]>ratings[i+1]&&dp[i]<=dp[i+1])
                dp[i]=dp[i+1]+1;
        }
        for (int i = N-2; i >= 0; i--) {
            if(ratings[i]>ratings[i+1]&&dp[i]<=dp[i+1])
                dp[i]=dp[i+1]+1;
        }
        if (ratings[N - 1] > ratings[N - 2])
            dp[N - 1] = dp[N - 2] + 1;
        else dp[N - 1] = 1;
        int res = 0;
        for (int i = 0; i < N; i++) {
            res += dp[i];
        }
        for (int i = 0; i < N; i++) {
            System.out.println(dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution135 t = new Solution135();
        System.out.println(t.candy(new int[]{3,2,1,1,4,3,3}));
    }
}
/*
老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。

你需要按照以下要求，帮助老师给这些孩子分发糖果：

    每个孩子至少分配到 1 个糖果。
    评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。

那么这样下来，老师至少需要准备多少颗糖果呢？

示例 1：

输入：[1,0,2]
输出：5
解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。

示例 2：

输入：[1,2,2]
输出：4
解释：你可以分别给这三个孩子分发 1、2、1 颗糖果。
     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/candy
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */