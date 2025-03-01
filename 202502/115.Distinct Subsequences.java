/*
 * @lc app=leetcode id=115 lang=java
 * @lcpr version=30005
 *
 * [115] Distinct Subsequences
 */

// @lcpr-template-start
import java.util.*;

// @lcpr-template-end
// @lc code=start
class Solution {

    int[][] memo;

    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        memo = new int[m][n];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(s, 0, t, 0);
    }

    int dp(String s, int i, String t, int j) {
        if (t.length() == j) {
            return 1;
        }

        if (s.length() - i < t.length() - j) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {
            memo[i][j] = dp(s, i + 1, t, j + 1) + dp(s, i + 1, t, j);
        } else {
            memo[i][j] = dp(s, i + 1, t, j);
        }

        return memo[i][j];

    }
}
// @lc code=end

/*
// @lcpr case=start
// "rabbbit"\n"rabbit"\n
// @lcpr case=end

// @lcpr case=start
// "babgbag"\n"bag"\n
// @lcpr case=end

 */
