/*
 * @lc app=leetcode id=198 lang=java
 * @lcpr version=30005
 *
 * [198] House Robber
 */

// @lcpr-template-start
// @lcpr-template-end
// @lc code=start
class Solution {

    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        int res = dp[1];

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [1,2,3,1]\n
// @lcpr case=end

// @lcpr case=start
// [2,7,9,3,1]\n
// @lcpr case=end

 */
