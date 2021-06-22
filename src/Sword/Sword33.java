package Sword;

import java.util.Stack;

public class Sword33 {
    public boolean verifyPostorder1(int[] postorder) {
        return dfs(postorder, 0, postorder.length - 1);
    }

    public boolean dfs(int[] postorder, int low, int high) {
        if (low >= high) return true;
        int p = low;
        while (postorder[p] < postorder[high]) p++;
        int m = p;
        while (postorder[m] > postorder[high]) m++;
        return m == high && dfs(postorder, low, p - 1) && dfs(postorder, p, high - 1);
    }

    //单调栈
    //二叉树后序遍历 左右根，倒序 根右左
    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root)
                return false;
            while (!stack.isEmpty() && stack.peek() > postorder[i])
                root = stack.pop();
            stack.add(postorder[i]);
        }
        return true;
    }
}
/*
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
参考以下这颗二叉搜索树：
     5
    / \
   2   6
  / \
 1   3
示例 1：
输入: [1,6,3,2,5]
输出: false
示例 2：
输入: [1,3,2,6,5]
输出: true
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */