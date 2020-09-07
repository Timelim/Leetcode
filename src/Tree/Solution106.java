package Tree;

public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) return null;

        return bulid(postorder, inorder, postorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode bulid(int[] postorder, int[] inorder, int index, int low, int high) {
        if (low > high)
            return null;
        TreeNode node = new TreeNode(postorder[index]);
        for (int i = low; i <= high; i++) {
            if (inorder[i] == postorder[index]) {
                node.right = bulid(postorder, inorder, index - 1, i + 1, high);
                int tmp = index - 1 - (high - i - 1 + 1);
                if (tmp >= 0)
                    node.left = bulid(postorder, inorder, tmp, low, i - 1);
                break;
            }
        }
        return node;
    }
}
/*
4-
中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */