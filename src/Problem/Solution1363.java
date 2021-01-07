package Problem;

import java.lang.reflect.Array;
import java.util.*;

public class Solution1363 {
    public String largestMultipleOfThree(int[] digits) {
        String res = "";
        Arrays.sort(digits);
//        for(int i =0;i<digits.length;i++)
//            System.out.println(digits[i]);
        int sum = 0;
        int num[] = new int[3];
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i];
            num[digits[i] % 3] += 1;
        }
        int removeNum = 0;
        int count = 0;
        if (sum % 3 == 1) {
            if (num[1] >= 1) {
                removeNum = 1;
                count = 1;
            } else if (num[2] >= 2) {
                removeNum = 2;
                count = 2;
            } else {
                return "";
            }
        }
        if (sum % 3 == 2) {
            if (num[2] >= 1) {
                removeNum = 2;
                count = 1;
            } else if (num[1] >= 2) {
                removeNum = 1;
                count = 2;
            } else {
                return "";
            }
        }
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] % 3 == removeNum &&count!=0) {
                count -= 1;
            } else res += (Integer.toString(digits[i]));
        }
        //System.out.println(res);
        if(res=="")
            return res;
        String res2 = "";
        for (int i = res.length() - 1; i >= 0; i--)
            res2 += res.charAt(i);
        if (res2.charAt(0) == '0')
            res2 = "0";
        return res2;
    }

    public static void main(String[] args) {
        System.out.println();
        Solution1363 t = new Solution1363();

        System.out.println(t.largestMultipleOfThree(new int[]{1}));
    }
}
/*

给你一个整数数组 digits，你可以通过按任意顺序连接其中某些数字来形成 3 的倍数，请你返回所能得到的最大的 3 的倍数。
由于答案可能不在整数数据类型范围内，请以字符串形式返回答案。
如果无法得到答案，请返回一个空字符串。
示例 1：
输入：digits = [8,1,9]
输出："981"
示例 2：
输入：digits = [8,6,7,1,0]
输出："8760"
示例 3：
输入：digits = [1]
输出：""
示例 4：
输入：digits = [0,0,0,0,0,0]
输出："0"
提示：

    1 <= digits.length <= 10^4
    0 <= digits[i] <= 9
    返回的结果不应包含不必要的前导零。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/largest-multiple-of-three
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
