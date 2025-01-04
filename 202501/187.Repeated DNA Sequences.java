/*
 * @lc app=leetcode id=187 lang=java
 * @lcpr version=20004
 *
 * [187] Repeated DNA Sequences
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start

class Solution {

    static final int width = 10;

    public List<String> findRepeatedDnaSequences(String s) {
        int[] nums = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'A':
                    nums[i] = 0;
                    break;
                case 'C':
                    nums[i] = 1;
                    break;
                case 'G':
                    nums[i] = 2;
                    break;
                case 'T':
                    nums[i] = 3;
                    break;
            }
        }

        HashSet<Integer> seen = new HashSet<>();
        HashSet<String> res = new HashSet<>();
        int windowHash = 0;

        int left = 0, right = 0;

        while (right < nums.length) {
            windowHash = (windowHash << 2) | nums[right];
            right++;

            if (right - left == width) {
                if (seen.contains(windowHash)) {
                    res.add(s.substring(left, right));
                } else {
                    seen.add(windowHash);
                }
                windowHash &= (1 << (width * 2 - 2)) - 1;
                left++;
            }
        }

        return new ArrayList<>(res);
    }
}
// @lc code=end

/*
// @lcpr case=start
// "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"\n
// @lcpr case=end

// @lcpr case=start
// "AAAAAAAAAAAAA"\n
// @lcpr case=end

 */
