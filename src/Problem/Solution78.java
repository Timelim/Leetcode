package Problem;

import java.util.ArrayList;
import java.util.List;

public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        int l = nums.length;
        int count = (int) Math.pow(2,l);
        List<List<Integer>> res =new ArrayList<>();
        for(int i=0;i<count;i++){
            int tmp=i;
            List<Integer> tmpList= new ArrayList<>();
            for(int j=0;j<l;j++){
                int flag =tmp&1;
                tmp=tmp>>1;
                if(flag==1)
                    tmpList.add(nums[j]);
            }
            res.add(tmpList);
        }
        return res;
    }
}
/*
给你一个整数数组 nums ，返回该数组所有可能的子集（幂集）。解集不能包含重复的子集。
示例 1：
输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
示例 2
输入：nums = [0]
输出：[[],[0]]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subsets
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */