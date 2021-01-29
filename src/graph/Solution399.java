package graph;

import java.util.*;

public class Solution399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double res[] = new double[queries.size()];
        Map<String, Integer> v = new HashMap<>();
        int vnum = 0;
        for (int i = 0; i < equations.size(); i++) {
            if (!v.containsKey(equations.get(i).get(0)))
                v.put(equations.get(i).get(0), vnum++);

            if (!v.containsKey(equations.get(i).get(1)))
                v.put(equations.get(i).get(1), vnum++);
        }
        double graph[][] = new double[vnum][vnum];
        for (int i = 0; i < vnum; i++)
            Arrays.fill(graph[i], -1.0);
        for (int i = 0; i < equations.size(); i++) {
            int va = v.get(equations.get(i).get(0));
            int vb = v.get(equations.get(i).get(1));
            graph[va][vb] = values[i];
            graph[vb][va] = 1.0 / values[i];
        }
        for (int k = 0; k < vnum; k++) {
            for (int i = 0; i < vnum; i++) {
                for (int j = 0; j < vnum; j++) {
                    if (graph[i][k] > 0 && graph[k][j] > 0) {
                        graph[i][j] = graph[i][k] * graph[k][j];
                    }
                }
            }
        }
        int index = 0;
        for (List<String> list : queries) {
            if (v.containsKey(list.get(0)) && v.containsKey(list.get(1))) {
                int va = v.get(list.get(0));
                int vb = v.get(list.get(1));
                if (graph[va][vb] > 0)
                    res[index++] = graph[va][vb];
                else res[index++] = -1.0;
            } else res[index++] = -1.0;
        }
        return res;
    }


    public static void main(String[] args) {
        Solution399 t = new Solution399();
        List<List<String>> equations = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        l1.add("a");
        l1.add("e");
        equations.add(l1);
        List<String> l2 = new ArrayList<>();
        l2.add("b");
        l2.add("e");
        equations.add(l2);
        double values[] = new double[]{4.0, 3.0};
        List<List<String>> qu = new ArrayList<>();
        List<String> q1 = new ArrayList<>();
        q1.add("a");
        q1.add("b");
        qu.add(q1);
        t.calcEquation(equations, values, qu);

    }
}
/*
a=2.6b=1.7*2.6c
a/c
a/d

给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i]
共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。
注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
示例 1：
输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
解释：
条件：a / b = 2.0, b / c = 3.0
问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
示例 2：
输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
输出：[3.75000,0.40000,5.00000,0.20000]
示例 3：
输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
输出：[0.50000,2.00000,-1.00000,-1.00000]
提示：
    1 <= equations.length <= 20
    equations[i].length == 2
    1 <= Ai.length, Bi.length <= 5
    values.length == equations.length
    0.0 < values[i] <= 20.0
    1 <= queries.length <= 20
    queries[i].length == 2
    1 <= Cj.length, Dj.length <= 5
    Ai, Bi, Cj, Dj 由小写英文字母与数字组成

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/evaluate-division
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
