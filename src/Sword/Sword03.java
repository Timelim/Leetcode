package Sword;

public class Sword03 {
    public int findRepeatNumber(int[] nums) {
        int len = nums.length;
        for(int i=0;i<len;i++)
        {
            if(nums[i]!=i){
                if(nums[nums[i]]==nums[i]) return nums[i];
                int tmp=nums[nums[i]];
                nums[nums[i]]=nums[i];
                nums[i]=i;
            }
        }
        return -1;
    }
}
//找出重复的数字
//暴力解法 o(n2)
//快速排序 o(nlogn)
//字典 鸽巢原理