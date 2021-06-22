package DFS;

public class Solution494 {
    public int findTargetSumWays(int[] nums, int S) {
        res = 0;
        dfs(nums, S, 0);
        System.out.println(res);
        return res;
    }

    int res;

    public void dfs(int[] nums, int target, int index) {
        if (index == nums.length) {
            if (target == 0) {
                res += 1;
            }
            return;
        }
        dfs(nums, target - nums[index], index + 1);
        dfs(nums, target + nums[index], index + 1);
    }

    public static void main(String[] args) {
        Solution494 s = new Solution494();

        s.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
    }
}
/*
给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。
现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
示例：
输入：nums: [1, 1, 1, 1, 1], S: 3
输出：5
解释：
-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/target-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */