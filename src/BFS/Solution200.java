package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Solution200 {
    public int numIslands(char[][] grid) {
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        int xLength = grid.length;
        int yLength = grid[0].length;
        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                if (grid[i][j] == '1') {
                    queue.offer(new int[]{i, j});
                    System.out.println(queue.size());
                    while (!queue.isEmpty()) {
                        int tmp[] = queue.poll();
                        int x = tmp[0], y = tmp[1];
                        grid[x][y] = '0';
                        if (x >= 1 && grid[x - 1][y] == '1') {
                            queue.offer(new int[]{x - 1, y});
                            grid[x - 1][y] = '0';
                        }
                        if (x < xLength - 1 && grid[x + 1][y] == '1') {
                            queue.offer(new int[]{x + 1, y});
                            grid[x + 1][y] = '0';
                        }
                        if (y >= 1 && grid[x][y - 1] == '1') {
                            queue.offer(new int[]{x, y - 1});
                            grid[x][y - 1] = '0';
                        }
                        if (y < yLength - 1 && grid[x][y + 1] == '1') {
                            queue.offer(new int[]{x, y + 1});
                            grid[x][y + 1] = '0';
                        }
                    }
                    res += 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution200 s = new Solution200();
        char[][] grid = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(s.numIslands(grid));
    }
}
/*
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。
示例 1：
输入：grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
输出：1
示例 2：
输入：grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
输出：3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-islands
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
