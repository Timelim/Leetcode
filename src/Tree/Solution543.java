package Tree;

import java.util.ArrayList;
import java.util.List;

public class Solution543 {
    public int diameterOfBinaryTree(TreeNode root) {
        count(root);
        int max=0;
        for(int i:res){
            System.out.println(i);
            if(i>max)
                max=i;
        }
        return max;

    }
    List<Integer> res=new ArrayList<>();
    public int count(TreeNode root){
        if(root==null)
            return 0;
        int l=count(root.left);
        int r=count(root.right);

        if(root.left==null&&root.right==null)
            return 0;
        int tmp=0;
        if(root.left!=null)
            tmp+=(l+1);
        if(root.right!=null)
            tmp+=(r+1);
        res.add(tmp);
        return Math.max(l,r)+1;
    }

    public static void main(String[] args) {

    }
}
/*
给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。

 

示例 :
给定二叉树

          1
         / \
        2   3
       / \
      4   5
返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
注意：两结点之间的路径长度是以它们之间边的数目表示。

通过次数88,845提交次数170,601

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */