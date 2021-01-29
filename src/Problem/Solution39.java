package Problem;

import java.util.*;

public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs( target, candidates,0);
//        for(List<Integer> list:res){
//            Collections.sort(list);
//        }

        return res;
    }

    List<List<Integer>> res =new ArrayList<>();
    List<Integer> select = new ArrayList<>();

    public void dfs(int target, int[] candidates,int start) {
        if (0 == target) {
            res.add(new ArrayList<>(select));
            return;
        }
        //System.out.println(cur);
        for (int i = start; i < candidates.length; i++) {
            if ( candidates[i] <= target) {
                select.add(candidates[i]);
                dfs(target-candidates[i], candidates,i);
                select.remove(select.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution39 t= new Solution39();
        System.out.println(t.combinationSum(new int[]{2,3,6,7},7));


    }

}
/*
39. 组合总和
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的数字可以无限制重复被选取。
说明：
所有数字（包括 target）都是正整数。
解集不能包含重复的组合。
示例 1：
输入：candidates = [2,3,6,7], target = 7,
所求解集为：
[
  [7],
  [2,2,3]
]
示例 2：
输入：candidates = [2,3,5], target = 8,
所求解集为：
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
1 <= candidates.length <= 30
1 <= candidates[i] <= 200
candidate 中的每个元素都是独一无二的。
1 <= target <= 500

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
