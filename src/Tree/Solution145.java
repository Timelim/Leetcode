package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution145 {
    //二叉树后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)
            return res;
        TreeNode p = root;
        TreeNode prev = null;
        while (!stack.empty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            //prev记录上一个访问的节点，如果p的右子树为null或者上一个访问了p.right，代表左右根该访问根了
            if (p.right == null || prev == p.right) {
                res.add(p.val);
                prev = p;
                p = null;
            } else {
                stack.push(p);
                p = p.right;
            }
        }
        return res;
    }
}
/*
输入: [1,null,2,3]
   1
    \
     2
    /
   3
输出: [3,2,1]
 */
