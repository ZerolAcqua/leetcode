/*
 * @lc app=leetcode id=96 lang=java
 * @lcpr version=20004
 *
 * [96] Unique Binary Search Trees
 */


// @lcpr-template-start
// @lcpr-template-end
// @lc code=start
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int num = 2; num <= n ; num++) {
            for(int idx = 0; idx < num ; idx++){
                dp[num] += dp[idx]* dp[num - idx -1];
            }
        }

        return dp[n];  
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

