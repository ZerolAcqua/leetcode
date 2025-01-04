/*
 * @lc app=leetcode id=974 lang=java
 * @lcpr version=20004
 *
 * [974] Subarray Sums Divisible by K
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int preSum = 0;

        int res = 0;
        HashMap<Integer, Integer> val2count = new HashMap<>();
        val2count.put(0, 1);

        for (int i = 1; i <= n; i++) {
            preSum += nums[i-1];
            int left = preSum % k;
            if (left < 0) {
                left += k;
            }
            if (val2count.containsKey(left)) {
                int count = val2count.get(left);
                res += count;
                val2count.put(left, count + 1);
            } else {
                val2count.put(left, 1);
            }
        }

        return res;

    }
}
// @lc code=end



/*
// @lcpr case=start
// [4,5,0,-2,-3,1]\n5\n
// @lcpr case=end

// @lcpr case=start
// [5]\n9\n
// @lcpr case=end

 */

