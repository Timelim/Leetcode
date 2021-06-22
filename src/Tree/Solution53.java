package Tree;

public class Solution53 {
    public TreeNode convertBST(TreeNode root) {
        inorder(root);
        return root;
    }

    int flag = 0;

    public void inorder(TreeNode root) {
        if (root == null) return ;
        inorder(root.right);
        root.val = root.val + flag;
        flag = root.val;
        inorder(root.left);
    }
}
