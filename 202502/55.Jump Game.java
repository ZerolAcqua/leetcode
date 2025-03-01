/*
 * @lc app=leetcode id=55 lang=java
 * @lcpr version=30005
 *
 * [55] Jump Game
 */

// @lcpr-template-start
// @lcpr-template-end
// @lc code=start
class Solution {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int p = 0;

        for (int i = 0; i < n && i <= p; i++) {
            p = Math.max(i + nums[i], p);
        }

        return p >= n - 1;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [2,3,1,1,4]\n
// @lcpr case=end

// @lcpr case=start
// [3,2,1,0,4]\n
// @lcpr case=end

 */
