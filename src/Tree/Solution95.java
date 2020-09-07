package Tree;

import java.util.ArrayList;
import java.util.List;

public class Solution95 {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return dfs(1, n);
    }

    public List<TreeNode> dfs(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftList = dfs(start, i - 1);
            List<TreeNode> rightList = dfs(i + 1, end);
            //i作为根节点
            for (TreeNode left : leftList)
            {
                for(TreeNode rightL:rightList)
                {
                    TreeNode root =new TreeNode(i,left,rightL);
                    res.add(root);
                }
            }
        }
        return res;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
