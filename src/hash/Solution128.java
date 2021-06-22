package hash;

import java.util.HashSet;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        for (int num : hashSet) {
            if (!hashSet.contains(num - 1)) {
                int len = 1;
                int cur = num;
                while (hashSet.contains(cur + 1)) {
                    len += 1;
                    cur += 1;
                }
                res = Math.max(len, res);
            }
        }
        return res;
    }
}
/*
128. 最长连续序列
给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
示例 1：

输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
示例 2：

输入：nums = [0,3,7,2,5,8,4,6,0,1]
输出：9
提示：

0 <= nums.length <= 104
-109 <= nums[i] <= 109

 */
