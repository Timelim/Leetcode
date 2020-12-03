package Problem;


public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int no[] = {-1, -1};
        if (len == 0) return no;
        if (len == 1) return nums[0] == target ? new int[]{0, 0} : no;
        int low = 0, high = len - 1;
        System.out.println(high);
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                int l = mid, r = mid;
                while (l > 0 && nums[l - 1] == target) {
                    l--;
                }
                while (r < len-1 && nums[r + 1] == target) {
                    r++;
                }
                return new int[]{l, r};
            } else if (nums[mid] > target) {

                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return no;
    }

    public static void main(String[] args) {
        Solution34 t = new Solution34();
        t.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }
}
/*
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
如果数组中不存在目标值 target，返回 [-1, -1]。
进阶：
你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
示例 1：
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]
示例 2：
输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]
示例 3：
输入：nums = [], target = 0
输出：[-1,-1]
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */