package Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution31 {
    public void nextPermutation(int[] nums) {
        if(nums.length<=1) {
            return;
        }
        int l=nums.length-2;
        while(l>=0&&nums[l]>=nums[l+1]){
            l--;
        }
        if(l>=0){
            int j=nums.length-1;
            while (j>=0&&nums[l]>=nums[j]){
                j--;
            }
            System.out.println(l);
            System.out.println(j);
            int tmp=nums[j];
            nums[j]=nums[l];
            nums[l]=tmp;
            reverse(nums, l+1);
        }
        else {
            reverse(nums,0);
        }
    }
    public void reverse(int []nums,int start){
        for(int i=start,j=nums.length-1;i<j;i++,j--){
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
        }
    }
//1 3 2   5 1 1
    public static void main(String[] args) {
        int a[]={1,2,3,4,5,6,5,4,3,2,2,1,56,34};
        Arrays.sort(a, 5,a.length);
        for(int i:a){
            System.out.print(i);
            System.out.print(' ');
        }
        System.out.println(a);
    }
}
//[1,3,3,4,5,4,3,2,1]->[1,3,3,5,1,2,3,4,4]  5和4换  换完后 5后续数字升序排列  交换越近越好
/*
实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
必须 原地 修改，只允许使用额外常数空间。
示例 1：
输入：nums = [1,2,3]
输出：[1,3,2]
示例 2：
输入：nums = [3,2,1]
输出：[1,2,3]
示例 3：
输入：nums = [1,1,5]
输出：[1,5,1]
示例 4：
输入：nums = [1]
输出：[1]
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/next-permutation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */