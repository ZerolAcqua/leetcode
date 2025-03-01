/*
 * @lc app=leetcode id=122 lang=java
 * @lcpr version=30005
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lcpr-template-start
// @lcpr-template-end
// @lc code=start
class Solution {

    public int maxProfit(int[] prices) {
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
// [7,1,5,3,6,4]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,5]\n
// @lcpr case=end

// @lcpr case=start
// [7,6,4,3,1]\n
// @lcpr case=end

 */
