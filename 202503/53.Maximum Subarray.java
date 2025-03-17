/*
 * @lc app=leetcode id=53 lang=java
 * @lcpr version=30100
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int dp = nums[0];
        int res = dp;
        for (int i = 1; i < n; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            res = Math.max(dp, res);
        }

        return res;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [-2,1,-3,4,-1,2,1,-5,4]\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

// @lcpr case=start
// [5,4,-1,7,8]\n
// @lcpr case=end

 */
