package Stack;

import java.util.Stack;

public class Solution16_26 {
    public int calculate(String s) {
        s = s.replace(" ", "");
        Stack<Integer> stack = new Stack<>();
        char tmp[] = s.toCharArray();

        int k = 0;
        int num1 = 0;
        while (k < tmp.length && tmp[k] >= '0' && tmp[k] <= '9') {
            num1 *= 10;
            num1 += (tmp[k] - '0');
            k++;
        }
        stack.push(num1);
        //System.out.println(num1);
        for (int i = k; i < tmp.length;) {
            char op = tmp[i];
            num1 = 0;
            i++;
            while (i < tmp.length && tmp[i] >= '0' && tmp[i] <= '9') {
                num1 *= 10;
                num1 += (tmp[i] - '0');
                i++;
            }
            switch (op) {
                case '+':
                    stack.push(num1);
                    break;
                case '-':
                    stack.push(-num1);
                    break;
                case '*':
                    stack.push(num1 * stack.pop());
                    break;
                case '/':
                    stack.push(stack.pop() / num1);
            }
        }
        int res = 0;
        while (!stack.empty()) {
            //System.out.println(stack.peek());
            res += stack.pop();
            //stack.pop();
        }
        //System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        Solution16_26 s=new Solution16_26();
        s.calculate(" 3+5 / 2 ");
    }
}
/*
给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。

表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。

示例 1:

输入: "3+2*2"
输出: 7
示例 2:

输入: " 3/2 "
输出: 1
示例 3:

输入: " 3+5 / 2 "
输出: 5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/calculator-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
