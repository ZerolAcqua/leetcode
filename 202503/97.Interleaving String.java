/*
 * @lc app=leetcode id=97 lang=java
 * @lcpr version=30103
 *
 * [97] Interleaving String
 */

// @lc code=start
class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if (n1 + n2 != n3) {
            return false;
        }
        if (n1 == 0) {
            return s2.equals(s3);
        }
        if (n2 == 0) {
            return s1.equals(s3);
        }

        boolean[][] dp = new boolean[n1 + 1][n2 + 1];

        dp[0][0] = true;
        for (int i = 1; i <= n1 && s1.charAt(i - 1) == s3.charAt(i - 1); i++) {
            dp[i][0] = true;
        }

        for (int j = 1; j <= n2 && s2.charAt(j - 1) == s3.charAt(j - 1); j++) {
            dp[0][j] = true;
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] |= dp[i - 1][j];
                }

                if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] |= dp[i][j - 1];
                }
            }
        }

        return dp[n1][n2];
    }
}
// @lc code=end

/*
// @lcpr case=start
// "aabcc"\n"dbbca"\n"aadbbcbcac"\n
// @lcpr case=end

// @lcpr case=start
// "aabcc"\n"dbbca"\n"aadbbbaccc"\n
// @lcpr case=end

// @lcpr case=start
// ""\n""\n""\n
// @lcpr case=end

 */
