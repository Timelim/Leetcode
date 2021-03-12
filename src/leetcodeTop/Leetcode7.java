package leetcodeTop;

public class Leetcode7 {
    public int reverse(int x) {
        int num[] = new int[32];
        int index = 0;
        int res = 0;
        int flag = x > 0 ? 1 : -1;
        while (x != 0) {
            num[index++] = x % 10;
            x /= 10;
        }
        for (int i = 0; i < index; i++) {
            int tmp = res;
            res *= 10;

            res += num[i];
            if (res / 10 != tmp)
                return 0;
        }
        return res;
    }
}
/*
给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。

如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。

假设环境不允许存储 64 位整数（有符号或无符号）。
示例 1：

输入：x = 123
输出：321
示例 2：

输入：x = -123
输出：-321
示例 3：

输入：x = 120
输出：21
示例 4：

输入：x = 0
输出：0
提示：
-231 <= x <= 231 - 1
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-integer
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */