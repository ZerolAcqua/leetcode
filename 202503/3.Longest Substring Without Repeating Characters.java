/*
 * @lc app=leetcode id=3 lang=java
 * @lcpr version=30103
 *
 * [3] Longest Substring Without Repeating Characters
 */

import java.util.HashMap;
import java.util.Map;

// @lc code=start
class Solution {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);

            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;

                window.put(d, window.get(d) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;

    }
}
// @lc code=end

/*
// @lcpr case=start
// "abcabcbb"\n
// @lcpr case=end

// @lcpr case=start
// "bbbbb"\n
// @lcpr case=end

// @lcpr case=start
// "pwwkew"\n
// @lcpr case=end

 */
