/*
 * @lc app=leetcode id=560 lang=java
 * @lcpr version=20004
 *
 * [560] Subarray Sum Equals K
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start

class Solution {

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        int preSum = 0;
        int res = 0;
        HashMap<Integer, Integer> val2Count = new HashMap<>();

        val2Count.put(0, 1);

        for (int i = 1; i <= n; i++) {
            preSum += nums[i - 1];
            int expectVal = preSum - k;
            if (val2Count.containsKey(expectVal)) {
                res += val2Count.get(expectVal);
            }

            if (val2Count.containsKey(preSum)) {
                val2Count.put(preSum, val2Count.get(preSum) + 1);
            } else {
                val2Count.put(preSum, 1);
            }
        }

        return res;

    }
}
// @lc code=end

/*
// @lcpr case=start
// [1,1,1]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3]\n3\n
// @lcpr case=end

 */
