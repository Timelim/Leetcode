package Problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null)
            return res;
        queue.offer(root);
        while(!queue.isEmpty()){
            int length =queue.size();
            while (length>0){
                TreeNode visit = queue.poll();
                if(visit.left!=null){
                    queue.offer(visit.left);
                }
                if(visit.right!=null){
                    queue.offer(visit.right);
                }
                if(length==1)
                    res.add(visit.val);
                length--;
            }
        }
        return  res;
    }
}
/*
给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
示例:
输入: [1,2,3,null,5,null,4]
输出: [1, 3, 4]
解释:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

通过次数80,543
提交次数124,413

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */