package Problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution22 {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            res.add("");
            return res;
        }
        dfs(n, 0,0,"");
        return res;
    }

    public void dfs(int n,int l,int r, String item) {
        char[] str = item.toCharArray();
        if (l < r) {
            return;
        }
        else if(l>n) {
            return;
        }
        if (l == n && r == n) {
            res.add(item);
            return;
        }
        dfs(n,l+1,r,item+'(');
        dfs(n,l,r+1,item+')');
    }

    public boolean judge(String item) {
        char[] str = item.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (char ch : str) {
            if (ch == '(') {
                stack.push(ch);
            }
            if (ch == ')') {
                if (stack.empty()) {
                    return false;
                }
                char tmp = stack.peek();
                if (tmp == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        Solution22 t = new Solution22();
        t.generateParenthesis(3);
        //System.out.println(t.judge("((()))"));
    }
}
/*
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
示例：

输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/generate-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */