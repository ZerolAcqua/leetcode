/*
 * @lc app=leetcode id=525 lang=java
 * @lcpr version=20004
 *
 * [525] Contiguous Array
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start

class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int preSum = 0;
        int res = 0;
        HashMap<Integer, Integer> val2Idx = new HashMap<>();
        val2Idx.put(0, 0);
        for (int i = 1; i <= n; i++) {
            preSum += (nums[i - 1] == 1 ? 1 : -1);
            if (!val2Idx.containsKey(preSum)) {
                val2Idx.put(preSum, i);
            } else {
                res = Math.max(i - val2Idx.get(preSum), res);
            }

        }

        return res;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [0,1]\n
// @lcpr case=end

// @lcpr case=start
// [0,1,0]\n
// @lcpr case=end

 */
