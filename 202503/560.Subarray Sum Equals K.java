/*
 * @lc app=leetcode id=560 lang=java
 * @lcpr version=30103
 *
 * [560] Subarray Sum Equals K
 */

import java.util.HashMap;

// @lc code=start
class Solution {

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int res = 0;

        HashMap<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);

        for (int i = 1; i <= n; i++) {
            int num = preSum[i];
            if (count.containsKey(num - k)) {
                res += count.get(num - k);
            }
            count.put(num, count.getOrDefault(num, 0) + 1);
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
