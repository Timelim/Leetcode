package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        int flag = 0;
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
            if (flag % 2 == 1) {
                List<Integer> reverse_level = new ArrayList<>();
                for (int i = level.size() - 1; i >= 0; i--) {
                    reverse_level.add(level.get(i));
                }
                res.add(reverse_level);
            } else res.add(level);
            flag += 1;
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
 * <p>
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
