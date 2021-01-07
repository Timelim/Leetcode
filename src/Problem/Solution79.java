package Problem;

import java.util.Arrays;

public class Solution79 {
    //深度优先搜索
    boolean visit[][] = new boolean[200][200];

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(visit[i], false);
        }
        char ch[] = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ch[0]) {
//                    System.out.println(i);
//                    System.out.println(j);
                    if (dfs(board, ch, 0, i, j))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] word, int index, int x, int y) {
        if (index == word.length) {
            return true;
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
            return false;
        if(board[x][y]!=word[index])
            return false;
        boolean res=false;
        if (board[x][y] == word[index] && visit[x][y] == false) {
            visit[x][y] = true;
            res= dfs(board, word, index + 1, x - 1, y) || dfs(board, word, index + 1, x + 1, y) || dfs(board, word, index + 1, x, y + 1) || dfs(board, word, index + 1, x, y - 1);
            visit[x][y] = false;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution79 t = new Solution79();
        t.exist(new char[][]{{'a'}}, "a");

    }
}
/*
给定一个二维网格和一个单词，找出该单词是否存在于网格中。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
示例:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false

提示：
    board 和 word 中只包含大写和小写英文字母。
    1 <= board.length <= 200
    1 <= board[i].length <= 200
    1 <= word.length <= 10^3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-search
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */