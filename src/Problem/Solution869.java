package Problem;

import java.util.Arrays;

public class Solution869 {
    public boolean reorderedPowerOf2(int N) {
        int table[] = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048,
                4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288,
                1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864,134217728,268435456,536870912};
        int[] tmp1 = getNum(N);
        for (int i = 0; i < table.length; i++) {
            int[] tmp2 = getNum(table[i]);
            int flag = 0;
            for (int j = 0; j < 9; j++) {
                if (tmp1[j] != tmp2[j]) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0)
                return true;
        }

        return false;
    }

    public int[] getNum(int N) {
        int res[] = new int[9];
        for (int i = 0; i < 9; i++)
            res[i] = -1;
        int j = 0;
        while (N > 0) {
            res[j++] = N % 10;
            N /= 10;
        }
        Arrays.sort(res);
//        for (int i = 0; i < 8; i++)
//            System.out.println(res[i]);
        return res;
    }

    public static void main(String[] args) {
        Solution869 t = new Solution869();
//        int[]tmp1=t.getNum(46);
//        int[]tmp2=t.getNum(46);
//        System.out.println(tmp1.toString().equals(tmp2.toString()));
        System.out.println(t.reorderedPowerOf2(271612776));
        System.out.println(67108864*2*2*2);
    }

}
/*
给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
示例 1：
输入：1
输出：true
示例 2：
输入：10
输出：false
示例 3：
输入：16
输出：true
示例 4：
输入：24
输出：false
示例 5：
输入：46
输出：true
    1 <= N <= 10^9
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reordered-power-of-2
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */