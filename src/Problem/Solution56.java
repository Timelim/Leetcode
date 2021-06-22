package Problem;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution56 {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);
        int x = intervals.length;
        boolean visit[] = new boolean[x];
        Arrays.fill(visit, false);
        for (int i = 0; i < x; i++) {
            if (!visit[i]) {
                int[] item = new int[2];
                item[0] = intervals[i][0];
                item[1] = intervals[i][1];
                visit[i] = true;
                for (int j = i + 1; j < x; j++) {
                    int[] tmp = isMerge(item[0], item[1], intervals[j][0], intervals[j][1]);
                    if (tmp[0] == -1) {
                    }
                    else {
                        visit[j] = true;
                        item[0] = tmp[0];
                        item[1] = tmp[1];
                    }
                }

                res.add(item);
            }
        }
        int[][] r = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
//            System.out.printf("%d,%d\n", res.get(i)[0], res.get(i)[1]);
            r[i] = res.get(i);
        }

        return r;
    }

    public int[] isMerge(int l1, int r1, int l2, int r2) {
        int res[] = new int[]{-1, -1};
        if (r1 < l2)
            return res;
        res[0] = l1;
        res[1] = Math.max(r1, r2);
        return res;
    }

    public static void main(String[] args) {
        Solution56 s = new Solution56();
        s.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    }
}
/*
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
示例 1：
输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:
输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
提示：
1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */