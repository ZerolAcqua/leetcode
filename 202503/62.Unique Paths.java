/*
 * @lc app=leetcode id=62 lang=java
 * @lcpr version=30005
 *
 * [62] Unique Paths
 */


// @lcpr-template-start
// @lcpr-template-end
// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp =  new int [m+1][n+1];

        for(int i = 1; i <= m; i++){
            dp[i][1] = 1;
        } 

        for(int j = 1; j <= n; j++){
            dp[1][j] = 1;
        } 

        for(int i = 2; i <= m ; i++) {
            for(int j = 2; j <= n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m][n];
    }
}
// @lc code=end



/*
// @lcpr case=start
// 3\n7\n
// @lcpr case=end

// @lcpr case=start
// 3\n2\n
// @lcpr case=end

 */

