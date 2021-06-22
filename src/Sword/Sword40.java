package Sword;

import java.util.Arrays;
import java.util.Random;

public class Sword40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length==0)
            return new int[]{};
        getKNum(arr, 0, arr.length - 1, k - 1);
//        for(int i=0;i<arr.length;i++)
//            System.out.println(arr[i]);
        return Arrays.copyOf(arr, k);
    }

    public void getKNum(int[] arr, int low, int high, int k) {
        if (low < high) {
            int index = partition(arr, low, high);
            if (index == k)
                return;
            else if (index < k) {
                getKNum(arr, index + 1, high, k);
            } else {
                getKNum(arr, low, index - 1, k);
            }
        }

    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int l = low, r = high;
        while (l < r) {
            while (arr[r] >= pivot && r > l) r--;
            while (arr[l] <= pivot && r > l) l++;
            if(l<r)
                swap(arr, l, r);
        }
        arr[low] = arr[l];
        arr[l] = pivot;
        return l;
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Sword40 s = new Sword40();
        s.getLeastNumbers(new int[]{3, 2, 1}, 2);
    }
}
/*
输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
示例 1：
输入：arr = [3,2,1], k = 2
输出：[1,2] 或者 [2,1]
示例 2：
输入：arr = [0,1,2,1], k = 1
输出：[0]
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */