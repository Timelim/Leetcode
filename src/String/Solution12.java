package String;

public class Solution12 {
    public String intToRoman(int num) {
        String res = "";
        if (num / 1000 > 0) {
            int tmp = num / 1000;
            for (int i = 0; i < tmp; i++) {
                res += "M";
            }
            num = num % 1000;
        }

        if (num / 100 > 0) {
            int tmp = num / 100;
            if (tmp == 9) {
                res += "CM";
                num -= 900;
            } else if (tmp == 4) {
                res += "CD";
                num -= 400;
            } else {
                if (tmp >= 5) {
                    res += "D";
                    tmp -= 5;
                }
                for (int i = 0; i < tmp; i++)
                    res += "C";
                num %= 100;
            }
        }
        if (num / 10 > 0) {
            int tmp = num / 10;
            if (tmp == 9) {
                res += "XC";
                num -= 90;
            } else if (tmp == 4) {
                res += "XL";
                num -= 40;
            } else {
                if (tmp >= 5) {
                    res += "L";
                    tmp -= 5;
                }
                for (int i = 0; i < tmp; i++)
                    res += "X";
                num %= 10;
            }
        }
        if (num > 0) {
            if (num == 9) {
                res += "IX";
                num -= 9;
            } else if (num == 4) {
                res += "IV";
                num -= 4;
            } else {
                if (num >= 5) {
                    res += "V";
                    num -= 5;
                }
                for (int i = 0; i < num; i++)
                    res += "I";
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution12 s = new Solution12();

        System.out.println(s.intToRoman(10));
    }
}
/*
罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，
例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/integer-to-roman
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */