package dp;

public class Solution64 {
    public int minPathSum(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
//        System.out.println(row);
//        System.out.println(col);
        if(row==0)
            return 0;
        int [][]dp=new int [row][col];
        dp[0][0]=0;
        for (int i=0;i<row;i++){
            for(int j=0;j<col;j++)
            {
                if(i>=1&&j>=1){
                    dp[i][j]=Math.min(dp[i][j-1]+grid[i][j-1],dp[i-1][j]+grid[i-1][j]);
                }
                else if(i>=1&&j<1){
                    dp[i][j]=dp[i-1][j]+grid[i-1][j];
                }
                else if(i<1&&j>=1){
//                    System.out.println(j);
//                    System.out.println(i);
                    dp[i][j]=dp[i][j-1]+grid[i][j-1];
                }
            }
        }
//        for(int i=0;i<row;i++)
//        {
//            for (int j=0;j<col;j++)
//                System.out.print(dp[i][j]+" ");
//            System.out.println();
//        }
        return dp[row-1][col-1]+grid[row-1][col-1];
    }

    public static void main(String[] args) {
        Solution64 t = new Solution64();
//        System.out.println(t.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
        System.out.println(t.minPathSum(new int[][]{{1,2,3},{4,5,6}}));
    }
}
/*
给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
说明：每次只能向下或者向右移动一步。
示例 1：
输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
输出：7
解释：因为路径 1→3→1→1→1 的总和最小。
示例 2：
输入：grid = [[1,2,3],[4,5,6]]
输出：12
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-path-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
