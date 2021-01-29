package UnionSet;

import java.util.HashSet;
import java.util.Set;

public class Solution200 {

    class QuickUnionUF {
        public int[] id;

        public QuickUnionUF(int N) {
            id = new int[N];
            for (int i = 0; i < N; i++)
                id[i] = i;
        }

        /**
         * 找到i的根节点
         *
         * @param i
         * @return
         */
        public int root(int i){
            while(i!=id[i]){
                i=id[i];
            }
            return i;
        }

        /**
         * 判断p和q是否是连接的
         *
         * @param p
         * @param q
         * @return
         */
        public boolean connerted(int p, int q) {
            return root(p) == root(q);
        }

        /**
         * 合并p和q
         * 将p的根节点设为q的根节点(p=>q p的根节点指向q)。
         *
         * @param p
         * @param q
         */
        public void union(int p, int q) {
            int qroot = root(q);
            int proot = root(p);
            id[proot] = qroot;
        }
    }

    public int numIslands(char[][] grid) {
        int res = 0;
        int xLength = grid.length;
        int yLength = grid[0].length;
        if(xLength==0)
            return 0;
        QuickUnionUF tree = new QuickUnionUF(xLength * yLength);
        //index/x index%y
        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                if (grid[i][j] == '0')
                    tree.id[i * yLength + j] = -1;
            }
        }
        for(int i=0;i<xLength;i++)
        {
            for(int j=0;j<yLength;j++)
            {
                System.out.printf("%d ",tree.id[i*yLength+j]);
            }
            System.out.println();
        }
        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        tree.union(i * yLength + j, (i - 1) * yLength + j);
                    }

                    if (i + 1 < xLength && grid[i + 1][j] == '1') {
                        tree.union(i * yLength + j, (i + 1) * yLength + j);
                    }

                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        tree.union(i * yLength + j, i * yLength + j - 1);
                    }

                    if (j + 1 < yLength && grid[i][j + 1] == '1') {
                        tree.union(i * yLength + j, i * yLength + j + 1);
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i : tree.id) {
            if (i != -1)
                set.add(tree.root(i));
        }
        for(int i=0;i<xLength;i++)
        {
            for(int j=0;j<yLength;j++)
            {
                System.out.printf("%d ",tree.id[i*yLength+j]);
            }
            System.out.println();
        }
        return set.size();
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