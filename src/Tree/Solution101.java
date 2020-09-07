package Tree;

import java.util.*;

public class Solution101 {
    /**
     * 递归
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return judge(root.left, root.right);
    }

    public boolean judge(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if ((left == null || right == null) || left.val != right.val)
            return false;
        else {
            return judge(left.left, right.right) && judge(left.right, right.left);
        }
    }

    /**
     * 非递归
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> tree = new LinkedList<>();
        tree.offer(root.left);
        tree.offer(root.right);
        while(!tree.isEmpty())
        {
            TreeNode tmp1= tree.poll();
            TreeNode tmp2= tree.poll();
            if(tmp1==null && tmp2==null){
                continue;
            }
            if(tmp1==null||tmp2==null){
                return false;
            }
            if(tmp1.val!=tmp2.val)
                return false;
            tree.offer(tmp1.left);
            tree.offer(tmp2.right);
            tree.offer(tmp1.right);
            tree.offer(tmp2.left);
        }
        return true;
    }
}
//[1,2,2,2,null,2]
//[2,3,3,4,5,5,4,null,null,8,9,null,null,9,8]
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */