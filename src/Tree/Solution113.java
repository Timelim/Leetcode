package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> pathRes = new ArrayList<>();
        if (root == null)
            return res;
        getPathRes(root, sum, res, pathRes);
        return res;
    }
    public void getPathRes(TreeNode root, int sum, List<List<Integer>> res, List<Integer> pathRes) {
        if(root==null)
            return;
        pathRes.add(root.val);
        if(root.left==null&&root.right==null&&sum==root.val)
            res.add(new ArrayList<>(pathRes));
        getPathRes(root.left,sum-root.val,res,pathRes);
        getPathRes(root.right,sum-root.val,res,pathRes);
        pathRes.remove(pathRes.size()-1);
    }

    /*
    保存路径递归
    什么时候添加元素
    什么时候路径清除
    路径的List在哪定义
    递归返回的list怎么返回
    怎么把所有路径都找到
    怎么遍历所有的叶子节点
     */

}

