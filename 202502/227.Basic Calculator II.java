/*
 * @lc app=leetcode id=227 lang=java
 * @lcpr version=20004
 *
 * [227] Basic Calculator II
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start

class Solution {

    public int calculate(String s) {
        int num = 0;
        char sign = '+';
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = 10 * num + (c - '0');
            }

            int pre;

            if (c == '+' || c == '-' || c == '/' || c == '*' || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        stk.push(num);
                        sign = c;
                        break;
                    case '-':
                        stk.push(-num);
                        sign = c;
                        break;
                    case '*':
                        pre = stk.pop();
                        stk.push(pre * num);
                        sign = c;
                        break;
                    case '/':
                        pre = stk.pop();
                        stk.push(pre / num);
                        sign = c;
                        break;
                }
                num = 0;

            }

        }

        int res = 0;
        while (!stk.isEmpty()) {
            res += stk.pop();
        }

        return res;
    }
}
// @lc code=end

/*
// @lcpr case=start
// "3+2*2"\n
// @lcpr case=end

// @lcpr case=start
// " 3/2 "\n
// @lcpr case=end

// @lcpr case=start
// " 3+5 / 2 "\n
// @lcpr case=end

 */
