package Queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution239 {
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int res[] = new int[nums.length - k + 1];
        int max = getMax(nums, k, 0);
        res[0] = max;
        for (int i = 1; i < nums.length - k + 1; i++) {
            if (nums[i + k - 1] >= max) {
                max = nums[i + k - 1];
            } else if (nums[i - 1] == max) {
                max = getMax(nums, k, i);
            }
            res[i] = max;
        }
        for (int i = 0; i < res.length; i++) {
            System.out.printf("%d ", res[i]);
        }
        return res;
    }

    public int getMax(int nums[], int k, int start) {
        int res = nums[start];
        for (int i = start; i < start + k; i++) {
            if (nums[i] > res) {
                res = nums[i];
            }
        }
        return res;
    }


        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            Deque<Integer> deque = new LinkedList<Integer>();
            for (int i = 0; i < k; ++i) {
                while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
            }

            int[] ans = new int[n - k + 1];
            ans[0] = nums[deque.peekFirst()];
            for (int i = k; i < n; ++i) {
                while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
                while (deque.peekFirst() <= i - k) {
                    deque.pollFirst();
                }
                ans[i - k + 1] = nums[deque.peekFirst()];
            }
            return ans;

    }

    public static void main(String[] args) {
        Solution239 t = new Solution239();
        t.maxSlidingWindow1(new int[]{4, -2}, 2);//时间超限

    }
}
/*
给你一个整数数组 nums，有一个大小为?k?的滑动窗口从数组的最左侧移动到数组的最右侧。
你只可以看到在滑动窗口内的 k?个数字。滑动窗口每次只向右移动一位。

返回滑动窗口中的最大值。

示例 1：

输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
输出：[3,3,5,5,6,7]
解释：
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
示例 2：
输入：nums = [1], k = 1
输出：[1]
示例 3：
输入：nums = [1,-1], k = 1
输出：[1,-1]
示例 4：

输入：nums = [9,11], k = 2
输出：[11]
示例 5：

输入：nums = [4,-2], k = 2
输出：[4]
?
提示：
1 <= nums.length <= 105
-104?<= nums[i] <= 104
1 <= k <= nums.length
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sliding-window-maximum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */