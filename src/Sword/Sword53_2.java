package Sword;

public class Sword53_2 {
    public int missingNumber(int[] nums) {
        int low =0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==mid){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Sword53_2 s= new Sword53_2();
        System.out.println(s.missingNumber(new int[]{0}));

    }
}
/*
一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
示例 1:
0 1 2 4
0 2 3 4
输入: [0,1,3]
输出: 2
示例 2:
输入: [0,1,2,3,4,5,6,7,9]
输出: 8
限制：
1 <= 数组长度 <= 10000
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */