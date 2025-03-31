/*
 * @lc app=leetcode id=128 lang=java
 * @lcpr version=30103
 *
 * [128] Longest Consecutive Sequence
 */

import java.util.HashSet;

// @lc code=start
class Solution {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();

        for (int num : nums) {
            hs.add(num);
        }

        int res = 0;

        for (int num : hs) {
            if (hs.contains(num - 1)) {
                continue;
            }

            int length = 0;
            while (hs.contains(num + length)) {
                length++;
            }

            res = Math.max(res, length);
        }

        return res;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [100,4,200,1,3,2]\n
// @lcpr case=end

// @lcpr case=start
// [0,3,7,2,5,8,4,6,0,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,0,1,2]\n
// @lcpr case=end

 */
