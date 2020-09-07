package Tree;

public class Solution110 {
    //    public boolean isBalanced(TreeNode root) {
//        if (root!=null)
//        {
//            if (Math.abs(height(root.left) - height(root.right)) > 1)
//                return false;
//            else return isBalanced(root.left) && isBalanced(root.right);
//        }
//       else return true;
//    }
//    public int height(TreeNode root){
//        if (root==null)
//            return 0;
//        return Math.max(height(root.left),height(root.right))+1;
//    }
    public boolean isBalanced(TreeNode root) {
        return height(root)>=0;
    }

    public int height(TreeNode root) {
        if(root==null)
            return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        if(lh>=0&&rh>=0&&Math.abs(lh-rh)<=1){
            return Math.max(lh,rh)+1;
        }
        else {
            return -1;
        }
    }
}

/*
给定一个二叉树，判断它是否是高度平衡的二叉树。
本题中，一棵高度平衡二叉树定义为：
一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1。
 */