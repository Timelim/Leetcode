package SortAlgorithm;

public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums,0,nums.length-1,nums.length-k);
    }

    public int partition(int data[], int low, int high) {
        int index = low;
        int key = data[index];
        while (low != high) {
            //先从high开始，避免出现最后所得的data[low]比data[index]大，导致排序出现问题
            while (data[high] >= key && low < high)
                high--;
            while (data[low] <= key && low < high)
                low++;
            if (low < high) {
                int tmp = data[low];
                data[low] = data[high];
                data[high] = tmp;
            }
        }
        data[index] = data[low];
        data[low] = key;
        return low;
    }

    public int quickSort(int data[], int low, int high, int index) {
        int mid = partition(data, low, high);
        if (mid == index)
            return data[index];
        else {
            return mid > index ? quickSort(data, low, mid - 1,index) : quickSort(data, mid + 1, high,index);
        }
    }
}
/*
215. 数组中的第K个最大元素
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
示例 1:
输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例 2:
输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
说明:
你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */