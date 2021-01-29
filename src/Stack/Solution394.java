package Stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Solution394 {
    public String decodeString(String s) {
        String res = "";
        Stack<Character> stack = new Stack<Character>();
        for (char ch : s.toCharArray()) {
            if (ch == ']') {
                String tmp1 = "";
                String tmp2 = "";
                while (stack.peek() != '[') {
                    tmp1 += stack.pop();
                }
                stack.pop();

                while (!stack.empty() && isDigit(stack.peek())) {
                    tmp2 += stack.pop();
                }
                String str = "";
                for (int i = tmp1.length() - 1; i >= 0; i--) {
                    str += tmp1.charAt(i);
                }
                int count = 0;
                for (int i = tmp2.length() - 1; i >= 0; i--) {
                    count *= 10;
                    count += (tmp2.charAt(i) - '0');
                }
                for (int i = 0; i < count; i++) {
                    for (int j = 0; j < str.length(); j++)
                        stack.push(str.charAt(j));
                }
            } else {
                stack.push(ch);
            }

        }
        while (!stack.empty()) {
            res += stack.pop();
        }
        String res1 = "";
        for (int i = res.length() - 1; i >= 0; i--)
            res1 += res.charAt(i);
        return res1;
    }

    public boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static void main(String[] args) {
        Solution394 t = new Solution394();
        System.out.println(t.decodeString("abc3[cd]xyz"));
    }
}
/*
给定一个经过编码的字符串，返回它解码后的字符串。
编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
示例 1：
输入：s = "3[a]2[bc]"
输出："aaabcbc"
示例 2：
输入：s = "3[a2[c]]"
输出："accaccacc"
示例 3：
输入：s = "2[abc]3[cd]ef"
输出："abcabccdcdcdef"
示例 4：
输入：s = "abc3[cd]xyz"
输出："abccdcdcdxyz"
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decode-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */