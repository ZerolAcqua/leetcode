/*
 * @lc app=leetcode id=416 lang=java
 * @lcpr version=30103
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }

        int n = nums.length;
        sum /= 2;

        boolean[][] dp = new boolean [sum + 1][n + 1];

        for(int j = 0; j <= n; j ++) {
            dp[0][j] = true;
        }


        for(int i = 1; i <= sum ; i++) {
            for(int j = 1; j<= n ; j++) {
                dp[i][j] = dp[i][j-1]||(i-nums[j-1]>=0 && dp[i-nums[j-1]][j - 1]);
            }
        }

        return dp[sum][n];
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

