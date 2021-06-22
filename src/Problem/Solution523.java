package Problem;

import java.util.HashMap;
import java.util.Map;

public class Solution523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int key = sum % k;
            if (map.containsKey(key) && i - map.get(key) >= 2) {
                return true;
            } else if (!map.containsKey(key)) map.put(key, i);
        }
//        for (int i : map.keySet()) {
//            System.out.printf("%d %d\n", i, map.get(i));
//
//        }
        return false;
    }

    public static void main(String[] args) {
        Solution523 s = new Solution523();
        System.out.println(s.checkSubarraySum(new int[]{5, 0, 0, 0}, 3));

    }
}
/*
前缀和 和 哈系表
你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
子数组大小 至少为 2 ，且
子数组元素总和为 k 的倍数。
如果存在，返回 true ；否则，返回 false 。
如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
[5,0,0,0]  3
示例 1：

输入：nums = [23,2,4,6,7], k = 6
输出：true
解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
示例 2：

输入：nums = [23,2,6,4,7], k = 6
输出：true
解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。
42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
示例 3：

输入：nums = [23,2,6,4,7], k = 13
输出：false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/continuous-subarray-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
