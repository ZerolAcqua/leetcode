/*
 * @lc app=leetcode id=22 lang=java
 * @lcpr version=30100
 *
 * [22] Generate Parentheses
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {

    StringBuilder sb = new StringBuilder();
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backTracing(n, n);
        return res;
    }

    void backTracing(int leftNum, int rightNum) {
        if (leftNum == 0 && rightNum == 0) {
            res.add(sb.toString());
        }

        if (leftNum > 0) {
            sb.append('(');
            backTracing(leftNum - 1, rightNum);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (leftNum < rightNum) {
            sb.append(')');
            backTracing(leftNum, rightNum - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

// @lc code=end
/*
// @lcpr case=start
// 3\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

 */
