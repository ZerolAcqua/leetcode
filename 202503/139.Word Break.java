/*
 * @lc app=leetcode id=139 lang=java
 * @lcpr version=30103
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    byte[] memo;
    List<String> wordDict;

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        memo = new byte[n];
        this.wordDict = wordDict;

        return dp(s, 0);

    }

    private boolean dp(String s, int start) {
        if (start > s.length()) {
            return false;
        }

        if (start == s.length()) {
            return true;
        }

        if (memo[start] != 0) {
            return memo[start] == 1;
        }

        for (String str : wordDict) {
            if (targetInStr(s, start, str)) {
                if (dp(s, start + str.length())) {
                    memo[start] = 1;
                    return true;
                }
            }
        }

        memo[start] = -1;
        return false;
    }

    private boolean targetInStr(String s, int start, String target) {
        if (start + target.length() > s.length()) {
            return false;
        } else {
            return s.startsWith(target, start);
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// "leetcode"\n["leet","code"]\n
// @lcpr case=end

// @lcpr case=start
// "applepenapple"\n["apple","pen"]\n
// @lcpr case=end

// @lcpr case=start
// "catsandog"\n["cats","dog","sand","and","cat"]\n
// @lcpr case=end

 */

