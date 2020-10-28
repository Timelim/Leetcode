package Tree;

public class Solution129 {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        calc(root);
        return sum;
    }

    public void calc(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            sum += root.val;
            return;
        }
        if (root.left != null) {
            root.left.val = root.val * 10 + root.left.val;
            calc(root.left);
        }
        if (root.right != null) {
            root.right.val = root.val * 10 + root.right.val;
            calc(root.right);
        }
    }
}

//
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */