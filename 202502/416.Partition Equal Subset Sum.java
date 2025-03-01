/*
 * @lc app=leetcode id=416 lang=java
 * @lcpr version=30005
 *
 * [416] Partition Equal Subset Sum
 */

// @lcpr-template-start
// @lcpr-template-end
// @lc code=start

class Solution {

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int cap = sum / 2;

        boolean[] dp = new boolean[cap + 1];

        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = cap; j >= 1; j--) {
                dp[j] = dp[j] || nums[i - 1] <= j && dp[j - nums[i - 1]];
            }
        }

        return dp[cap];
    }
}
// @lc code=end

/*
// @lcpr case=start
// [1,5,11,5]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,5]\n
// @lcpr case=end

 */
