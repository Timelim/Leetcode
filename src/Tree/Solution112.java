package Tree;

import java.util.ArrayList;
import java.util.List;

public class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        else if (root.left == null && root.right == null)
            return sum - root.val == 0;
        else return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
    //遍历所有路径
}
/*
        给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

        说明: 叶子节点是指没有子节点的节点。

        示例: 
        给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/path-sum
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */