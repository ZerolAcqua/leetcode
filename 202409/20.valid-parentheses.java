/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0)
            return false;
        char[] stack = new char[s.length()];
        int top = 0;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack[top++] = c;
            } else {
                if (top == 0)
                    return false;
                if (c == ')' && stack[top - 1] != '(')
                    return false;
                if (c == ']' && stack[top - 1] != '[')
                    return false;
                if (c == '}' && stack[top - 1] != '{')
                    return false;
                top--;
            }
        }

        return top == 0;
    }
}
// @lc code=end

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("{[]}"));
    }
}