package Sword;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Sword07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0,0,inorder.length-1);
    }

    public TreeNode build(int[] preorder,int []inorder,int index,int low,int high){
        if(low>high){
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);

        for(int i=low;i<=high;i++){
            if(inorder[i]==preorder[index]){
                if(index+1<preorder.length){
                    root.left=build(preorder,inorder,index+1,low,i-1);
                }
                if(i-low+index+1<preorder.length)
                    root.right=build(preorder,inorder,i-low+index+1,i+1,high);
                break;
            }

        }
        return root;
    }
}
/*
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
 
根 左 右
左 根 右

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
