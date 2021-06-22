package Problem;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution60 {
    public String getPermutation(int n, int k) {
        if (n == 1)
            return "1";
        int num[] = new int[n];
        num[0] = 1;
        for (int i = 1; i < n; i++) {
            num[i] = num[i - 1] * i;
        }
        k--;
        boolean visit[] = new boolean[n + 1];
        Arrays.fill(visit, false);
        String res = "";
        for (int i = 1; i <= n; i++) {
            int order = k / num[n - i] + 1;
            for (int j = 1; j <= n; j++) {
                if (visit[j] == false) {
                    order -= 1;
                }
                if (order == 0) {
                    res += String.valueOf(j);
                    visit[j] = true;
                    break;
                }
            }
            k %= num[n - i];
        }
        //System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        Solution60 s = new Solution60();
        s.getPermutation(3, 4);
        //1 2 6 24
    }
}

/*
给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。
示例 1：
输入：n = 3, k = 3
输出："213"
示例 2：
输入：n = 4, k = 9
输出："2314"
示例 3：
输入：n = 3, k = 1
输出："123"
提示：
1 <= n <= 9
1 <= k <= n!
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutation-sequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */