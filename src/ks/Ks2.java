package ks;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode() {
    }

    public TreeNode(int _val) {
        val = _val;
    }

    public TreeNode(int _val, TreeNode _left, TreeNode _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

public class Ks2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            String[] tmp1 = str1.split(" ");
            String[] tmp2 = str2.split(" ");
            int[] pre = new int[tmp1.length];
            int[] mid = new int[tmp2.length];
            for (int i = 0; i < tmp1.length; i++) {
                pre[i] = Integer.parseInt(tmp1[i]);
                mid[i] = Integer.parseInt(tmp2[i]);
            }
//            for(int i=0;i<pre.length;i++)
//                System.out.println(pre[i]);
            Ks2 t =new Ks2();
            TreeNode root = t.bulidTree(pre, mid, 0, pre.length-1, 0, mid.length-1);
            int tmp = root.val;
            root.val=t.sumTreeNode(root)-tmp;
            t.midOrder(root);
            for(Integer i :t.res){
                System.out.printf("%d ",i);
            }
            System.out.println();
        }

    }

    public TreeNode bulidTree(int pre[], int mid[], int l1, int r1, int l2, int r2) {
        if(l1>r1||l2>r2||r1>=pre.length||r2>=mid.length)
            return null;
        TreeNode root = new TreeNode(pre[l1]);
        if (l1 == r1) {
            root.left = null;
            root.right = null;
        }
        else{
            int offset = l2;
            while (mid[offset] != pre[l1]) {
                offset++;
            }
            offset=offset-l2;
            root.left = bulidTree(pre, mid, l1 + 1, l1 + offset, l2, l2 + offset-1);
            root.right = bulidTree(pre, mid, l1 + 1 + offset, r1, l2 + 1 + offset, r2);
        }
        return root;
    }
    List<Integer> res = new ArrayList<>();
    public void midOrder(TreeNode tree){
        if(tree.left!=null){
            midOrder(tree.left);
        }
        res.add(tree.val);
        if(tree.right!=null){
            midOrder(tree.right);
        }
    }
    public int sumTreeNode(TreeNode tree){
        int tmp=tree.val;
        if(tree.left==null&&tree.right==null){
            tree.val=0;
        }
        else if(tree.left!=null &&tree.right!=null){
            tree.val=sumTreeNode(tree.left)+sumTreeNode(tree.right);
        }
        else if(tree.left!=null &&tree.right==null){
            tree.val=sumTreeNode(tree.left);
        }
        else if(tree.left==null &&tree.right!=null){
            tree.val=sumTreeNode(tree.right);
        }
        return tmp+tree.val;
    }
}

/*
题目描述
给出满二叉树，编写算法将其转化为求和树

什么是求和树：二叉树的求和树， 是一颗同样结构的二叉树，其树中的每个节点将包含原始树中的左子树和右子树的和。

二叉树：
10
/      \
-2        6
/   \      /  \
8    -4    7    5

求和树：
20(4-2+12+6)
/      \
4(8-4)      12(7+5)
/   \      /  \
0      0    0    0

二叉树给出前序和中序输入，求和树要求中序输出；
所有处理数据不会大于int；

输入描述:
2行整数，第1行表示二叉树的前序遍历，第2行表示二叉树的中序遍历，以空格分割
输出描述:
1行整数，表示求和树的中序遍历，以空格分割
示例1
输入
10 -2 8 -4 6 7 5
8 -2 -4 10 7 6 5
输出
0 4 0 20 0 12 0
 */