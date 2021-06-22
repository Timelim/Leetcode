package Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            int high = nums.length - 1;
            int low = i + 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[low]);
                    tmp.add(nums[high]);
                    res.add(tmp);
                    low++;
                    high--;
                    while (nums[low] == nums[low - 1] && low < high) low++;
                    while (nums[high] == nums[high + 1] && high > low) high--;
                } else if (sum > 0) {
                    high--;
                } else low++;
            }
            while (i<nums.length-1&&nums[i] == nums[i + 1]) i++;
        }
        //System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        Solution15 s = new Solution15();
        s.threeSum(new int[]{0,0,0,0,0});
    }
}
/*
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
注意：答案中不可以包含重复的三元组。
示例 1：
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
示例 2：

输入：nums = []
输出：[]
示例 3：

输入：nums = [0]
输出：[]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */