package Problem;

public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;

        return (getKnum(nums1, 0, nums2, 0, (l1 + l2 + 1) / 2) + getKnum(nums1, 0, nums2, 0, (l1 + l2 + 2) / 2)) / 2.0;

    }

    public int getKnum(int[] nums1, int low1, int[] nums2, int low2, int k) {
        if (low1 > nums1.length - 1) {
            return nums2[low2 + k - 1];
        }
        if (low2 > nums2.length - 1) {
            return nums1[low1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[low1], nums2[low2]);
        }
        int nums1mid = low1 + k / 2 - 1 < nums1.length ?  nums1[low1 + k / 2 - 1]:Integer.MAX_VALUE;
        int nums2mid = low2 + k / 2 - 1 < nums2.length ?  nums2[low2 + k / 2 - 1]:Integer.MAX_VALUE;
        if (nums1mid < nums2mid) {
            return getKnum(nums1, low1 + k / 2, nums2, low2, k - k / 2);
        } else {
            return getKnum(nums1, low1, nums2, low2 + k / 2, k - k / 2);
        }
    }
}

//    给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
//
//        进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
//
//         
//
//        示例 1：
//
//        输入：nums1 = [1,3], nums2 = [2]
//        输出：2.00000
//        解释：合并数组 = [1,2,3] ，中位数 2
//        示例 2：
//
//        输入：nums1 = [1,2], nums2 = [3,4]
//        输出：2.50000
//        解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
//        示例 3：
//
//        输入：nums1 = [0,0], nums2 = [0,0]
//        输出：0.00000
//        示例 4：
//
//        输入：nums1 = [], nums2 = [1]
//        输出：1.00000
//        示例 5：
//
//        输入：nums1 = [2], nums2 = []
//        输出：2.00000
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。