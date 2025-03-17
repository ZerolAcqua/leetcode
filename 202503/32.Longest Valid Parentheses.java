/*
 * @lc app=leetcode id=32 lang=java
 * @lcpr version=30005
 *
 * [32] Longest Valid Parentheses
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start

class Solution {

    public int longestValidParentheses(String s) {
        int n = s.length();
        Stack<Integer> stk = new Stack<>();
        int[] dp = new int[n];
        int res = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
                stk.push(i);
            } else {
                if (!stk.isEmpty()) {
                    int idx = stk.pop();
                    if (idx > 0) {
                        dp[i] = dp[idx - 1] + i - idx + 1;
                    } else {
                        dp[i] = i - idx + 1;
                    }

                    res = Math.max(res, dp[i]);
                }
            }
        }

        return res;
    }
}
// @lc code=end

/*
// @lcpr case=start
// "(()"\n
// @lcpr case=end

// @lcpr case=start
// ")()())"\n
// @lcpr case=end

// @lcpr case=start
// ""\n
// @lcpr case=end

 */
