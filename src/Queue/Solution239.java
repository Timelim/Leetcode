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
        t.maxSlidingWindow1(new int[]{4, -2}, 2);//ʱ�䳬��

    }
}
/*
����һ���������� nums����һ����СΪ?k?�Ļ������ڴ������������ƶ�����������Ҳࡣ
��ֻ���Կ����ڻ��������ڵ� k?�����֡���������ÿ��ֻ�����ƶ�һλ��

���ػ��������е����ֵ��

ʾ�� 1��

���룺nums = [1,3,-1,-3,5,3,6,7], k = 3
�����[3,3,5,5,6,7]
���ͣ�
�������ڵ�λ��                ���ֵ
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
ʾ�� 2��
���룺nums = [1], k = 1
�����[1]
ʾ�� 3��
���룺nums = [1,-1], k = 1
�����[1,-1]
ʾ�� 4��

���룺nums = [9,11], k = 2
�����[11]
ʾ�� 5��

���룺nums = [4,-2], k = 2
�����[4]
?
��ʾ��
1 <= nums.length <= 105
-104?<= nums[i] <= 104
1 <= k <= nums.length
��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/sliding-window-maximum
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */