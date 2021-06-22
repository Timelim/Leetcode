package dp;

import java.util.HashMap;
import java.util.Map;

public class Solution525 {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int res=0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                sum-=1;
            else sum+=1;
            if(!map.containsKey(sum)) {
                //System.out.printf("sum:%d,i:%d\n",sum,i);
                map.put(sum, i);
            }
            else{
                //System.out.printf("map sum i:%d,i:%d\n",map.get(sum),i);
                res=Math.max(i-map.get(sum),res);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution525 s = new Solution525();
        System.out.println(s.findMaxLength(new int[]{0,1}));
    }
}
/*
68
[0,1,0,1,1,1,0,0,1,1,0,1,1,1,1,1,1,0,1,1,0,1,1,0,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,0,0,0,0,1,0,0,0,1,1,1,0,1,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,1,1,0,1,1,1,1,0,1,1,0,0,0,1,1]
525. 连续数组
给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
示例 1:
输入: nums = [0,1]
输出: 2
说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
示例 2:
输入: nums = [0,1,0]
输出: 2
说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
提示：
1 <= nums.length <= 105
nums[i] 不是 0 就是 1

 */