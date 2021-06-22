package Problem;

import java.util.HashMap;

public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] <= nums.length && nums[i] > 0 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, nums[i] - 1,i );
            }
        }
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=i+1)
                return i+1;
        }

        return nums.length+1;
    }

    private void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    public static void main(String[] args) {
        Solution41 s = new Solution41();
        System.out.println(s.firstMissingPositive(new int[]{3, 4, -1, 1}));
    }
}
/*
给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？
示例 1：

输入：nums = [1,2,0]
输出：3
示例 2：

输入：nums = [3,4,-1,1]
输出：2
示例 3：

输入：nums = [7,8,9,11,12]
输出：1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/first-missing-positive
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */