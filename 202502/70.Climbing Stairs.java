/*
 * @lc app=leetcode id=70 lang=java
 * @lcpr version=30005
 *
 * [70] Climbing Stairs
 */

// @lcpr-template-start
// @lcpr-template-end
// @lc code=start

class Solution {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
// @lc code=end

/*
// @lcpr case=start
// 2\n
// @lcpr case=end

// @lcpr case=start
// 3\n
// @lcpr case=end

 */
