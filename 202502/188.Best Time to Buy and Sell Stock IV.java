/*
 * @lc app=leetcode id=188 lang=java
 * @lcpr version=30005
 *
 * [188] Best Time to Buy and Sell Stock IV
 */

// @lcpr-template-start
// @lcpr-template-end
// @lc code=start
class Solution {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        if (k > n / 2) {
            return maxProfit(prices);
        }

        int[][][] dp = new int[n][k + 1][2];

        for (int i = 0; i < n; i++) {
            dp[i][0][1] = Integer.MIN_VALUE;
            dp[i][0][0] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i - 1 < 0) {
                    dp[0][j][0] = 0;
                    dp[0][j][1] = -prices[i];
                    continue;
                }

                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j - 1][0] - prices[i], dp[i - 1][j][1]);
            }
        }

        return dp[n - 1][k][0];
    }

    private int maxProfit(int[] prices) {
        int n = prices.length;

        int dp_i0_0 = 0;
        int dp_i0_1 = -prices[0];
        int dp_i1_0;
        int dp_i1_1;

        for (int i = 1; i < n; i++) {
            dp_i1_0 = Math.max(dp_i0_0, dp_i0_1 + prices[i]);
            dp_i1_1 = Math.max(dp_i0_1, dp_i0_0 - prices[i]);

            dp_i0_0 = dp_i1_0;
            dp_i0_1 = dp_i1_1;
        }

        return dp_i0_0;
    }
}
// @lc code=end

/*
// @lcpr case=start
// 2\n[2,4,1]\n
// @lcpr case=end

// @lcpr case=start
// 2\n[3,2,6,5,0,3]\n
// @lcpr case=end

 */
