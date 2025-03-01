/*
 * @lc app=leetcode id=139 lang=java
 * @lcpr version=30005
 *
 * [139] Word Break
 */

// @lcpr-template-start
import java.util.*;

// @lcpr-template-end
// @lc code=start
class Solution {

    int[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new int[s.length()];
        return dp(s, 0, wordDict);
    }

    boolean dp(String s, int i, List<String> wordDict) {

        if (i == s.length()) {
            return true;
        }
        if (memo[i] != 0) {
            return memo[i] == 1;
        }

        for (String str : wordDict) {
            if (targetInStr(s, i, str)) {
                if (dp(s, i + str.length(), wordDict)) {
                    memo[i] = 1;
                    return true;
                }
            }
        }

        memo[i] = -1;
        return false;

    }

    boolean targetInStr(String s, int start, String target) {
        if (s.length() - start < target.length()) {
            return false;
        }

        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) != s.charAt(i + start)) {
                return false;
            }
        }

        return true;
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
