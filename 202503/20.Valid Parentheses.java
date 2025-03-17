/*
 * @lc app=leetcode id=20 lang=java
 * @lcpr version=30103
 *
 * [20] Valid Parentheses
 */


import java.util.Deque;
import java.util.ArrayDeque;

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stk = new ArrayDeque<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' ||c == '[' ||c == '{'  ) {
                stk.push(c);
            } else {
                if (!stk.isEmpty() && stk.peek() == leftOf(c)) {
                        stk.pop();
                    } else {
                        return false;
                    }
            }
        }

        return stk.isEmpty();
    }

    private char leftOf(char right) {
        if(right == ')') {
            return '(';
        } else if( right == ']') {
            return '[';
        } else {
            return '{';
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// "()"\n
// @lcpr case=end

// @lcpr case=start
// "()[]{}"\n
// @lcpr case=end

// @lcpr case=start
// "(]"\n
// @lcpr case=end

// @lcpr case=start
// "([])"\n
// @lcpr case=end

 */

