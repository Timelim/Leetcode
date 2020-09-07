package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> p_preRes = preOrder(p);
        List<Integer> q_preRes = preOrder(q);
        List<Integer> p_inRes = inOrder(p);
        List<Integer> q_inRes = inOrder(q);
        return p_preRes.toString().equals(q_preRes.toString()) && p_inRes.toString().equals(q_inRes.toString());
    }

    public List<Integer> preOrder(TreeNode t) {
        List<Integer> res = new ArrayList();
        Stack<TreeNode> nodeStack = new Stack();
        while (!nodeStack.empty() || t != null) {
            if (t != null) {
                nodeStack.push(t);
                res.add(t.val);
                t = t.left;
            } else {
                TreeNode tmp = nodeStack.pop();
                t = tmp.right;
                if (t == null) {
                    res.add(null);
                }
            }
        }
        return res;
    }

    public List<Integer> inOrder(TreeNode t) {
        List<Integer> res = new ArrayList();
        Stack<TreeNode> nodeStack = new Stack();
        while (!nodeStack.empty() || t != null) {
            if (t != null) {
                nodeStack.push(t);
                t = t.left;
            } else {
                TreeNode tmp = nodeStack.pop();
                res.add(tmp.val);
                t = tmp.right;
                if (t == null) {
                    res.add(null);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode t6 = new TreeNode(6);
        TreeNode t3 = new TreeNode(3);
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4, t6, null);
        TreeNode t2 = new TreeNode(2, t3, t5);
        TreeNode t1 = new TreeNode(1, t4, t2);
//        List<Integer> res = preOrder(t1);
//        for (int i : res) {
//            System.out.println(i);
//        }
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
