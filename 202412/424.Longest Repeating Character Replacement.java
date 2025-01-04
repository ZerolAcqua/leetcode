/*
 * @lc app=leetcode id=424 lang=java
 * @lcpr version=20004
 *
 * [424] Longest Repeating Character Replacement
 */

// @lcpr-template-start
// @lc code=start
class Solution {

    public int characterReplacement(String s, int k) {
        int n = s.length();

        int left = 0;
        int right = 0;

        int[] count = new int[26];
        int maxCount = 0;

        int res = 0;

        while (right < n) {

            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);
            right++;

            if (right - left - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            res = Math.max(res, right - left);

        }

        return res;
    }
}
// @lc code=end

/*
// @lcpr case=start
// "ABAB"\n2\n
// @lcpr case=end

// @lcpr case=start
// "AABABBA"\n1\n
// @lcpr case=end

 */
