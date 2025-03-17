/*
 * @lc app=leetcode id=76 lang=java
 * @lcpr version=30103
 *
 * [76] Minimum Window Substring
 */

import java.util.HashMap;
import java.util.Map;

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> targetCount = new HashMap<>();
        Map<Character, Integer> windowCount = new HashMap<>();

        for (char c : t.toCharArray()) {
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }

        int resLength = Integer.MAX_VALUE;
        int resLo = 0;
        int lo = 0, hi = 0;
        int valid = 0;

        while (hi < s.length()) {
            char c = s.charAt(hi);
            hi++;
            if (targetCount.containsKey(c)) {
                windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);
                if (windowCount.get(c).equals(targetCount.get(c))) {
                    valid++;
                }
            }

            while (valid == targetCount.size()) {
                if (hi - lo < resLength) {
                    resLo = lo;
                    resLength = hi - lo;
                }
                char d = s.charAt(lo);
                lo++;
                if (targetCount.containsKey(d)) {
                    if (windowCount.get(d).equals(targetCount.get(d))) {
                        valid--;
                    }
                    windowCount.put(d, windowCount.get(d) - 1);
                }
            }
        }

        return resLength == Integer.MAX_VALUE ? "" : s.substring(resLo, resLo + resLength);
    }
}
// @lc code=end



/*
// @lcpr case=start
// "ADOBECODEBANC"\n"ABC"\n
// @lcpr case=end

// @lcpr case=start
// "a"\n"a"\n
// @lcpr case=end

// @lcpr case=start
// "a"\n"aa"\n
// @lcpr case=end

 */

