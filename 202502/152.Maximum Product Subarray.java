/*
 * @lc app=leetcode id=152 lang=java
 * @lcpr version=30005
 *
 * [152] Maximum Product Subarray
 */

// @lcpr-template-start
// @lcpr-template-end
// @lc code=start

class Solution {

    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dpMin = new int[nums.length];
        int[] dpMax = new int[nums.length];

        dpMin[0] = nums[0];
        dpMax[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                dpMin[i] = Math.min(dpMin[i - 1] * nums[i], nums[i]);
                dpMax[i] = Math.max(dpMax[i - 1] * nums[i], nums[i]);
            } else if (nums[i] < 0) {
                dpMin[i] = Math.min(dpMax[i - 1] * nums[i], nums[i]);
                dpMax[i] = Math.max(dpMin[i - 1] * nums[i], nums[i]);
            } else {
                dpMin[i] = 0;
                dpMax[i] = 0;
            }
        }

        int res = Integer.MIN_VALUE;

        for (int num : dpMax) {
            res = Math.max(res, num);
        }

        return res;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [2,3,-2,4]\n
// @lcpr case=end

// @lcpr case=start
// [-2,0,-1]\n
// @lcpr case=end

 */
