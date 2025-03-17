/*
 * @lc app=leetcode id=438 lang=java
 * @lcpr version=30103
 *
 * [438] Find All Anagrams in a String
 */

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

// @lc code=start
class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> targetMap = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> windowMap = new HashMap<>();
        int need = 0;

        // [lo, hi]
        int lo = 0, hi = 0;
        while (hi < s.length()) {
            char c = s.charAt(hi);
            hi++;
            if (targetMap.containsKey(c)) {
                int count = windowMap.getOrDefault(c, 0) + 1;
                windowMap.put(c, count);
                if (count == targetMap.get(c)) {
                    need++;
                }
            }

            while (hi - lo >= p.length()) {
                if (need == targetMap.size()) {
                    res.add(lo);
                }

                char d = s.charAt(lo);
                lo++;
                if (targetMap.containsKey(d)) {
                    int count = windowMap.get(d);
                    if (count == targetMap.get(d)) {
                        need--;
                    }
                    windowMap.put(d, count - 1);
                }

            }
        }

        return res;
    }
}
// @lc code=end

/*
// @lcpr case=start
// "cbaebabacd"\n"abc"\n
// @lcpr case=end

// @lcpr case=start
// "abab"\n"ab"\n
// @lcpr case=end

 */
