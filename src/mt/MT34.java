package mt;

import java.util.Scanner;

public class MT34 {
    public static void main(String[] args) {
        int s;
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String res = "";
            s = cin.nextInt();
            boolean flag = false;
            if (s == 1) {
                System.out.println(1);
                continue;
            }
            if (s % 3 == 0 || s % 3 == 2) {
                while (s > 0) {
                    if (flag) {
                        s -= 1;
                        res += '1';
                        flag = false;
                    } else {
                        s -= 2;
                        res += "2";
                        flag = true;
                    }
                }
            } else {
                flag = true;
                while (s > 0) {
                    if (flag) {
                        s -= 1;
                        res += '1';
                        flag = false;
                    } else {
                        s -= 2;
                        res += "2";
                        flag = true;
                    }
                }
            }
            System.out.println(res);
        }
    }
}
/*

对于一个十进制数而言，它的数位和等于将它各位数字相加得到的和。比如 231 的数位和 是 6，3179 的数位和是 20。
现在你知道某个十进制数的数位和等于 s，并且这个数不包含 0，且任意相邻的数位是不同 的，
比如 112 或者 102 都是不满足条件的。现在你想知道满足这样的条件的最大的数是多少?
输入描述:
第一行包含一个整数𝑠，1 ≤ 𝑠 ≤ 42
输出描述:
输出满足条件的最大整数。
 */
