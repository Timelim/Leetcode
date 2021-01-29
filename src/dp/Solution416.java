package dp;

import java.util.Arrays;

public class Solution416 {
    /**
     * 背包问题  这道题应该把值看成体积，装满背包，个数看成值
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i= 0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2==1)
            return false;
        boolean dp[]=new boolean[sum/2+1];
        dp[0]=true;
        for(int i=0;i<nums.length;i++){
            for(int j=sum/2;j>=nums[i];j--){
                dp[j] |= dp[j - nums[i]];
            }
        }
//        for(int i=0;i<sum/2+1;i++)
//            System.out.println(dp[i]);
        return dp[sum/2];
    }

    public static void main(String[] args) {
        Solution416 t=new Solution416();
        System.out.println(t.canPartition(new int[]{2,2,1,1}));
    }
}
/*
给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
注意:
    每个数组中的元素不会超过 100
    数组的大小不会超过 200
示例 1:
输入: [1, 5, 11, 5]
输出: true
解释: 数组可以分割成 [1, 5, 5] 和 [11].
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */