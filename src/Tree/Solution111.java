package Tree;

public class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if(root.left==null&&root.right==null)
            return 1;
        int l = 0x4fffffff;
        int r = 0x4fffffff;
        if (root.left != null)
            l = getDepth(root.left) + 1;
        if (root.right != null)
            r = getDepth(root.right) + 1;

        return Math.min(l, r);
    }

    public int getDepth(TreeNode root) {
        if (root.left == null && root.right == null)
            return 1;
        else if (root.left != null && root.right == null)
            return getDepth(root.left)+1;
        else if (root.left == null && root.right != null)
            return getDepth(root.right)+1;
        else if (root.left != null && root.right != null)
            return Math.min(getDepth(root.left), getDepth(root.right)) + 1;
        return 0x4fffffff;
    }
}
/*
给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
[1,2,3,4,null,null,5]
说明: 叶子节点是指没有子节点的节点。
[1,2]是2
 */
