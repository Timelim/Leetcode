package Tree;

import java.util.ArrayList;
import java.util.List;

public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null) {
            List<Integer> res = inorderTraversal(root.left);
            for (int i : res) {
                if (root.val <= i)
                    return false;
            }
        }
        if (root.right != null) {
            List<Integer> res = inorderTraversal(root.right);
            for (int i : res) {
                if (root.val >= i)
                    return false;
            }
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    List<Integer> res = new ArrayList();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root.left != null)
            inorderTraversal(root.left);
        res.add(root.val);
        if (root.right != null)
            inorderTraversal(root.right);
        return res;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */