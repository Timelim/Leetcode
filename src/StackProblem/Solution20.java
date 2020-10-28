package StackProblem;

import java.util.Stack;

public class Solution20 {
    public boolean isValid(String s) {
        if (s == null) {
            return true;
        }
        Stack<Character> stack = new Stack();
        for (char i : s.toCharArray()) {
            if (i == '(' || i == '{' || i == '[') {
                stack.push(i);
            } else if (stack.empty() == false) {
                if (i == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (i == ']' && stack.peek() == '[') {
                    stack.pop();
                } else if (i == '}' && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            } else {
                return false;
            }
        }
        return stack.empty();
    }
}
