package Problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution415 {
    public String addStrings(String num1, String num2) {
        int cin = 0;
        String res = "";
        int i, j;
        for (i = num1.length() - 1, j = num2.length() - 1; i >= 0 && j >= 0; i--, j--) {
            int tmp = num1.charAt(i) - '0' + num2.charAt(j) - '0';
            char ch = (char) ((tmp + cin) % 10 + '0');
            res += ch;
            cin = (tmp + cin) / 10;
        }
        while (i >= 0) {
            int tmp = num1.charAt(i) - '0';
            char ch = (char) ((tmp + cin) % 10 + '0');
            res += ch;
            cin = (tmp + cin) / 10;
            i--;
        }

        while (j >= 0) {
            int tmp = num2.charAt(j) - '0';
            char ch = (char) ((tmp + cin) % 10 + '0');
            res += ch;
            cin = (tmp + cin) / 10;
            j--;
        }
        if (cin == 1) {
            res += '1';
        }
        String re = "";
        for (i = res.length() - 1; i >= 0; i--) {
            re += res.charAt(i);
        }
        return re;
    }

    public static void main(String[] args) {
        Solution415 s = new Solution415();
        System.out.println(s.addStrings("123", "4568"));
    }
}
