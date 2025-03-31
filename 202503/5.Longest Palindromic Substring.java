/*
 * @lc app=leetcode id=5 lang=java
 * @lcpr version=30103
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {

    int length = 1;
    int start = 0;

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            findPalindIn(s, i, i);
            findPalindIn(s, i, i + 1);
        }

        return s.substring(start, start + length);
    }

    private void findPalindIn(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > length) {
                    start = left;
                    length = right - left + 1;
                }
                left--;
                right++;
            } else {
                break;
            }
        }

    }
}
// @lc code=end

/*
// @lcpr case=start
// "babad"\n
// @lcpr case=end

// @lcpr case=start
// "cbbd"\n
// @lcpr case=end

 */
