/*
 * @lc app=leetcode id=2787 lang=java
 * @lcpr version=30103
 *
 * [2787] Ways to Express an Integer as Sum of Powers
 */

// @lc code=start
class Solution {
    final static int base = 1000000007;

    public int numberOfWays(int n, int x) {
        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 1; Math.pow(i, x) <= n; i++) {
            int p = pow(i, x);
            for (int j = n; j - p >= 0; j--) {
                dp[j] += dp[j - p];
            }
        }

        return (int) (dp[n] % base);
    }

    private int pow(int x, int idx) {
        if (idx == 1) {
            return x;
        }

        if (idx % 2 == 1) {
            return pow(x * x, idx / 2) * x;
        } else {
            return pow(x * x, idx / 2);
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// 10\n2\n
// @lcpr case=end

// @lcpr case=start
// 4\n1\n
// @lcpr case=end

 */

