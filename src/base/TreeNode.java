package base;

public class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public  TreeNode(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
    public TreeNode(TreeNode left, TreeNode right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }
}
