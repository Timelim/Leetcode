package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);

        while (!treeNodes.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int count = treeNodes.size();
            while (count > 0) {
                TreeNode node = treeNodes.poll();
                level.add(node.val);
                if (node.left != null) {
                    treeNodes.offer(node.left);
                }
                if (node.right != null) {
                    treeNodes.offer(node.right);
                }
                count -= 1;
            }
            res.add(level);
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
 * TreeNode(int x) { val = x; }
 * }
 */