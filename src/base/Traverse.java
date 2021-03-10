package base;

import java.util.Stack;

public class Traverse {
    public void preOrder(TreeNode root){
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode tmp=root;
        while(!stack.empty()||tmp!=null){
            if(tmp!=null){
                System.out.println(tmp.val);
                stack.push(tmp);
                tmp=tmp.left;
            }
            else{
                tmp=stack.pop();
                tmp=tmp.right;
            }
        }
    }
    public void inOrder(TreeNode root){
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode tmp=root;
        while (!stack.empty()||tmp!=null){
            if(tmp!=null){
                stack.push(tmp);
                tmp=tmp.left;
            }
            else{
                tmp=stack.pop();
                System.out.println(tmp.val);
                tmp=tmp.right;
            }
        }
    }
    public void postOrder(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
    }
    public void test(TreeNode root){
        if(root==null) return;
        test(root.left);
        test(root.right);
        System.out.println(root.val);
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        TreeNode t1=new TreeNode(9);
        TreeNode t2=new TreeNode(20);
        TreeNode t3=new TreeNode(15);
        TreeNode t4=new TreeNode(7);
        root.left=t1;
        root.right=t2;
        t2.left=t3;
        t2.right=t4;
        Traverse a=new Traverse();
        a.inOrder(root);
    }
}
/*
根左右
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
    3
   / \
  9  20
    /  \
   15   7

 */

