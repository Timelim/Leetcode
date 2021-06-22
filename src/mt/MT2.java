package mt;

public class MT2 {
    public int[][] flipChess(int[][] A, int[][] f) {
        // write code here
        int n = A.length;
        int m = A[0].length;
        for (int k = 0; k < f.length; k++) {
            int x = f[k][0] - 1;
            int y = f[k][1] - 1;
            if (x - 1 >= 0)
                A[x - 1][y] ^= 1;
            if (x + 1 < n)
                A[x + 1][y] ^= 1;
            if (y - 1 >= 0)
                A[x][y - 1] ^= 1;
            if (y + 1 < m)
                A[x][y + 1] ^= 1;
        }
//        for (int i = 0; i < A.length; i++) {
//            for (int j = 0; j < A[0].length; j++) {
//                System.out.printf("%d ", A[i][j]);
//            }
//            System.out.println();
//        }
        return A;
    }

    public static void main(String[] args) {
        MT2 mt = new MT2();
        int A[][] = new int[][]{new int[]{0, 0, 1, 1},
                new int[]{1, 0, 1, 0}, new int[]{0, 1, 1, 0}, new int[]{0, 0, 1, 0}};
        int t[][] = new int[][]{new int[]{2, 2}, new int[]{3, 3}, new int[]{4, 4}};
        mt.flipChess(A, t);
    }
}
/*
在4x4的棋盘上摆满了黑白棋子，
黑白两色的位置和数目随机其中左上角坐标为(1,1),右下角坐标为(4,4),
现在依次有一些翻转操作，
要对一些给定支点坐标为中心的上下左右四个棋子的颜色进行翻转，请计算出翻转后的棋盘颜色。

给定两个数组A和f,分别为初始棋盘和翻转位置。其中翻转位置共有3个。请返回翻转后的棋盘。

测试样例：
[[0,0,1,1],
[1,0,1,0],
[0,1,1,0],
[0,0,1,0]],
[[2,2],[3,3],[4,4]]
返回：
[[0,1,1,1],
[0,0,1,0],
[0,1,1,0],
[0,0,1,0]]
 */