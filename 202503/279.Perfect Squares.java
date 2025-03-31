/*
 * @lc app=leetcode id=279 lang=java
 * @lcpr version=30103
 *
 * [279] Perfect Squares
 */

 import java.util.Arrays;

 // @lc code=start
 class Solution {
     public int numSquares(int n) {
         int[] dp = new int[n + 1];
         Arrays.fill(dp, Integer.MAX_VALUE);
         dp[0] = 0;
 
         for (int i = 1; i <= n; i++) {
             for (int j = 1; j * j <= i; j++) {
                 dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
             }
         }
 
         return dp[n];
     }
 }
 // @lc code=end
 
 
 
 /*
 // @lcpr case=start
 // 12\n
 // @lcpr case=end
 
 // @lcpr case=start
 // 13\n
 // @lcpr case=end
 
  */
 
 