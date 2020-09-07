package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root==null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
    public int maxDepth2(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);
        int depth=1;
        while (!treeNodeQueue.isEmpty()){
            int count =treeNodeQueue.size();
            while (count>0){
                TreeNode treeNode = treeNodeQueue.poll();
                if(treeNode.left!=null)
                    treeNodeQueue.offer(treeNode.left);
                if(treeNode.right!=null)
                    treeNodeQueue.offer(treeNode.right);
                count-=1;
            }
            depth+=1;
        }
        return depth;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */