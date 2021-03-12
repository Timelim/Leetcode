package Problem;

public class Solution152 {
    public int maxProduct(int[] nums) {
        int maxDp[] = new int[nums.length];
        int minDp[] = new int[nums.length];
        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max = maxDp[i - 1] * nums[i];
            int min = minDp[i - 1] * nums[i];
            maxDp[i] = Math.max(Math.max(nums[i], max), min);
            minDp[i] = Math.min(Math.min(nums[i], max), min);
        }
        int res=maxDp[0];
        for(int i=0;i<nums.length;i++){
            if(maxDp[i]>res)
                res=maxDp[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution152 s=new Solution152();
        System.out.println(s.maxProduct(new int[]{1}));
    }
}

/*
给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
示例 1:
输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:
输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-product-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */