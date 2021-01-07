package DFS;
public class Solution52 {
    public int res = 0;
    public int totalNQueens(int n) {
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
            res+=1;
        }
        for (int i = 0; i < n; i++) {
            dfs(queens, n, x + 1, i);
        }
    }
}
