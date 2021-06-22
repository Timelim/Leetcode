package Sword;

public class Sword51 {
    int res = 0;

    public void merge(int nums[], int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int tmp[] = new int[nums.length];
        int index = 0;
        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                tmp[index++] = nums[i++];
            } else {
                tmp[index++] = nums[j++];
                res += (mid - i + 1);
            }
        }
        while (i <= mid) {
            tmp[index++] = nums[i++];
        }
        while (j <= high) {
            tmp[index++] = nums[j++];
        }

        index = 0;
        while (low <= high) {
            nums[low++] = tmp[index++];
        }
    }

    public void MergeSort(int[] nums, int low, int high) {
       if(low>=high) return;
            int mid = (low + high) / 2;
            MergeSort(nums, low, mid);
            MergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);

    }

    public int reversePairs(int[] nums) {
        MergeSort(nums, 0, nums.length-1);
        return res;
    }

    public static void main(String[] args) {
        Sword51 s=new Sword51();

        System.out.println(s.reversePairs(new int[]{7,5,6,4}));
    }
}
