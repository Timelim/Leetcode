package leetcodeTop;

public class Leetcode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res=0.0d;
        return res;
    }

    public int findKnum(int[] nums1, int[] nums2, int k) {
        int l1 = 0,  l2 = 0;
        while (k > 0) {
            if (l1 == nums1.length) {
                return nums2[l2 + k - 1];
            }
            if (l2 == nums2.length) {
                return nums1[l1 + k - 1];
            }
            if(k==1)
                return Math.min(nums1[l1],nums2[l2]);
            int half=k/2;
            int mid1 = Math.min(l1 + half,nums1.length)-1 ;
            int mid2 = Math.min(l2 + half,nums2.length)-1 ;
            if (nums1[mid1] > nums2[mid2]) {
                k -= (mid2 - l2 + 1);
                l2 = mid2 + 1;

            } else {
                k -= (mid1 - l1 + 1);
                l1 = mid1 + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Leetcode4 t = new Leetcode4();
        System.out.println(t.findKnum(new int[]{1, 2}, new int[]{3, 4}, 3));
    }
}
/*
(m+n)/2  (m+n/2)+1
给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
示例 1：
输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2
示例 2：
输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
示例 3：
输入：nums1 = [0,0], nums2 = [0,0]
输出：0.00000
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */