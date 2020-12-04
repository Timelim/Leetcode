package Problem;

public class Solution53 {
    /**
     * dp
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        int res = nums[0];
        int dp[] = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if (dp[i - 1] < 0)
                dp[i] = nums[i];
            else dp[i] = nums[i] + dp[i - 1];
        }
        for (int i = 0; i < len; i++)
            if (dp[i] > res)
                res = dp[i];
        return res;
    }


    public static void main(String[] args) {
        Solution53 t = new Solution53();
    }
}
