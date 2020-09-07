package Tree;

public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;

        return bulid(preorder, inorder, 0, 0, preorder.length - 1);
    }

    public TreeNode bulid(int[] preorder, int[] inorder, int index, int low, int high) {
        if (low > high)
            return null;
        TreeNode node = new TreeNode(preorder[index]);
        for (int i = low; i <= high; i++) {
            if (inorder[i] == preorder[index]) {
                if (index + 1 <= preorder.length - 1)
                    node.left = bulid(preorder, inorder, index + 1, low, i - 1);
                int tmp = index + i - low + 1;
                if (tmp <= preorder.length - 1)
                    node.right = bulid(preorder, inorder, tmp, i + 1, high);
                break;
            }
        }
        return node;
    }
    /*
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0){
            return null;
        }
        TreeNode root=new TreeNode (preorder[0]);
        for(int i=0;i<preorder.length;i++){
            if(preorder[0]==inorder[i]){
                root.left=buildTree(Arrays.copyOfRange(preorder,1,i+1),Arrays.copyOfRange(inorder,0,i));
                root.right=buildTree(Arrays.copyOfRange(preorder,i+1,preorder.length),Arrays.copyOfRange(inorder,i+1,inorder.length));
                break;
            }
        }
        return root;
    }
     */
}
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
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
    3
   / \
  9  20
    /  \
   15   7
 */