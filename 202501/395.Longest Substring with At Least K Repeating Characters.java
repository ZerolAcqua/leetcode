/*
 * @lc app=leetcode id=395 lang=java
 * @lcpr version=20004
 *
 * [395] Longest Substring with At Least K Repeating Characters
 */

// @lcpr-template-start
// @lc code=start
class Solution {

    public int longestSubstring(String s, int k) {
        int res = 0;
        for (int i = 1; i <= 26; i++) {
            res = Math.max(longestWithLetterNum(s, k, i), res);
        }

        return res;
    }

    int longestWithLetterNum(String s, int k, int count) {
        int n = s.length();

        int left = 0, right = 0;

        int[] windowCount = new int[26];
        int invalidNum = 0;
        int letterNum = 0;

        int res = 0;

        while (right < n) {
            {
                char c = s.charAt(right);
                windowCount[c - 'a']++;
                if (windowCount[c - 'a'] == 1) {
                    invalidNum++;
                    letterNum++;
                }
                if (windowCount[c - 'a'] == k) {
                    invalidNum--;
                }
                right++;
            }

            while (count < letterNum) {
                char c = s.charAt(left);
                windowCount[c - 'a']--;
                if (windowCount[c - 'a'] == 0) {
                    invalidNum--;
                    letterNum--;
                } else if (windowCount[c - 'a'] == k - 1) {
                    invalidNum++;
                }
                left++;
            }

            if (invalidNum == 0) {
                res = Math.max(res, right - left);
            }
        }

        return res;

    }
}
// @lc code=end

/*
// @lcpr case=start
// "aaabb"\n3\n
// @lcpr case=end

// @lcpr case=start
// "ababbc"\n2\n
// @lcpr case=end

 */
