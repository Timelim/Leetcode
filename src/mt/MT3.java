package mt;

public class MT3 {
    int res;

    public int countPath(int[][] map, int n, int m) {
        // write code here
        res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    dfs(map, n, m, i, j, 0, 0);
                    if (res != 0)
                        return res;
                    res = 0;
                    dfs(map, n, m, i, j, 0, 1);
                    if (res != 0)
                        return res;
                    res = 0;
                    dfs(map, n, m, i, j, 1, 0);
                    if (res != 0)
                        return res;
                    res = 0;
                    dfs(map, n, m, i, j, 1, 1);
                }
            }
        }
        return res;
    }

    // 0 0 左上
    // 0 1 左下
    // 1 0 右上
    // 1 1 右下
    public void dfs(int[][] map, int n, int m, int x, int y, int flag1, int flag2) {
        if (x < 0 || y < 0 || x >= n || y >= m)
            return;
        if (map[x][y] == 2) {
            res += 1;
            return;
        }

        if (map[x][y] == -1)
            return;
        //System.out.printf("x y:%d %d\n", x, y);
        map[x][y] = -1;
        if (flag1 == 0 && flag2 == 0) {
            dfs(map, n, m, x - 1, y, flag1, flag2);
            dfs(map, n, m, x, y - 1, flag1, flag2);
        }
        if (flag1 == 0 && flag2 == 1) {
            dfs(map, n, m, x - 1, y, flag1, flag2);
            dfs(map, n, m, x, y + 1, flag1, flag2);
        }
        if (flag1 == 1 && flag2 == 0) {
            dfs(map, n, m, x + 1, y, flag1, flag2);
            dfs(map, n, m, x, y - 1, flag1, flag2);
        }
        if (flag1 == 1 && flag2 == 1) {
            dfs(map, n, m, x + 1, y, flag1, flag2);
            dfs(map, n, m, x, y + 1, flag1, flag2);
        }
        map[x][y] = 0;
    }

    public static void main(String[] args) {
        MT3 t = new MT3();
        int[][] map = new int[][]{
                new int[]{0, 1, 0}, new int[]{2, 0, 0}
        };
//        int[][] map = new int[][]{
//                new int[]{0}, new int[]{1}, new int[]{2}
//        };
        System.out.println(t.countPath(map, 2, 3));
    }
}
/*
现在有一个城市销售经理，需要从公司出发，去拜访市内的商家，已知他的位置以及商家的位置，
但是由于城市道路交通的原因，他只能在左右中选择一个方向，在上下中选择一个方向，现在问他有多少种方案到达商家地址。
给定一个地图map及它的长宽n和m，其中1代表经理位置，2代表商家位置，-1代表不能经过的地区，0代表可以经过的地区，
请返回方案数，保证一定存在合法路径。保证矩阵的长宽都小于等于10。
测试样例：
[
[0,1,0],
[2,0,0]],
2,3

[[0],[1],[2]]
,3,1
返回：2
 */