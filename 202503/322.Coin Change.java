/*
 * @lc app=leetcode id=322 lang=java
 * @lcpr version=30103
 *
 * [322] Coin Change
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int [] dp = new int[amount + 1];
        Arrays.fill(dp,  Integer.MAX_VALUE); 
        dp[0] = 0;

        for(int i = 1; i <= amount ; i++) {
            for(int coin : coins) {
                if(i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin]  + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE? -1 : dp[amount];
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,5]\n11\n
// @lcpr case=end

// @lcpr case=start
// [2]\n3\n
// @lcpr case=end

// @lcpr case=start
// [1]\n0\n
// @lcpr case=end

 */

