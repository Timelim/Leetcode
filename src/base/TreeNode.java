package base;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

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
