package Problem;

public class Solution581 {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 1)
            return 0;
        int res = 0;
        int left = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                left = i;
                break;
            }
        }

        int right = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] < nums[i - 1]) {
                right = i;
                break;
            }
        }
//        System.out.println(left);
//        System.out.println(right);
        int min = nums[left], max = nums[left];
        for (int i = left; i <= right; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
//        System.out.println(min);
//        System.out.println(max);
        for (int i = 0; i < left; i++) {
            if (min < nums[i]) {
                left = i ;
                break;
            }
        }
        for (int i = nums.length - 1; i > right; i--) {
            if (nums[i] < max) {
                right = i;
                break;
            }
        }
//        System.out.println(left);
//        System.out.println(right);
        if(right==left)
            return 0;
        res = right - left+1 ;
        return res;
    }

    public static void main(String[] args) {
        Solution581 t = new Solution581();
        System.out.println(t.findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));
    }
}
/*
1,3,2,2,2
4
[2,3,3,2,4]
3
581. 最短无序连续子数组
给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
请你找出符合题意的 最短 子数组，并输出它的长度。
示例 1：
输入：nums = [2,6,4,8,10,9,15]
输出：5
解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
示例 2：
输入：nums = [1,2,3,4]
输出：0
示例 3：
输入：nums = [1]
输出：0
提示：
1 <= nums.length <= 104
-105 <= nums[i] <= 105
进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？

通过次数46,857提交次数131,146

 */
