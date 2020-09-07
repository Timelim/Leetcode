package Tree;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> tree = new Stack();
        List<Integer> res = new ArrayList();
        TreeNode tmp = root;
        while (!tree.empty()||tmp!=null) {
            if (tmp!= null) {
                tree.push(tmp);
                tmp = tmp.left;
            }
            else{
                tmp = tree.pop();
                res.add(tmp.val);
                tmp=tmp.right;
            }
        }
        return res;
    }

}
/*递归解法
    List<Integer> res = new ArrayList();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root.left != null)
            inorderTraversal(root.left);
        res.add(root.val);
        if (root.right != null)
            inorderTraversal(root.right);
        return res;
    }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
/*
输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
 */