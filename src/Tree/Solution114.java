package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution114 {

    public void flatten(TreeNode root) {
        if(root==null)
            return;
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode tmp=root;
        while(tmp!=null||!treeNodeStack.empty()){
            if(tmp!=null){
                treeNodeStack.push(tmp);
                res.add(tmp.val);
                tmp=tmp.left;
            }
            else{
                TreeNode treeNode = treeNodeStack.pop();
                tmp=treeNode.right;
            }
        }
        root.left=null;
        root.right=null;
        tmp=root;
        for(int i=1;i<res.size();i++){
            tmp.left=null;
            tmp.right=new TreeNode(res.get(i));
            tmp=tmp.right;
        }
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/*
例如，给定二叉树

    1
   / \
  2   5
 / \   \
3   4   6
展开为
1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 */