/*
 * @lc app=leetcode id=1124 lang=java
 * @lcpr version=20004
 *
 * [1124] Longest Well-Performing Interval
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start

class Solution {

    public int longestWPI(int[] hours) {
        int n = hours.length;
        int preSum = 0;

        HashMap<Integer, Integer> val2Idx = new HashMap<>();
        val2Idx.put(0, 0);

        int res = 0;

        for (int i = 1; i <= n; i++) {
            preSum += (hours[i - 1] > 8 ? 1 : -1);
            if (preSum > 0) {
                res = Math.max(res, i);
            } else {
                int need = preSum - 1;
                if (val2Idx.containsKey(need)) {
                    res = Math.max(res, i - val2Idx.get(need));
                }
                if (!val2Idx.containsKey(preSum)) {
                    val2Idx.put(preSum, i);
                }
            }
        }

        return res;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [9,9,6,0,6,6,9]\n
// @lcpr case=end

// @lcpr case=start
// [6,6,6]\n
// @lcpr case=end

 */
