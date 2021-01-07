package DFS;

import java.util.ArrayList;
import java.util.List;

public class Solution51 {
    public List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int queens[] = new int[n];
        for (int i = 0; i < n; i++) {
            dfs(queens, n, 0, i);
        }
        return res;
    }

    public void dfs(int queens[], int n, int x, int y) {
        for (int i = 0; i < x; i++) {
            if (queens[i] == y) {
                return;
            }
            if (i + queens[i] == x + y || i - queens[i] == x - y) {
                return;
            }
        }
        queens[x]=y;
        if (x == n - 1) {
            res.add(reverse(queens, n));
        }
        for (int i = 0; i < n; i++) {
            dfs(queens, n, x + 1, i);
        }
    }


    //对角线和相等 对角线差相等
    public List<String> reverse(int queens[], int n) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            String tmp = "";
            for (int j = 0; j < n; j++) {
                if (queens[i] == j)
                    tmp += "Q";
                else tmp += ".";
            }
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution51 t = new Solution51();
        List<List<String>> res = t.solveNQueens(4);
        for (List<String> list : res) {
            for (int i = 0; i < list.size(); i++)
                System.out.println(list.get(i));
            System.out.println("------------");
        }
    }
}
/*
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
上图为 8 皇后问题的一种解法。
给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
示例：

输入：4
输出：[
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],
 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-queens
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */