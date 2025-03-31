/*
 * @lc app=leetcode id=120 lang=java
 * @lcpr version=30103
 *
 * [120] Triangle
 */

import java.util.Arrays;
import java.util.List;

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < dp.length; i++) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                if (j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + row.get(j);
                } else {
                    dp[i][j] = dp[i - 1][j] + row.get(j);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < dp[n - 1].length; j++) {
            res = Math.min(res, dp[n - 1][j]);
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[2],[3,4],[6,5,7],[4,1,8,3]]\n
// @lcpr case=end

// @lcpr case=start
// [[-10]]\n
// @lcpr case=end

 */

