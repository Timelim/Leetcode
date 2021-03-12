package Problem;

public class Solution221 {
    public int maximalSquare(char[][] matrix) {
        int area = 0, len = 0;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                len = 0;
                if (matrix[i][j] == '1') {
                    len += 1;
                    int flag = 1;
                    while (i + len < m && j + len < n) {
                        for (int x = i; x <= i + len; x++) {
                            for (int y = j; y <= j + len; y++) {
                                if (matrix[x][y] == '0') {
                                    flag = 0;
                                    break;
                                }
                            }
                            if (flag == 0)
                                break;
                        }
                        if (flag == 0)
                            break;
                        len += 1;
                    }
                    System.out.println("i:" + i + " j:" + j);
                    System.out.println("len:" + len);
                    area = Math.max(area, (len - 1) * (len - 1));
                }
            }
        }
        return area;
    }

    /**
     * 动态规划
     * dp[i][j]表示以i,j为右下角的正方形的边长。
     * dp[i][j]=min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1
     **/
    public int maximalSquare2(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                } else dp[i][j] = 0;
            }
        }
        int len = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", dp[i][j]);
                if (dp[i][j] > len)
                    len = dp[i][j];
            }
            System.out.println();
        }
        return len * len;
    }
}
/*
在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
示例 1：
输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
输出：4
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximal-square
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */